package com.ispan.eeit69.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupon_table")
public class Coupon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer coupon_id; //優惠券的唯一識別符。
	@Column(name = "discount_type")
	private String discount_type; //折扣類型（例如滿千送百或8折卷）。
	private Float discount_amount; //折扣金額（例如100元或20%）。
	private Timestamp valid_from; //優惠券的有效期開始日期。
	private Timestamp valid_to; //優惠券的有效期結束日期。
	private Boolean is_active; //標識優惠券是否處於活動狀態。
	private Timestamp created_at; //創建日期時間戳。
	
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Coupon(Integer coupon_id, String discount_type, Float discount_amount, Timestamp valid_from,
			Timestamp valid_to, Boolean is_active, Timestamp created_at) {
		super();
		this.coupon_id = coupon_id;
		this.discount_type = discount_type;
		this.discount_amount = discount_amount;
		this.valid_from = valid_from;
		this.valid_to = valid_to;
		this.is_active = is_active;
		this.created_at = created_at;
	}


	public Integer getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(Integer coupon_id) {
		this.coupon_id = coupon_id;
	}

	public String getDiscount_type() {
		return discount_type;
	}

	public void setDiscount_type(String discount_type) {
		this.discount_type = discount_type;
	}

	public Float getDiscount_amount() {
		return discount_amount;
	}

	public void setDiscount_amount(Float discount_amount) {
		this.discount_amount = discount_amount;
	}

	public Timestamp getValid_from() {
		return valid_from;
	}

	public void setValid_from(Timestamp valid_from) {
		this.valid_from = valid_from;
	}

	public Timestamp getValid_to() {
		return valid_to;
	}

	public void setValid_to(Timestamp valid_to) {
		this.valid_to = valid_to;
	}

	public Boolean getIs_active() {
		return is_active;
	}

	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Coupon [coupon_id=" + coupon_id + ", discount_type=" + discount_type + ", discount_amount="
				+ discount_amount + ", valid_from=" + valid_from + ", valid_to=" + valid_to + ", is_active=" + is_active
				+ ", created_at=" + created_at + "]";
	}

}
