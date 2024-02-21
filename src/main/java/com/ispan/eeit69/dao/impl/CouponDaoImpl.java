package com.ispan.eeit69.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ispan.eeit69.dao.CouponDao;
import com.ispan.eeit69.model.Coupon;

@Repository
public class CouponDaoImpl implements CouponDao {


	@PersistenceContext
	EntityManager  entityManager;
	
	@Override
	public void resetCouponTable() { //清理過期優惠卷
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
	    String jpql = "DELETE FROM Coupon c WHERE c.valid_to < :currentTimestamp";
	    //冒號(佔位符號) : 在JPQL中通常用作命名參數的前綴符號，用於指定要在查詢中替換的值。在你的JPQL查詢中，:currentTimestamp 是一個命名參數，它表示一個要在執行查詢之前設置的值。 
	    int deletedCount = entityManager.createQuery(jpql)
	        .setParameter("currentTimestamp", currentTimestamp)
	        .executeUpdate();
	    System.out.println("Deleted " + deletedCount + " expired coupons.");// 返回已清理的優惠券數量
	}
	@Override
	public void createCoupon(Coupon coupon) {
		entityManager.persist(coupon);
	}

	@Override
	public void updateCoupon(Coupon coupon) { 
		entityManager.merge(coupon);
//		Coupon tmp = findByCouponId(coupon.getCoupon_id());
//		coupon.setCreated_at(tmp.getCreated_at());
//		entityManager.detach(tmp);
	}

	@Override
	public void deleteCoupon(Integer couponIdToDelete) {
		String hql = "DELETE FROM Coupon e WHERE e.coupon_id = :id";
		//JPQL（Java Persistence Query Language）
		entityManager.createQuery(hql)
		             .setParameter("id", couponIdToDelete)
		             .executeUpdate();
	}
	
	@Override
	public Coupon findByCouponId(Integer couponIdToFind) {	
		Coupon result = null;
		//存儲查找到的優惠券。
		String hql = "FROM Coupon WHERE coupon_id = :eid";
		List<Coupon>  coupons = entityManager.createQuery(hql, Coupon.class)
			                           			 .setParameter("eid", couponIdToFind)
		                           			 	 .getResultList();
		if (coupons.size() > 0) {
			//檢查結果列表是否包含至少一個優惠券對象。
			result = coupons.get(0);
			//coupons陣列第一個元素，確保我們獲取到的是查找到的唯一一個優惠券（如果存在的話）。
		}
		return result;
	}
	

	@Override
	public List<Coupon> findAllCoupons() {	
		String hql = "FROM Coupon";//JPQL
		List<Coupon> allCoupons = entityManager.createQuery(hql, Coupon.class)
				                                 .getResultList();//返回一個結果列表，其中包含所有優惠券的對象。
		return allCoupons;
	}
	
	@Override
	public List<Coupon> findAllAvailableCoupons() {
	    String jpql = "SELECT c FROM Coupon c WHERE c.is_active = true";
	    return entityManager.createQuery(jpql, Coupon.class).getResultList();
	}


}
