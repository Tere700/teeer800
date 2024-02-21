package com.ispan.eeit69.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ispan.eeit69.dao.DiscountTypeImageDao;
import com.ispan.eeit69.model.DiscountTypeImage;

@Repository
public class DiscountTypeImageDaoImpl implements DiscountTypeImageDao {


	@PersistenceContext
	EntityManager  entityManager;
	
	@Override
	public void save (DiscountTypeImage image){ //清理過期優惠卷
		 entityManager.persist(image);
	}

	@Override
	public DiscountTypeImage findByDiscountType(String discountType) {
        // 實現查找特定 discount_type 的圖像的邏輯
        // 可以使用 EntityManager 執行相關查詢
        return null;
    }

}
