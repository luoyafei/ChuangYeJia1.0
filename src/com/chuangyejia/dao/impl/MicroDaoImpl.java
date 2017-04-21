package com.chuangyejia.dao.impl;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.chuangyejia.bean.MicroRecord;

@Component(value="md")
public class MicroDaoImpl {

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public boolean saveMicro(MicroRecord mr) {
		try {
			hibernateTemplate.save(mr);
			return true;
		} catch(DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}
}
