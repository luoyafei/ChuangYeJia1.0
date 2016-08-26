package com.chuangyejia.tools;

/**
 * 提供了Startups实体类的工具类
 * @author Diamond
 *
 */
public class StartupsUtil {

	/**
	 * 用于转换从前台传过来的服务类型的数字，进行文字的转换
	 */
	public final static String[] ServiceType = {
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
	 * 用于转换从前台传过来的合伙人需求的数字，进行文字的转换
	 */
	public final static String[] CopartnerRequire = {
			" 其他"					//0
			," 资金"					//1
			," 技术"					//2
			," 推广"					//3
			," 运营"					//4
	};
	
	
	public final static String[] OperationStage = {
			"暂无"                  //0
			,"概念阶段"             //1
			,"产品研发中"           //2
			,"产品已经上线"           //3
	};
}
