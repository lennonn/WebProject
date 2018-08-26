package com.zlennon.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        response.sendRedirect(request.getContextPath() + "/home.html");
    }

}
