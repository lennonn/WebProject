package com.zlennon.security;

import com.zlennon.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;


/**
 * 用于对用户提交的密码进行自定义的加密操作
 */
public class MyMessageDigestPasswordEncoder extends MessageDigestPasswordEncoder {

    public MyMessageDigestPasswordEncoder(String algorithm) {
        super(algorithm);
    }

    /**
     * encPass：用户的真是密码
     * raw：用户提交的密码
     *
     */
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        if(StringUtils.isEmpty(rawPass)) {
            throw new BadCredentialsException("密码不能为空");
        }
        return encPass.equals(MD5Util.getMD5UpperString(rawPass));
    }

}
