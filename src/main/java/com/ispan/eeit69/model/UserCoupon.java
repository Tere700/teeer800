package com.ispan.eeit69.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userCoupon_Table")
public class UserCoupon implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_coupon_id; // 用戶優惠券的唯一識別符。
	private Integer user_id; // 用戶的唯一識別符，用於關聯用戶。
	private Integer coupon_id; // 關聯的優惠券的ID。
	private Boolean used; // 標識優惠券是否已經使用。
	private Timestamp used_at; // 如果優惠券已使用，則記錄使用日期時間戳。
	private Timestamp created_at; // 創建日期時間戳。

	public UserCoupon() {
		super();
	}

	public UserCoupon(Integer user_coupon_id, Integer user_id, Integer coupon_id, Boolean used, Timestamp used_at,
			Timestamp created_at) {
		super();
		this.user_coupon_id = user_coupon_id;
		this.user_id = user_id;
		this.coupon_id = coupon_id;
		this.used = used;
		this.used_at = used_at;
		this.created_at = created_at;
	}

	@ManyToMany(fetch = FetchType.EAGER) // 及時加載 or FetchType.LAZYFetchType.LAZY延遲加載
	@JoinTable(name = "user_coupon_available_coupons", joinColumns = @JoinColumn(name = "user_coupon_id"), inverseJoinColumns = @JoinColumn(name = "coupon_id"))
	private Set<Coupon> availableCoupons = new HashSet<>();
	// 下拉式選單關聯可以查找可用的優惠卷

	public Set<Coupon> getAvailableCoupons() {
		return availableCoupons;
	}

	public void setAvailableCoupons(Set<Coupon> availableCoupons) {
		this.availableCoupons = availableCoupons;
	}

	public Integer getUser_coupon_id() {
		return user_coupon_id;
	}

	public void setUser_coupon_id(Integer user_coupon_id) {
		this.user_coupon_id = user_coupon_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(Integer coupon_id) {
		this.coupon_id = coupon_id;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	public Timestamp getUsed_at() {
		return used_at;
	}

	public void setUsed_at(Timestamp used_at) {
		this.used_at = used_at;
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
		  return "UserCoupon{" +
		            "user_coupon_id=" + user_coupon_id +
		            ", user_id=" + user_id +
		            ", coupon_id=" + coupon_id +
		            ", used=" + used +
		            ", used_at=" + used_at +
		            ", created_at=" + created_at +
		            ", availableCoupons=" + availableCoupons +
		            '}';
	}

}
