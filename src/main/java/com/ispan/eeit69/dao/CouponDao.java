package com.ispan.eeit69.dao;

import java.util.List;

import com.ispan.eeit69.CouponNotFoundException;
import com.ispan.eeit69.model.Coupon;


public interface CouponDao {
	void resetCouponTable(); //清理過期優惠卷
	void createCoupon (Coupon coupon);// 建立新的優惠券
	void updateCoupon(Coupon coupon);
	void deleteCoupon(Integer couponId);// 刪除優惠券
	Coupon findByCouponId(Integer couponId) throws CouponNotFoundException;// 根據ID查找優惠券
	List<Coupon> findAllCoupons();	
	List<Coupon> findAllAvailableCoupons();//查詢所有可用的優惠卷
}
