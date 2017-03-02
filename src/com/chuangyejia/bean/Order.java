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

import org.hibernate.annotations.GenericGenerator;
/**
 * 订单类
 * @author Diamond
 */
@Entity
@Table(name="productOrder")
public class Order {
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId + ", unitPrice=" + unitPrice + ", productCount="
				+ productCount + ", userid=" + userid + ", startupsId=" + startupsId + ", addr=" + addr + ", status="
				+ status + ", orderDate=" + orderDate + ", isSigned=" + isSigned + ", signedName=" + signedName
				+ ", signedDate=" + signedDate + "]";
	}
	private String orderId = null;
	private Product productId = null;
	private String unitPrice = "0";				//单价
	private int productCount = 0;				//个数
	private User userid = null;					//买方
	private Startups startupsId = null;			//卖方
	private String addr = null;					//地址
	private String status = "0";				//状态(0:订单未创建；1:订单未支付；2:订单成功；3：订单失败； 4:订单作废；5：订单结束中；订单结束)
	private Timestamp orderDate = null;
	private String isSigned = "0";				//--是否签收(0:未签收，1:已签收，2：已上传凭证;)
	private String signedName = null;			//签单人姓名
	private Timestamp signedDate = null;		//签收时间
	private String certificate = null;			//凭证
	
	@Id
	@GenericGenerator(name="uuid", strategy="uuid")
	@GeneratedValue(generator="uuid")
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinColumn(name="productId")
	public Product getProductId() {
		return productId;
	}
	public void setProductId(Product productId) {
		this.productId = productId;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn(name="startupsId")
	public Startups getStartupsId() {
		return startupsId;
	}
	public void setStartupsId(Startups startupsId) {
		this.startupsId = startupsId;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public String getIsSigned() {
		return isSigned;
	}
	public void setIsSigned(String isSigned) {
		this.isSigned = isSigned;
	}
	public String getSignedName() {
		return signedName;
	}
	public void setSignedName(String signedName) {
		this.signedName = signedName;
	}
	public Timestamp getSignedDate() {
		return signedDate;
	}
	public void setSignedDate(Timestamp signedDate) {
		this.signedDate = signedDate;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
}