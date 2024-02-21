package com.ispan.eeit69.service;

import com.ispan.eeit69.model.DiscountTypeImage;

public interface DiscountTypeImageService {
	  void save(DiscountTypeImage image);
	    DiscountTypeImage findByDiscountType(String discountType);
}
