package com.zlennon;

import java.util.Locale;

/**
 * @description Constants类，项目的基本信息配置
 * @author Nicky
 * @date 2017年3月6日
 */
public class Constants {

	//定义统一Locale.CHINA,程序中所有和Locale相关操作均默认使用此Locale
	public static final Locale LOCALE_CHINA = Locale.CHINA;
	
	//验证码Session
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	//用户信息Session
	public static final String SESSION_USER = "sessionUser";
	//角色权限Session
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
	//所有菜单Session
	public static final String SESSION_ALLMENU = "sessionAllMenu";
	//权限Session
	public static final String SESSION_RIGHTS = "sessionRights";
	
	//页面分页数量
	public static final Integer PAGE_SIZE = 6;
	//页面排序数量
	public static final Integer SORT_SIZE = 3;
	
	//登录URL
	public static final String URL_LOGIN = "/login.do";			
	
	//登录过滤的正则表达式
	public static final String REGEXP_PATH = ".*/((login)|(logout)|(toblog)|(search)|(getArchiveArticles)|(code)|(plugins)|(upload)|(static)).*";	//不对匹配该值的访问路径拦截（正则）

	//Lucene索引的路径
	public static final String LUCENE_INDEX_PATH = "D:\\lucene";

	/**
	 * 无周期,一直递增
	 */
	public static final String CYCLE_TYPE_NO = "0";
	/**
	 * 以年为周期
	 */
	public static final String CYCLE_TYPE_YEAR = "1";
	/**
	 * 以月为周期
	 */
	public static final String CYCLE_TYPE_MONTH = "2";
	/**
	 * 以日为周期
	 */
	public static final String CYCLE_TYPE_DAY = "3";
	/**
	 * 缺省短日期格式
	 */
	public static final String DEFAULT_SHORT_DATE_FMT = "yyyyMMdd";
	/**
	 * 缺省长日期格式
	 */
	public static final String DEFAULT_LONG_DATE_FMT = "yyyy-MM-dd";

	/**
	 * ckeditor
	 */
	public static final  String UPLOAD_PATH="/images/ckeditor/";
}
