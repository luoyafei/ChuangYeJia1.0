package com.chuangyejia.service;

import java.util.List;

import com.chuangyejia.bean.Startups;
import com.chuangyejia.tools.StartupsTempShow;

/**
 * Startups对象的service层的接口
 * @author Diamond
 *
 */
public interface IStartupsService {

	/**
	 * 将Startups对象存入数据库
	 * @param startups
	 * @return boolean
	 */
	public boolean saveStartups(Startups startups);
	/**
	 * 将Startups对象进行更新处理
	 * @param startups
	 * @return boolean
	 */
	public boolean updateStartups(Startups startups);
	/**
	 * 将Startups对象删除
	 * 管理员的权限
	 * @param startups
	 * @return boolean
	 */
	public boolean deleteStartups(Startups startups);
	/**
	 * 获取此时在数据库中的Startups的总个数
	 * @return int
	 */
	public int getAllStartupsCount();
	
	/**
	 * 获取指定开始位置，指定数量的，指定排序方式的StartupsTempShow集合
	 * @param start
	 * @param length
	 * @param sort
	 * @return List<Startups>
	 */
	public List<StartupsTempShow> getStartupTempShows(Integer start, Integer length, String sort);
	/**
	 * 通过Startups对象的Id获取整个对象
	 * @param startupsId
	 * @return Startups
	 */
	public Startups getStartupsInId(String startupsId);
	/**
	 * 通过Startups对象的startupsId来获取StratupsTempShow对象
	 * @param startupsId
	 * @return
	 */
	public StartupsTempShow getStartupsTempShowInId(String startupsId);
	/**
	 * 通过 用户的Id来获取其为leader的所有公司的集合
	 * @param leaderId
	 * @return  List<Startups>
	 */
	public List<Startups> getStartupsInLeaderId(String leaderId);
	
	/**
	 * 通过 用户的Id来获取其为成员的所有公司的集合
	 * @param leaderId
	 * @return  List<StartupsTempShow>
	 */
	public List<StartupsTempShow> getStartupsInCopartnerId(String copartnerId);
	
	
	/**
	 * 查询公司名称是否重复
	 * @param startupsName
	 * @return
	 */
	public boolean isNameRepeat(String startupsName);
}
