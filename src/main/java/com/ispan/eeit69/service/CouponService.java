package com.ispan.eeit69.service;

import java.util.List;

import com.ispan.eeit69.model.Coupon;

public interface CouponService {
	void resetCouponTable(); //清理過期優惠券
	void createCoupon (Coupon coupon);// 建立新的優惠券
	void updateCoupon(Coupon coupon);
	void deleteCoupon(Integer couponId);// 刪除優惠券
	Coupon findByCouponId(Integer couponId);// 根據ID查找優惠券
	List<Coupon> findAllAvailableCoupons(); //下拉式選單找可以使用的優惠卷
	List<Coupon> findAllCoupons();
}
