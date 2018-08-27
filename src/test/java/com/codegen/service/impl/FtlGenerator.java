package com.codegen.service.impl;

import com.codegen.service.CodeGenerator;
import com.codegen.service.CodeGeneratorManager;
import com.codegen.util.StringUtils;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * FreeMarker 代码生成器
 * Created by zhh on 2017/09/20.
 */
public class FtlGenerator extends CodeGeneratorManager implements CodeGenerator {

	@Override
	public void genCode(String tableName, String modelName, String sign) {
		List tableInfo =getTableInfo(tableName);
		Configuration cfg = getFreemarkerConfiguration();
		String modelNameUpperCamel = StringUtils.isNullOrEmpty(modelName) ? tableNameConvertUpperCamel(tableName) : modelName;
        String customMapping = "/" + MODULES + "/"+modelNameUpperCamel.toLowerCase()+"/";
        Map<String, Object> data = getDataMapInit(modelName, sign, modelNameUpperCamel);
		data.put("tableInfo",tableInfo);
		String lowerNameUpperCamel =StringUtils.toLowerCaseFirstOne(modelNameUpperCamel);
		// 创建 Service 接口
		String fileType[] = {"list"};
		for(int i=0;i<fileType.length;i++) {

			File serviceFile = new File(PROJECT_PATH + JSP_FILE_PATH+ customMapping+ lowerNameUpperCamel +tableNameConvertUpperCamel(fileType[i])+".jsp");
			// 查看父级目录是否存在, 不存在则创建
			if (!serviceFile.getParentFile().exists()) {
				serviceFile.getParentFile().mkdirs();
			}
			try {
				cfg.getTemplate(fileType[i]+".ftl").process(data, new FileWriter(serviceFile));
			} catch (TemplateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info(serviceFile.getPath() + "生成成功!");
		}
	}

	/**
	 * 根据数据库的连接参数，获取指定表的基本信息：字段名、字段类型、字段注释
	 * @param table 表名
	 * @return Map集合
	 */
	public static List<Map<String,Object>> getTableInfo(String table){
		List result = new ArrayList();
		Connection conn = null;
		DatabaseMetaData dbmd = null;
		try {
			conn = getConnections();

			dbmd = conn.getMetaData();
			ResultSet resultSet = dbmd.getTables(null, "%", table, new String[] { "TABLE" });

			while (resultSet.next()) {
				String tableName=resultSet.getString("TABLE_NAME");
				System.out.println(tableName);

				if(tableName.equals(table)){
					ResultSet rs = conn.getMetaData().getColumns(null, getSchema(conn),tableName.toUpperCase(), "%");

					while(rs.next()){
						//System.out.println("字段名："+rs.getString("COLUMN_NAME")+"--字段注释："+rs.getString("REMARKS")+"--字段数据类型："+rs.getString("TYPE_NAME"));
						Map<String,Object> map = new HashMap();
						String colName = rs.getString("COLUMN_NAME");
						colName=tableNameConvertLowerCamel(colName);
						map.put("colName", colName);

						String remarks = rs.getString("REMARKS");
						if(remarks == null || remarks.equals("")){
							remarks = "无";
						}
						map.put("remark",remarks);


						String dbType = rs.getString("TYPE_NAME");
						map.put("dbType",dbType);

						map.put("valueType", changeDbType(dbType));
						result.add(map);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 获取单词首字符并且小写
	 * @param str
	 * @return
	 */
	private  String getAbbr(String str){
		StringBuffer buffer = new StringBuffer();
		// 转为char数组
		char[] ch = str.toCharArray();
		// 得到大写字母
		for(int i = 0; i < ch.length ; i++){
			if(ch[i] >= 'A' && ch[i] <= 'Z'){
				buffer.append(ch[i]);
			}
		}
		// 倒序
		return buffer.toString().toLowerCase();
	}

	/**
	 * 预置页面所需数据
	 * @param modelName 自定义实体类名, 为null则默认将表名下划线转成大驼峰形式
	 * @param sign 区分字段, 规定如表 gen_test_demo, 则 test 即为区分字段
	 * @param modelNameUpperCamel 首字为大写的实体类名
	 * @return
	 */
	private Map<String, Object> getDataMapInit(String modelName, String sign, String modelNameUpperCamel) {
		Map<String, Object> data = new HashMap<>();
		data.put("date", DATE);
		data.put("author", AUTHOR);
		data.put("abbr", modelName==null?"":getAbbr(modelName));
		data.put("modelNameUpperCamel", modelNameUpperCamel);
		data.put("actionName", StringUtils.toLowerCaseFirstOne(modelNameUpperCamel));
		data.put("basePackage", BASE_PACKAGE);
		return data;
	}


	//获取连接
	private static Connection getConnections() throws Exception {
		Connection conn = null;
		try {
			Properties props = new Properties();
			props.put("remarksReporting", "true");
			props.put("user", JDBC_USERNAME);
			props.put("password", JDBC_PASSWORD);
			Class.forName(JDBC_DRIVER_CLASS_NAME);
			conn = DriverManager.getConnection(JDBC_URL, props);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return conn;
	}

	//其他数据库不需要这个方法 oracle和db2需要
	private static String getSchema(Connection conn) throws Exception {
		String schema;
		schema = conn.getMetaData().getUserName();
		if ((schema == null) || (schema.length() == 0)) {
			throw new Exception("ORACLE数据库模式不允许为空");
		}
		return schema.toUpperCase().toString();
	}

	private static String changeDbType(String dbType) {
		dbType = dbType.toUpperCase();
		switch(dbType){
			case "VARCHAR":
			case "VARCHAR2":
			case "CHAR":
				return "1";
			case "NUMBER":
			case "DECIMAL":
				return "4";
			case "INT":
			case "SMALLINT":
			case "INTEGER":
				return "2";
			case "BIGINT":
				return "6";
			case "DATETIME":
			case "TIMESTAMP":
			case "DATE":
				return "7";
			default:
				return "1";
		}
	}
}
