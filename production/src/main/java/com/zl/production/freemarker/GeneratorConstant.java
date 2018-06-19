package com.zl.production.freemarker;



import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

public class GeneratorConstant {
	//configuration path
	public static final String CFG_FILE_NAME="configuration.xml";
	
	public static final String CFG_PATH="D:\\git\\WebProject\\production\\src\\main\\java\\com\\zl\\production\\freemarker\\cfg\\";
	
	public static final String DATE=DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
	public static final String AUTHOR="Cruz";
	
	public static final String VERSION="01-00";
	
	public enum templateType{
		
		DAO("dao","daoId"),DTO("dto","dtoId"),SERVICE("service","serviceId"),ACTION("action","actionId");
		
		private String id;
		
		private String name;
		

		private templateType(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
}
