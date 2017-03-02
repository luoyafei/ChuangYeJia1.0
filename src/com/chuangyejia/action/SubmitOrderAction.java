package com.chuangyejia.action;

import java.math.BigDecimal;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Order;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IOrderService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("submitOrderAction")
@Scope("prototype")
public class SubmitOrderAction extends ActionSupport {

	private String addrInfo;
	public String getAddrInfo() {
		return addrInfo;
	}
	public void setAddrInfo(String addrInfo) {
		this.addrInfo = addrInfo;
	}
	
	private IOrderService ios;
	public IOrderService getIos() {
		return ios;
	}
	@Resource(name="iosi")
	public void setIos(IOrderService ios) {
		this.ios = ios;
	}
	
	@Override
	public String execute() {

//System.out.println(addrInfo);
//System.out.println(ServletActionContext.getRequest().getSession().getAttribute("orders"));

		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		Order[] orders = (Order[]) request.getSession().getAttribute("orders");
		Gson gson = new Gson();
		boolean success = false;
		String WIDout_trade_no = "";
		String WIDsubject = "chuangyejiaService";
		String WIDtotal_fee = "";
		
		BigDecimal bd = new BigDecimal("0");
		
		if(user != null && orders != null && orders.length > 0 && addrInfo != null) {
			
			AddrInfo addr = gson.fromJson(addrInfo, AddrInfo.class);
			if(addr.checkAddr() && addr.checkReceive()) {
				for(Order o : orders) {
					String orderId = UUID.randomUUID().toString().replaceAll("-", "");
					o.setOrderId(orderId);
					WIDout_trade_no += orderId;
					//WIDsubject += o.getProductId().getProductName();
					
					bd = bd.add(new BigDecimal(new Double(o.getUnitPrice())*o.getProductCount()));
					
					o.setStatus("1");//未付款
					o.setAddr(addr.getProvince() + " " + addr.getCity() + " " + addr.getDistrict() + " " + addr.getDetailAddr() + " 接收人：" + addr.getReceiveName() + " " + addr.getReceiveTel());
				}
				if(ios.saveOrders(orders)) {
					request.getSession().setAttribute("orders", orders);
					WIDtotal_fee = bd.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
					success = true;
				}
			}
		}
		if(success) {
			request.setAttribute("WIDout_trade_no", WIDout_trade_no);
			request.setAttribute("WIDsubject", WIDsubject);
			request.setAttribute("WIDtotal_fee", WIDtotal_fee);
			
			request.getSession().setAttribute("orders", orders);
//System.out.println(WIDtotal_fee);
			return SUCCESS;
		} else
			return ERROR;
	}

	/**
	 * 辅助接收class
	 * @author Diamond
	 */
	private static class AddrInfo {
		private String province;
		private String city;
		private String district;
		private String detailAddr;
		private String receiveName;
		private String receiveTel;
		public AddrInfo(String province, String city, String district, String detailAddr, String receiveName,
				String receiveTel) {
			this.province = province;
			this.city = city;
			this.district = district;
			this.detailAddr = detailAddr;
			this.receiveName = receiveName;
			this.receiveTel = receiveTel;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public String getDetailAddr() {
			return detailAddr;
		}
		public void setDetailAddr(String detailAddr) {
			this.detailAddr = detailAddr;
		}
		public String getReceiveName() {
			return receiveName;
		}
		public void setReceiveName(String receiveName) {
			this.receiveName = receiveName;
		}
		public String getReceiveTel() {
			return receiveTel;
		}
		public void setReceiveTel(String receiveTel) {
			this.receiveTel = receiveTel;
		}
		private static boolean checkField(String field, int min, int max) {
			return field != null && field.length() >= min && field.length() <= max;
		}
		public boolean checkAddr() {
			return this.checkField(province, 1, 8) && this.checkField(city, 1, 10) && this.checkField(district, 1, 10) && this.checkField(detailAddr, 1, 255);
		}
		public boolean checkReceive() {
			return receiveName != null && receiveName.length() >= 1 && receiveName.length() <= 5 && receiveTel != null && receiveTel.matches("\\d{11}");
		}
		
	}
}
