package com.ispan.eeit69.dao.impl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.ispan.eeit69.dao.UserCouponDao;
import com.ispan.eeit69.model.UserCoupon;

@Repository
public class UserCouponDaoImpl implements UserCouponDao {


	@PersistenceContext
	EntityManager  entityManager;
	


	@Override
	public void createUserCoupon(UserCoupon usercoupon) {
		entityManager.persist(usercoupon);
	}

	@Override
	public void updateUserCoupon(UserCoupon usercoupon) { 
		entityManager.merge(usercoupon);
	}

	@Override
	public void deleteUserCoupon(Integer usercouponIdToDelete) {
		String hql = "DELETE FROM UserCoupon uc WHERE uc.user_coupon_id = :id";
		entityManager.createQuery(hql)
		             .setParameter("id", usercouponIdToDelete)
		             .executeUpdate();
	}
	
	@Override
	public UserCoupon findByUserCouponId(Integer usercouponIdToFind) {	
		UserCoupon result = null;
		String hql = "FROM UserCoupon uc WHERE uc.user_coupon_id = :eid";
		List<UserCoupon>  usercoupons = entityManager.createQuery(hql, UserCoupon.class)
			                           			 .setParameter("eid", usercouponIdToFind)
		                           			 	 .getResultList();
		if (usercoupons.size() > 0) {
			result = usercoupons.get(0);
		}
		return result;
	}
	

	@Override
	public List<UserCoupon> findAllUserCoupons() {	
		String hql = "FROM UserCoupon";
		List<UserCoupon> usercoupons = entityManager.createQuery(hql, UserCoupon.class)
				                                 .getResultList();
		return usercoupons;
	}

	@Override
	public List<UserCoupon> findByUserId(Integer userId) {	
		String hql = "FROM UserCoupon uc WHERE uc.user_id = :userId";
		List<UserCoupon> userCouponsForUser = entityManager.createQuery(hql, UserCoupon.class)
				 								 .setParameter("userId", userId)
				                                 .getResultList();
		return userCouponsForUser;
	}	

	@Override
	public List<UserCoupon> findByUserIdAndUsageStatus (Integer userId, boolean used){
		String hql = "FROM UserCoupon uc WHERE uc.user_id = :userId AND uc.used = :used";
		List<UserCoupon> couponUsageStatus = entityManager.createQuery(hql, UserCoupon.class)
												.setParameter("userId", userId)
												.setParameter("used", used)
				                                .getResultList();
		return couponUsageStatus;
	}
	
	@Override
	public List<UserCoupon>findByCreatedAtBetween(Date startDate, Date endDate){
		String hql = "FROM UserCoupon uc WHERE uc.created_at BETWEEN :start AND :end";
		//提供兩個創建時間點，找出這兩個時間點內有創建的優惠卷。
		List<UserCoupon> CreatDateBetween = entityManager.createQuery(hql, UserCoupon.class)
												.setParameter("start", startDate)
												.setParameter("end", endDate)
												.getResultList();
		return CreatDateBetween;
	}
	
	
}
