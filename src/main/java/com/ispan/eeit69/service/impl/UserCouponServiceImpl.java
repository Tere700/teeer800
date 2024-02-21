package com.ispan.eeit69.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit69.dao.UserCouponDao;
import com.ispan.eeit69.model.UserCoupon;
import com.ispan.eeit69.service.UserCouponService;

@Service
@Transactional
public class UserCouponServiceImpl implements UserCouponService {

	UserCouponDao usercouponDao;
	
//	@Autowired
	public UserCouponServiceImpl(UserCouponDao usercouponDao) {
		this.usercouponDao = usercouponDao;
	}

	@Override
	public void createUserCoupon(UserCoupon userCoupon) {
		usercouponDao.createUserCoupon(userCoupon);
	}

	@Override
	public void updateUserCoupon(UserCoupon userCoupon) {
		usercouponDao.updateUserCoupon(userCoupon);;
	}
	
	@Override
	public void deleteUserCoupon(Integer userCouponId) {
		usercouponDao.deleteUserCoupon(userCouponId);;
	}

	@Override
	public UserCoupon findByUserCouponId(Integer userCouponId) {
		return usercouponDao.findByUserCouponId(userCouponId);
	}

	@Override
	public List<UserCoupon> findAllUserCoupons() {
		return usercouponDao.findAllUserCoupons();
		}
	
	@Override
	public List<UserCoupon> findByUserId(Integer userId){
	    return usercouponDao.findByUserId(userId);
	}
	
	@Override
	public List<UserCoupon> findByUserIdAndUsageStatus(Integer userId, boolean used) {
	    return usercouponDao.findByUserIdAndUsageStatus(userId, used);
	}
	
	@Override
	public List<UserCoupon>findByCreatedAtBetween(Date startDate, Date endDate){
	    return usercouponDao.findByCreatedAtBetween(startDate, endDate);
	}
}
