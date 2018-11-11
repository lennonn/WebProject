package com.zlennon;

import com.zlennon.admin.service.impl.SysMenuServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class SpringBeanAutowiredTest extends JUnitServiceBase {
    @Test
    public void getBean(){
        ApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        SysMenuServiceImpl sysMenuService= (SysMenuServiceImpl) wac.getBean("sysMenuServiceImpl");
        Assert.assertNull("no beans",sysMenuService);
    }
}
