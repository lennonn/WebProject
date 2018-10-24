package com.zlennon.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zlennon.admin.model.PageView;
import com.zlennon.admin.service.PageViewService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.Date;


public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    PageViewService pageViewService;
    //请求控制器前，处理请求
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        try {
                //每一个session理论上只能记一次访问，因此在session里面存一个访问标记，如果存在标记，则不再计算此次访问
                String accessedFlag = "accessedFlag";
                if(request.getSession().getAttribute("accessedFlag")==null) {
                    //同步锁
                    synchronized(this) {
                        PageView pv = new PageView();
                        pv.setViewIp(request.getRemoteAddr());
                        pv.setViewDate(new Date());
                        pageViewService.insert(pv);
                        request.getSession().setAttribute("accessedFlag", accessedFlag);
                    }

                }

        }catch(Exception e) {
            e.printStackTrace();
            throw e;
        }

        return true;
    }




    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    /*
     * 实例化时执行的操作
     */
    @PostConstruct
    public void initMethod() throws Exception {

    }
    /*
     * 销毁前执行的操作
     */
    @PreDestroy
    public void destroyMethod() throws Exception {
        //保存isystem

    }
}
