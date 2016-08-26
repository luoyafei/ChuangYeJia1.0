package com.chuangyejia.tools;

/**
 * 提供了User实体类的工具类
 * @author Diamond
 *
 */
public class UserUtil {

	/**
	 * 用于转换从前台传过来的关注领域的数字，进行文字的转换
	 */
	public final static String[] userField = {
			"其他"					//0
			,"移动互联网"			//1
			,"电子商务"				//2
			,"文化艺术"				//3
			, "教育体育"				//4
			, "汽车"					//5
			, "旅游户外"				//6
			, "房产"					//7
			, "营销广告"				//8
			, "硬件"					//9
			, "工具软件"				//10
			, "企业服务"				//11
			, "搜索安全"				//12
			, "医疗健康"				//13
			, "媒体资讯"				//14
			, "生活消费"				//15
	};
	
	/**
	 * 用于转换从前台传过来的能力方向的数字，进行文字的转换
	 */
	public final static String[] copartnerCategory = {
			"其他"					//0
			,"资金"					//1
			,"技术"					//2
			,"推广"					//3
			,"运营"					//4
	};
}
