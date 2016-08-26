package com.chuangyejia.factory;

import com.chuangyejia.service.IApplyContractService;
import com.chuangyejia.service.IInviteContractService;
import com.chuangyejia.service.IProductService;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.service.IUserService;
import com.chuangyejia.service.impl.ApplyContractServiceImpl;
import com.chuangyejia.service.impl.InviteContractServiceImpl;
import com.chuangyejia.service.impl.ProductServiceImpl;
import com.chuangyejia.service.impl.StartupsServiceImpl;
import com.chuangyejia.service.impl.UserServiceImpl;

public class ServiceFactory {

	public static IUserService createUserService() {
		return new UserServiceImpl();
	}
	
	public static IStartupsService createStartupsService() {
		return new StartupsServiceImpl();
	}
	
	public static IApplyContractService createApplyContractService() {
		return new ApplyContractServiceImpl();
	}			   
	
	public static IInviteContractService createInviteContractService() {
		return new InviteContractServiceImpl();
	}
	
	public static IProductService createProductService() {
		return new ProductServiceImpl();
	}
}
