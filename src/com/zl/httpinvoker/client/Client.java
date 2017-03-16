package com.zl.httpinvoker.client;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zl.service.facade.UserService;

/**
 * Created by wxiao on 2016.9.11.
 *
 * Spring HttpInvoker Client
 *
 */

public class Client {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:invoker-dispatcher-servlet.xml");
        UserService userService = (UserService) context.getBean("userService");
        System.out.println("远程调用的结果是：" + userService.getUser().getName() + "  " + userService.getUser().getPassword());

    }
}
