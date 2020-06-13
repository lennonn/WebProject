package com.zl.web.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.shiro.SecurityUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.jasig.cas.client.authentication.AttributePrincipal;

import javax.servlet.http.HttpServletRequest;

public class IndexAction extends ActionSupport {

    private final String url="www";
    public String getAuthcUser() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String username=(String)SecurityUtils.getSubject().getPrincipal();
        //AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
        return "success";
    }

    @Action(value = "/other/bar",
            results = {@Result(name = "one", location = "www.baidu.com"+url, type = "redirect")})
    public String myTest() {
        String test = "dd";
        if ("dd".equals(test)) {
            return "one";
        }
        return "success";
    }
}
