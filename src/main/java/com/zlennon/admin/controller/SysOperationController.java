package com.zlennon.admin.controller;
import com.zlennon.admin.model.SysOperation;
import com.zlennon.admin.service.SysOperationService;
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
@RequestMapping("/sysOperation/")
public class SysOperationController {
    protected static final Logger logger = LoggerFactory.getLogger(SysOperationController.class);

    @Autowired
    SysOperationService sysOperationService;


   @RequestMapping("list")
    public String list(Model model) {
        List<SysOperation> so=sysOperationService.selectAll();
        model.addAttribute("sysOperation",so);
        return "/admin/sysoperation/sysOperationList";
    }


    @RequestMapping("initTable")
    @ResponseBody
    public String  initTable(HttpServletRequest request, @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
    PageHelper.startPage(pageNumber, pageSize);
    List<SysOperation> list = sysOperationService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return  "{\"total\":" + pageInfo.getTotal() + ",\"rows\":" + JSONObject.toJSON(pageInfo.getList()) + "}";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String  delete(@RequestParam String id){
        sysOperationService.deleteByPrimaryKey(id);
        return  "";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(@Valid SysOperation sysOperation) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            if(sysOperation.getId()==null) {
                sysOperationService.insert(sysOperation);
            }else{
                sysOperationService.updateByPrimaryKey(sysOperation);
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
