package com.zl.service.spring;

import com.zl.dto.domain.Dept;
import com.zl.dto.domain.Farther;
import com.zl.dto.domain.Son;
import com.zl.persistence.hibernate.TransactionDAOTest;
import com.zl.service.facade.FartherService;
import com.zl.service.facade.SonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MappingTest {

    @Test
    public void testSave() {
       //ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:j*.xml");

        ApplicationContext ac = new FileSystemXmlApplicationContext("src/app-action.xml","src/app-service.xml","src/app-dao.xml","src/applicationContext.xml");
       // TransactionDAOTest rr = (TransactionDAOTest) ac.getBean("transactionDAO");
        System.out.println(ac.getDisplayName() + "\n" + ac.getEnvironment());

        Farther farther = new Farther();
        farther.setName("father");
        farther.setAge(50);
        FartherService fartherService = (FartherService) ac.getBean("fartherService");
        fartherService.saveFarther(farther);


        Son son = new Son();
        son.setName("son");
        son.setAge(18l);
        son.setFartherByParentId(farther);
        SonService sonService = (SonService) ac.getBean("sonService");
        sonService.saveSon(son);
    }

    @Test
    public  void testSelect(){
        ApplicationContext ac = new FileSystemXmlApplicationContext("src/app-action.xml","src/app-service.xml","src/app-dao.xml","src/applicationContext.xml");
        SonService sonService = (SonService) ac.getBean("sonService");
        Son son =sonService.getById("297eb9c671e0192f0171e01953110001");
        System.out.println(son.toString());
    }
}
