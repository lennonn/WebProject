package com.zlennon.admin.controller;
import com.zlennon.admin.model.SysRole;
import com.zlennon.admin.service.SysRoleService;
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
 * Created by zlennon on 2018/08/26.
 */
@Controller
@RequestMapping("/sysRole/")
public class SysRoleController {
    protected static final Logger logger = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    SysRoleService sysRoleService;


   @RequestMapping("list")
    public String list(Model model) {
        List<SysRole> ats=sysRoleService.selectAll();
        model.addAttribute("articleType",ats);
        return "/admin/sysRole/adminList";
    }


    @RequestMapping("initTable")
    @ResponseBody
    public String  initTable(HttpServletRequest request, @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
    PageHelper.startPage(pageNumber, pageSize);
    List<SysRole> list = sysRoleService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return  "{\"total\":" + pageInfo.getTotal() + ",\"rows\":" + JSONObject.toJSON(pageInfo.getList()) + "}";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String  delete(@RequestParam String id){
        sysRoleService.deleteByPrimaryKey(id);
        return  "";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(@Valid SysRole sysRole) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            if(sysRole.getRoleId()==null) {
                sysRoleService.insert(sysRole);
            }else{
                sysRoleService.updateByPrimaryKey(sysRole);
            }
             resultMap.put("msg", "操作成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
        e.printStackTrace();
             resultMap.put("msg", "操作失败");
        }
             return resultMap;
    }

}
