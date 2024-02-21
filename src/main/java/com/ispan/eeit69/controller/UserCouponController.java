package com.ispan.eeit69.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.eeit69.model.UserCoupon;
import com.ispan.eeit69.service.UserCouponService;

@RestController
@RequestMapping("/usercoupons")
public class UserCouponController {

	 @Autowired
	    private UserCouponService userCouponService;
	
	 @GetMapping("/all")
	 public List<UserCoupon> getAllUserCoupons() {
	        return userCouponService.findAllUserCoupons();
	    }
	
	 @GetMapping("/{id}")
	    public UserCoupon getUserCouponById(@PathVariable Integer id) {
	        return userCouponService.findByUserCouponId(id);
	    }
	
    @PostMapping("/create")
    public String createUserCoupon(@ModelAttribute UserCoupon userCoupon) {
    	userCouponService.createUserCoupon(userCoupon);
        return "redirect:/usercoupons"; // 重定向到優惠卷列表页面
    }

    @PostMapping("/update")
    public String updateUserCoupon(@ModelAttribute UserCoupon userCoupon) {
    	userCouponService.updateUserCoupon(userCoupon);
        return "redirect:/usercoupons"; // 重定向到優惠卷列表页面
    }
    
    @PostMapping("/delete/{id}")
    public String deleteUserCoupon(@PathVariable Integer id) {
    	userCouponService.deleteUserCoupon(id);
        return "redirect:/usercoupons"; // 重定向到優惠卷列表页面
    }
    
}