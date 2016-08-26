package com.chuangyejia.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.chuangyejia.bean.Startups;
import com.chuangyejia.dao.IStartupsDao;
import com.chuangyejia.service.IStartupsService;
import com.chuangyejia.tools.StartupsTempShow;

@Component(value="ss")
public class StartupsServiceImpl implements IStartupsService {

	private IStartupsDao sd;
	
	public IStartupsDao getSd() {
		return sd;
	}
	@Resource(name="sd")
	public void setSd(IStartupsDao sd) {
		this.sd = sd;
	}

	@Override
	public List<StartupsTempShow> getStartupsInCopartnerId(String copartnerId) {
		// TODO Auto-generated method stub
		List<Startups> joins = sd.getStartupsInCopartnerId(copartnerId);
		List<StartupsTempShow> sts = new ArrayList<StartupsTempShow>();

		for(int i = 0; i < joins.size(); i++) {
			sts.add(joins.get(i).toStartupsTempShow());
		}
		
		return sts;
	}

	@Override
	public boolean saveStartups(Startups startups) {
		// TODO Auto-generated method stub
		return sd.saveStartups(startups);
	}

	@Override
	public boolean updateStartups(Startups startups) {
		// TODO Auto-generated method stub
		return sd.updateStartups(startups);
	}

	@Override
	public boolean deleteStartups(Startups startups) {
		// TODO Auto-generated method stub
		return sd.deleteStartups(startups);
	}

	@Override
	public int getAllStartupsCount() {
		// TODO Auto-generated method stub
		return sd.getAllStartupsCount();
	}

	@Override
	public List<StartupsTempShow> getStartupTempShows(Integer start, Integer length, String sort) {
		// TODO Auto-generated method stub
		return sd.getStartupTempShows(start, length, sort);
	}

	@Override
	public Startups getStartupsInId(String startupsId) {
		// TODO Auto-generated method stub
		return sd.getStartupsInId(startupsId);
	}

	@Override
	public List<Startups> getStartupsInLeaderId(String leaderId) {
		// TODO Auto-generated method stub
		return sd.getStartupsInLeaderId(leaderId);
	}

	
	
	@Override
	public boolean isNameRepeat(String startupsName) {
		// TODO Auto-generated method stub
		return sd.isNameRepeat(startupsName);
	}

	@Override
	public StartupsTempShow getStartupsTempShowInId(String startupsId) {
		// TODO Auto-generated method stub
		return sd.getStartupsTempShowInId(startupsId);
	}

	

}
