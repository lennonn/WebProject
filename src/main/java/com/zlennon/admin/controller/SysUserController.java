package com.zlennon.admin.controller;
import com.zlennon.admin.model.*;
import com.zlennon.admin.service.SysRoleService;
import com.zlennon.admin.service.SysUserRoleService;
import com.zlennon.admin.service.SysUserService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by zlennon on 2018/08/27.
 */
@Controller
@RequestMapping("/sysUser/")
public class SysUserController {
    protected static final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    SysUserRoleService sysUserRoleService;


   @RequestMapping("list")
    public String list(Model model) {
        List<SysRole>  sr=sysRoleService.selectAll();
        model.addAttribute("sysRole",sr);
        return "/admin/sysuser/sysUserList";
    }


    @RequestMapping("initTable")
    @ResponseBody
    public String  initTable(String searchText,@RequestParam Integer pageNumber,@RequestParam Integer pageSize){
       PageHelper.startPage(pageNumber, pageSize);
       List<SysUser> list = sysUserService.selectByQueryParams(searchText);
       PageInfo pageInfo = new PageInfo(list);
       return  "{\"total\":" + pageInfo.getTotal() + ",\"rows\":" + JSONObject.toJSON(pageInfo.getList()) + "}";
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String,Object>  delete(@RequestParam String id){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            sysUserService.deleteByPrimaryKey(id);
            resultMap.put("msg", "操作成功");
        }catch (Exception e){
            logger.info(e.getMessage());
            resultMap.put("msg", "操作失败");
        }
        return  resultMap;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(@Valid SysUser sysUser) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            if(sysUser.getId()==null||sysUser.getId().equals("")) {
                sysUserService.insert(sysUser);
            }else{
                sysUserService.updateByPrimaryKey(sysUser);
            }
             resultMap.put("msg", "操作成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
        e.printStackTrace();

        }
             return resultMap;
    }

    @RequestMapping(value = "/authRole", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> auth(@RequestParam String roleIds,String userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            if(roleIds!="") {
                String ids[] = roleIds.split(",");
                for(String id:ids){
                    SysUserRole sr = new SysUserRole();
                    sr.setRoleId(id);
                    sr.setUserId(userId);
                    sysUserRoleService.insert(sr);
                }
            }
            resultMap.put("msg", "授权成功！");
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("msg","授权失败"+e.getMessage());
        }
        return resultMap;
    }

    @RequestMapping(value = "/getAuthedRole", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> getAuthedRole(@RequestParam String userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<SysUserRole> surList=sysUserRoleService.getUserRoleByUserId(userId);
        resultMap.put("authedRole",surList);
        return resultMap;
    }

}
