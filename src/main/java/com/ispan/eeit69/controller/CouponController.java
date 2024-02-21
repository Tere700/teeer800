package com.ispan.eeit69.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ispan.eeit69.model.Coupon;
import com.ispan.eeit69.service.CouponService;

@Controller
@RequestMapping("/coupons")
public class CouponController {

	 @Autowired
	    private CouponService couponService;
	 
	 @GetMapping("/showCoupons")
	 public String showCoupons(Model model) {
	     List<Coupon> coupons = couponService.findAllCoupons();
	     model.addAttribute("coupons",coupons);
	     System.out.println("Fetched coupons:EEQQ " + coupons); 
	     return "coupon";
	 }
	
	 @GetMapping("/all")
    public List<Coupon> getAllCoupons() {
		    List<Coupon> coupons = couponService.findAllCoupons();
		    System.out.println("Fetched coupons: " + coupons);  // 或使用Logger
		    return coupons;
    }
	
	 @GetMapping("/{id}")
	    public Coupon getCouponById(@PathVariable Integer id) {
	        return couponService.findByCouponId(id);
	    }
	
    @PostMapping("/create")
    public String createCoupon(@ModelAttribute Coupon coupon) {
        couponService.createCoupon(coupon);
        return "redirect:/coupons"; // 重定向到優惠卷列表页面
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Coupon coupon) {
        couponService.updateCoupon(coupon);
        return "redirect:/coupons"; // 重定向到優惠卷列表页面
    }
    
    @PostMapping("/delete/{id}")
    public String deleteCoupon(@PathVariable Integer id) {
        couponService.deleteCoupon(id);
        return "redirect:/coupons"; // 重定向到優惠卷列表页面
    }
    
}