package com.zl.common.aop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class AOPClass {
	// 定义LOG4J对象  
	static Logger logger = Logger.getLogger(AOPClass.class.getName());  
	  
	// 日志配置文件  
	static Properties properties = null;  
	// 读取日志配置文件  
	static {  
	properties = new Properties();  
	  
	try {  
	  
	FileInputStream in = new FileInputStream("E:\\Test_workspace\\SSHXmlConfigration\\src\\log4j.properties");  
	  
	properties.load(in);  
	} catch (FileNotFoundException e) {  
	logger.error("没有找到日志配置文件，请确认你的路径是否正确。");  
	} catch (IOException e) {  
	logger.error("日志配置文件读写错误");  
	}  
	}  
	  
	/** 
	    * 描述: 记录系统安全日志的方法 
	    *  
	    * @author: lio 
	    * @param joinPoint 
	    * @version: 1.0 
	    */  
	@SuppressWarnings("unused")  
	private void addLog(JoinPoint joinPoint) {  
	  
	String key = joinPoint.getTarget().getClass().getName() + "."  
	+ joinPoint.getSignature().getName();  
	// 得到方法描述信息  
	String info = properties.getProperty(key);  
	if (info != null && !info.equals("") && !info.equals(" ")) {  
	logger.info(info);  
	} else {  
	/* System.out.println("请检查您的日志配置文件，AOP" + 
	"中配置了此方法记录日志，但是没有在配置文件中找到该方法的描述，方法名：" + key); 
	*/   
	}  
	  
	}  
	  
}
