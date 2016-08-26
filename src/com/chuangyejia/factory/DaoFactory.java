package com.chuangyejia.factory;

import com.chuangyejia.dao.IApplyContractDao;
import com.chuangyejia.dao.IInviteContractDao;
import com.chuangyejia.dao.IProductDao;
import com.chuangyejia.dao.IStartupsDao;
import com.chuangyejia.dao.IUserDao;
import com.chuangyejia.dao.impl.ApplyContractDaoImpl;
import com.chuangyejia.dao.impl.InviteContractDaoImpl;
import com.chuangyejia.dao.impl.ProductDaoImpl;
import com.chuangyejia.dao.impl.StartupsDaoImpl;
import com.chuangyejia.dao.impl.UserDaoImpl;

public class DaoFactory {

	public static IUserDao createUserDao() {
		return new UserDaoImpl();
	}
	
	public static IStartupsDao createStartupsDao() {
		return new StartupsDaoImpl();
	}
	
	public static IApplyContractDao createApplyContractDao() {
		return new ApplyContractDaoImpl();
	}
	
	public static IInviteContractDao createInviteContractDao() {
		return new InviteContractDaoImpl();
	}
	
	public static IProductDao createProductDao() {
		return new ProductDaoImpl();
	}
}
