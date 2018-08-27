package com.zlennon.admin.service.impl;

import com.zlennon.admin.mapper.SysUserMapper;
import com.zlennon.admin.model.SysUser;
import com.zlennon.admin.service.SysUserService;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/27.
 */
@Service
public class SysUserServiceImpl extends AbstractService<SysUser> implements SysUserService<SysUser> {

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUserMapper getSysUserMapper() {
        return sysUserMapper;
    }

    public void setSysUserMapper(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  sysUserMapper.deleteByPrimaryKey(id);
    }

    public int insert(SysUser sysUser){
        sysUser.setId(getTablePK("SysUser"));
        sysUser.setRegtime(new Date());
       return sysUserMapper.insert(sysUser);
    }

    public SysUser selectByPrimaryKey(String id){
       return  sysUserMapper.selectByPrimaryKey(id);
    }

    public List<SysUser> selectAll(){
       return sysUserMapper.selectAll();
    }

    public int updateByPrimaryKey(SysUser sysUser){
       return sysUserMapper.updateByPrimaryKey(sysUser);
    }
}
