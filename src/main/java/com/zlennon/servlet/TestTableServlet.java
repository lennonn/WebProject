package com.zlennon.servlet;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlennon.admin.model.SysPermission;
import com.zlennon.admin.service.SysOperationService;
import com.zlennon.admin.service.SysPermissionService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestTableServlet extends HttpServlet {
    SysPermissionService sysPermissionService;

    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SysPermission> list = sysPermissionService.selectAll();
        Map<String,Object> result = new HashMap<String,Object>(0);
        result.put("total", list.size());
        result.put("rows", list);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().println(JSONObject.fromObject(result));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
