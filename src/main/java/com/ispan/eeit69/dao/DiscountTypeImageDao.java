package com.ispan.eeit69.dao;

import com.ispan.eeit69.model.DiscountTypeImage;

public interface DiscountTypeImageDao {
	void save(DiscountTypeImage image);
	DiscountTypeImage findByDiscountType(String discountType);// 根據ID查找優惠券
}