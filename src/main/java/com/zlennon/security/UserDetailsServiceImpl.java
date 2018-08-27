package com.zlennon.security;

import javax.annotation.Resource;

import com.zlennon.admin.mapper.SysUserMapper;
import com.zlennon.admin.model.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


/**
 * 根据用户提交的用户名查询出用户信息
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private SysUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(username)) {
            throw new BadCredentialsException("用户名不能为空");
        }

        UserDetails userDetails = null;
        // 根据用户名从数据库查询用户信息，根据自己的业务规则去写
       // SysUser user = this.userMapper.getUserByUsername(username);
        SysUser user =new SysUser();
        if(user == null) {
            throw new BadCredentialsException("用户名不存在");
        }
        userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPasswd(), // 数据库中存储的密码
                true,               // 用户是否激活
                true,               // 帐户是否过期
                true,               // 证书是否过期
                true,               // 账号是否锁定
                AuthorityUtils.createAuthorityList("ROLE_"/* + user.getType()*/));  // 用户角色列表，必须以 ROLE_ 开头
        return userDetails;
    }
}
