package com.ispan.eeit69.model;

import java.io.Serializable;
import java.sql.Clob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discountTypeImage_table")
public class DiscountTypeImage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer image_id;
	private String discount_type;  //關聯到Coupon表的discount_type
	private Clob image_data;  //圖片的二進制數據
	
	public DiscountTypeImage() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public DiscountTypeImage(Integer image_id, String discount_type, Clob image_data) {
		super();
		this.image_id = image_id;
		this.discount_type = discount_type;
		this.image_data = image_data;
	}

	public Integer getImage_id() {
		return image_id;
	}

	public void setImage_id(Integer image_id) {
		this.image_id = image_id;
	}

	public String getDiscount_type() {
		return discount_type;
	}

	public void setDiscount_type(String discount_type) {
		this.discount_type = discount_type;
	}

	public Clob getImage_data() {
		return image_data;
	}

	public void setImage_data(Clob image_data) {
		this.image_data = image_data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DiscountTypeImage [image_id=" + image_id + ", discount_type=" + discount_type + ", image_data="
				+ image_data + "]";
	}

}
