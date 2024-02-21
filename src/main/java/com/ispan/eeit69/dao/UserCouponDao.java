package com.ispan.eeit69.dao;

import java.util.Date;
import java.util.List;

import com.ispan.eeit69.CouponNotFoundException;
import com.ispan.eeit69.model.UserCoupon;

public interface UserCouponDao {
	void createUserCoupon (UserCoupon userCoupon);// 建立新的優惠券
	void updateUserCoupon(UserCoupon coupon);
	void deleteUserCoupon(Integer userCouponId);// 刪除優惠券
	UserCoupon findByUserCouponId(Integer userCouponId) throws CouponNotFoundException;// 根據ID查找優惠券
	List<UserCoupon> findAllUserCoupons();	
	List<UserCoupon> findByUserId(Integer userId);
	//查詢特定用戶的優惠券，這個方法接受一個用戶ID作為參數，然後查詢並返回該用戶擁有的所有優惠券。
	List<UserCoupon> findByUserIdAndUsageStatus(Integer userId, boolean used);
	//查詢已使用和未使用的優惠券，這個方法接受用戶ID和一個布爾值（用於指示優惠券是否已使用）作為參數，然後查詢並返回符合條件的優惠券列表。
	List<UserCoupon>findByCreatedAtBetween(Date startDate, Date endDate);
	//按時間範圍查詢，這個方法接受兩個日期作為參數，用於指定創建時間的範圍。它將返回在指定時間範圍內創建的優惠券。
}
