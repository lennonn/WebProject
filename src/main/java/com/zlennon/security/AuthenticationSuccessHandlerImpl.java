package com.zlennon.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.zlennon.admin.mapper.SysUserMapper;
import com.zlennon.admin.model.SysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 用于登录认证成功后执行的操作
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    @Resource
    private SysUserMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // UserDetails 中存放着用户名等信息
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // 获取该用户信息，根据自己的业务规则写
        SysUser user = this.userMapper.getUserByUsername(userDetails.getUsername());
        // 将用户放到 Session
        request.getSession().setAttribute("currUser", user);
        // 跳转到主页
        //response.sendRedirect(request.getContextPath() + "/views/index");
        Map<String, Object> result = new HashMap<>();
        result.put("isSuccess", true);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(result));
        response.getWriter().flush();
        response.getWriter().close();
    }

}
