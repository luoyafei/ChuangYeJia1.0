package com.chuangyejia.bean;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="product")
public class Product {

	private String productId;
	private String productName;
	private Startups productStartups;
	private Timestamp productCreateDate;
	private String productPrice;
	private String productBrief;
	private String productDetail;
	private String productCover;
	private String productAddress;
	
	@Id
	@GenericGenerator(name="uuid", strategy="uuid")
	@GeneratedValue(generator="uuid")
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name="productStartupsId")
	public Startups getProductStartups() {
		return productStartups;
	}
	public void setProductStartups(Startups productStartups) {
		this.productStartups = productStartups;
	}
	
	/**
	 * 构建一个可以直接获取String类型的日期
	 * @return String
	 */
	@Transient
	public String getUserCreateDateStringTime() {
		if(productCreateDate == null)
			productCreateDate = new Timestamp(System.currentTimeMillis());
		return productCreateDate.toString();
	}
	public Timestamp getProductCreateDate() {
		getUserCreateDateStringTime();
		return productCreateDate;
	}
	public void setProductCreateDate(Timestamp productCreateDate) {
		this.productCreateDate = productCreateDate;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductBrief() {
		return productBrief;
	}
	public void setProductBrief(String productBrief) {
		this.productBrief = productBrief;
	}
	public String getProductDetail() {
		return productDetail;
	}
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
	public String getProductCover() {
		return productCover;
	}
	public void setProductCover(String productCover) {
		this.productCover = productCover;
	}
	public String getProductAddress() {
		return productAddress;
	}
	public void setProductAddress(String productAddress) {
		this.productAddress = productAddress;
	}
	
}
