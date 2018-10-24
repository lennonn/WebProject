package com.zlennon.business.controller;
import com.zlennon.admin.model.SysDictValue;
import com.zlennon.admin.service.SysDictValueService;
import com.zlennon.business.model.DailyContent;
import com.zlennon.business.service.DailyContentService;
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

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by zlennon on 2018/10/08.
 */
@Controller
@RequestMapping("/dailyContent/")
public class DailyContentController {
    protected static final Logger logger = LoggerFactory.getLogger(DailyContentController.class);

    @Autowired
    DailyContentService dailyContentService;

    @Autowired
    SysDictValueService sysDictValueService;

   @RequestMapping("list")
    public String list(Model model) {
       List< SysDictValue> sdvList=sysDictValueService.selectByTypeId("1012201810080000001");
       model.addAttribute("sdvList",sdvList);
       return "/business/dailycontent/dailyContentList";
    }


    @RequestMapping("initTable")
    @ResponseBody
    public String  initTable(String searchText,@RequestParam Integer pageNumber,@RequestParam Integer pageSize){
        PageHelper.startPage(pageNumber, pageSize);
        List<DailyContent> list = dailyContentService.selectByQueryParams(searchText);
        PageInfo pageInfo = new PageInfo(list);
        return  "{\"total\":" + pageInfo.getTotal() + ",\"rows\":" + JSONObject.toJSON(pageInfo.getList()) + "}";
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String,Object>  delete(@RequestParam String id){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            dailyContentService.deleteByPrimaryKey(id);
            resultMap.put("msg", "操作成功");
        }catch (Exception e){
            logger.info(e.getMessage());
            resultMap.put("msg", "操作失败");
        }
        return  resultMap;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(@Valid DailyContent dailyContent) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            if(dailyContent.getId()==null||dailyContent.getId().equals("")) {
                dailyContentService.insert(dailyContent);
            }else{
                dailyContentService.updateByPrimaryKey(dailyContent);
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
