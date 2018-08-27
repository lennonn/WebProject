package com.zlennon.admin.controller;
import com.zlennon.admin.model.SysUser;
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


   @RequestMapping("list")
    public String list(Model model) {
        List<SysUser> su=sysUserService.selectAll();
        model.addAttribute("sysUser",su);
        return "/admin/sysuser/sysUserList";
    }


    @RequestMapping("initTable")
    @ResponseBody
    public String  initTable(HttpServletRequest request, @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
    PageHelper.startPage(pageNumber, pageSize);
    List<SysUser> list = sysUserService.selectAll();
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

}
