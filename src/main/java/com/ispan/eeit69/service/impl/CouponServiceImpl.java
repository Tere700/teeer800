package com.ispan.eeit69.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit69.dao.CouponDao;
import com.ispan.eeit69.model.Coupon;
import com.ispan.eeit69.service.CouponService;

@Service
@Transactional
public class CouponServiceImpl implements CouponService {

	CouponDao couponDao;
	
//	@Autowired
	public CouponServiceImpl(CouponDao couponDao) {
		this.couponDao = couponDao;
	}

	@Override
	public void resetCouponTable() {
		couponDao.resetCouponTable();
	}

	@Override
	public void createCoupon(Coupon coupon) {
		couponDao.createCoupon(coupon);
	}

	@Override
	public void updateCoupon(Coupon coupon) {
		couponDao.updateCoupon(coupon);
	}
	
	@Override
	public void deleteCoupon(Integer couponId) {
		couponDao.deleteCoupon(couponId);
	}

	@Override
	public Coupon findByCouponId(Integer couponId) {
		return couponDao.findByCouponId(couponId);
	}

	@Override
	public List<Coupon> findAllCoupons() {
		//return couponDao.findAllCoupons();
	    List<Coupon> coupons = couponDao.findAllCoupons();
	    System.out.println("Coupons fetched: " + coupons);  // 或使用Logger
	    return coupons;
		}
	
	@Override
	public List<Coupon> findAllAvailableCoupons() {
	    return couponDao.findAllAvailableCoupons();
	}
}
