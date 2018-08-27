package ${basePackage}.${modules}.controller;
import ${basePackage}.${modules}.model.${modelNameUpperCamel};
import ${basePackage}.${modules}.service.${modelNameUpperCamel}Service;
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
 * Created by ${author} on ${date}.
 */
@Controller
@RequestMapping("/${baseRequestMapping}/")
public class ${modelNameUpperCamel}Controller {
    protected static final Logger logger = LoggerFactory.getLogger(${modelNameUpperCamel}Controller.class);

    @Autowired
    ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;


   @RequestMapping("list")
    public String list(Model model) {
        List<${modelNameUpperCamel}> ${abbr}=${modelNameLowerCamel}Service.selectAll();
        model.addAttribute("${modelNameLowerCamel}",${abbr});
        return "/${modules}/${modelNameLowerCamel?lower_case}/${modelNameLowerCamel}List";
    }


    @RequestMapping("initTable")
    @ResponseBody
    public String  initTable(HttpServletRequest request, @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
    PageHelper.startPage(pageNumber, pageSize);
    List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return  "{\"total\":" + pageInfo.getTotal() + ",\"rows\":" + JSONObject.toJSON(pageInfo.getList()) + "}";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String  delete(@RequestParam String id){
        ${modelNameLowerCamel}Service.deleteByPrimaryKey(id);
        return  "";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(@Valid ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            if(${modelNameLowerCamel}.getId()==null) {
                ${modelNameLowerCamel}Service.insert(${modelNameLowerCamel});
            }else{
                ${modelNameLowerCamel}Service.updateByPrimaryKey(${modelNameLowerCamel});
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
