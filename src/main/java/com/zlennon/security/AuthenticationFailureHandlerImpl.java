package com.zlennon.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * 用于用户登录认证失败后执行的操作
 */
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        // AuthenticationException 存放着异常信息，获取出来，放到 Request 中，转发到登录页面。
        Map<String, Object> result = new HashMap<>();
        result.put("isSuccess", false);
        if (exception instanceof LockedException) {
            // 如果账户被锁定
            //logger.info("LoginFailHandler the user is locked!");
            result.put("msg", "该用户被锁定！");
        } else if (exception instanceof UsernameNotFoundException) {
            //logger.info("LoginSuccessHandler login fail!");
            result.put("msg", "该帐号不存在！");
        } else {
            //logger.info("LoginFailHandler login fail!");
            result.put("msg", "用户名或密码不正确！");
        }
        request.setAttribute("error", exception.getMessage());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(result));
        response.getWriter().flush();
        response.getWriter().close();
        //request.getRequestDispatcher("/login").forward(request, response);
    }

}
