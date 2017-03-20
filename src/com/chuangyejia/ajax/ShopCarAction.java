package com.chuangyejia.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Order;
import com.chuangyejia.bean.Product;
import com.chuangyejia.bean.User;
import com.chuangyejia.service.IProductService;
import com.chuangyejia.service.IShopCarService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("shopCarAction")
@Scope("prototype")
public class ShopCarAction extends ActionSupport {

	private String productId;
	private String deleteProductId;//删除商品，传递过来的是json数据，进行解析成string[]
	private String settlementProducts;//结算，传递过来的是json数据
	public String getSettlementProducts() {
		return settlementProducts;
	}
	public void setSettlementProducts(String settlementProducts) {
		this.settlementProducts = settlementProducts;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDeleteProductId() {
		return deleteProductId;
	}
	public void setDeleteProductId(String deleteProductId) {
		this.deleteProductId = deleteProductId;
	}
	
	private IShopCarService iscs;
	private IProductService ps;
	public IProductService getPs() {
		return ps;
	}
	@Resource(name="ps")
	public void setPs(IProductService ps) {
		this.ps = ps;
	}
	
	public IShopCarService getIscs() {
		return iscs;
	}
	@Resource(name="iscs")
	public void setIscs(IShopCarService iscs) {
		this.iscs = iscs;
	}

	public void addItem() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {}
		
		JsonObject jo = new JsonObject();
		boolean success = true;
		String reason = "";
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		
		if(user != null) {
			if(productId != null && productId.length() == 32 && iscs.saveUserIdProductId(user.getUserId(), productId)) {
				
				@SuppressWarnings("unchecked")
				Vector<Product> products = (Vector<Product>)ServletActionContext.getRequest().getSession().getAttribute("shopCar");
				products.add(ps.getProductInId(productId.trim()));
				ServletActionContext.getRequest().getSession().setAttribute("shopCar", products);
				
				success =  true;
			} else {
				success = false;
				reason = "产品出错！";
			}
		} else {
			success = false;
			reason = "尚未登陆！";
		}
		jo.addProperty("success", success);
		jo.addProperty("reason", reason);
		
		out.print(jo.toString());
		out.flush();
		out.close();
	}
	
	private void hideFieldsInShopCar(Vector<Product> ps) {
		if(ps != null && ps.size() > 0) 
			for(int i = 0; i < ps.size(); i++) 
				ps.get(i).setProductStartups(null);
	}
	
	public void getMyShopCarItems() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {}
		
		JsonObject jo = new JsonObject();
		boolean success = true;
		String reason = "";
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user != null) {
			@SuppressWarnings("unchecked")
			Vector<Product> shopCar = (Vector<Product>)ServletActionContext.getRequest().getSession().getAttribute("shopCar");
			/**
			 * 将产品中的关键字段进行隐藏
			 */
			hideFieldsInShopCar(shopCar);
			jo.add("shopCar", new Gson().toJsonTree(shopCar));
		} else {
			success = false;
			reason = "尚未登陆！";
		}
		jo.addProperty("success", success);
		jo.addProperty("reason", reason);
		
		out.print(jo.toString());
		out.flush();
		out.close();
	}
	
	/**
	 * 用来转换从前台传输过来的ids
	 * @author Diamond
	 *
	 */
	private static class P {
		private String[] ids;
		
		public String[] getIds() {
			return ids;
		}
		public void setIds(String[] ids) {
			this.ids = ids;
		}
		
		public boolean isRrightFormat() {
			for(int i = 0; i < ids.length; i++) {
				if(ids[i].length() != 32)
					return false;
			}
			return true;
		}
	}
	/**
	 * 从购物车中删除产品
	 */
	public void deleteItem() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch(IOException e) {}
		
		JsonObject jo = new JsonObject();
		boolean success = true;
		String reason = "";
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user != null) {
			Gson gson = new Gson();
			P pIds = gson.fromJson(deleteProductId, P.class);
			if(pIds.isRrightFormat()) {
				@SuppressWarnings("unchecked")
				Vector<Product> shopCar = (Vector<Product>)ServletActionContext.getRequest().getSession().getAttribute("shopCar");
				
				if(iscs.deleteProductInShopCar(user.getUserId(), pIds.getIds())) {
					Iterator<Product> iterP = shopCar.iterator();
					for(String pId : pIds.getIds()) {
						while(iterP.hasNext()) {
							if(iterP.next().getProductId().equals(pId)) {
								iterP.remove();
								break;
							}
						}
					}
					ServletActionContext.getRequest().getSession().setAttribute("shopCar", shopCar);
				} else {
					success = false;
					reason = "删除商品失败！";
				}
			} else {
				success = false;
				reason = "产品出错";
			}
		} else {
			success = false;
			reason = "尚未登陆！";
		}
		jo.addProperty("success", success);
		jo.addProperty("reason", reason);
		
		out.print(jo.toString());
		out.flush();
		out.close();
	}
	
	/**
	 * 用以处理结算产品
	 */
	private static class ProductJson {
		@Override
		public String toString() {
			return "ProductJson [productId=" + productId + ", productCount=" + productCount + "]";
		}
		private String productId;
		private String productCount;
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public String getProductCount() {
			return productCount;
		}
		public void setProductCount(String productCount) {
			this.productCount = productCount;
		}
	}
	private static class ProductsJson {
		private ProductJson[] products;
		public ProductJson[] getProducts() {
			return products;
		}
		public void setProducts(ProductJson[] products) {
			this.products = products;
		}
	}
	
	
	
	public String execute() {
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		if(user != null) {
			Gson gson = new Gson();
			try {
				ProductsJson pjs = gson.fromJson(settlementProducts, ProductsJson.class);
				Product[] products = getProducts(pjs.getProducts());
				
				if(products != null && products.length != 0) {
					Order[] orders = new Order[products.length];
					
					for(int i = 0; i < products.length; i++) {
						Order o = new Order();
						int count = 1;
						try {
							count = Integer.parseInt(pjs.getProducts()[i].productCount);
						} catch(NumberFormatException e) {
							count = 1;
						}
						
						o.setProductCount(count);
						o.setUnitPrice(products[i].getProductPrice());
						o.setProductId(products[i]);
						o.setUserid(user);
						o.setStartupsId(products[i].getProductStartups());
						o.setOrderDate(new Timestamp(System.currentTimeMillis()));
					
						orders[i] = o;
					}
					ServletActionContext.getRequest().setAttribute("orders", orders);
					ServletActionContext.getRequest().getSession().setAttribute("orders", orders);
					
					return "toConfirmOrder";
				} else {
					this.addFieldError("error", "异常！");
					return ERROR;
				}
				
			} catch(Exception e) {
				this.addFieldError("error", "异常！");
				return ERROR;
			}
		} else {
			this.addFieldError("error", "请先进行登陆操作！");
			return ERROR;
		}
	} 
	private Product[] getProducts(ProductJson[] pids) {
		Product[] products = new Product[pids.length];
		for(int i = 0; i < pids.length; i++) {
			products[i] = ps.getProductInId(pids[i].getProductId());
		}
		return products;
	}
}
