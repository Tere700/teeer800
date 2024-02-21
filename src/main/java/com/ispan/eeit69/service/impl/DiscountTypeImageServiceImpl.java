package com.ispan.eeit69.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.eeit69.dao.CouponDao;
import com.ispan.eeit69.dao.DiscountTypeImageDao;
import com.ispan.eeit69.model.Coupon;
import com.ispan.eeit69.model.DiscountTypeImage;
import com.ispan.eeit69.service.CouponService;
import com.ispan.eeit69.service.DiscountTypeImageService;

@Service
@Transactional
public class DiscountTypeImageServiceImpl implements DiscountTypeImageService {

	DiscountTypeImageDao discountTypeImageDao;
	
//	@Autowired
	private DiscountTypeImageDao imageDao;

	@Override
	public void  save(DiscountTypeImage image) {
		imageDao.save(image);
	}

	@Override
	public DiscountTypeImage findByDiscountType(String discountType) {
		return imageDao.findByDiscountType(discountType);
	}
}
