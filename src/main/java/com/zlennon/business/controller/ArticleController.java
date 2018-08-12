package com.zlennon.business.controller;
import com.alibaba.fastjson.JSONObject;
import com.zlennon.business.model.Article;
import com.zlennon.business.model.ArticleType;
import com.zlennon.business.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlennon.business.service.ArticleTypeService;
import com.zlennon.website.model.DbTagList;
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
 * Created by zlennon on 2018/08/09.
 */
@Controller
@RequestMapping("/article/")
public class ArticleController {
    protected static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleTypeService articleTypeService;


    @RequestMapping("list")
    public String list(Model model) {
        List<ArticleType> ats=articleTypeService.selectAll();
        model.addAttribute("articleType",ats);
        return "/business/article/articleList";
    }

    @RequestMapping("website/list")
    public String list(Model model, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
        PageHelper.startPage(page, size);
        List<Article> list = articleService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pageUrl","/article/website/list");
        return "/website/article/articleList";
    }

    @RequestMapping("website/showDetail")
    public String showDetail(Model model, @RequestParam String id) {
        Article article= (Article) articleService.selectByPrimaryKey(id);
        model.addAttribute("article",article);
        model.addAttribute("article",article);

        return "/website/article/articleDetail";
    }
    @RequestMapping("initTable")
    @ResponseBody
    public String  initTable(HttpServletRequest request, @RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        PageHelper.startPage(pageNumber, pageSize);
        List<Article> list = articleService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return  "{\"total\":" + pageInfo.getTotal() + ",\"rows\":" + JSONObject.toJSON(pageInfo.getList()) + "}";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(@Valid Article article) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            articleService.insert(article);
            resultMap.put("msg", "操作成功");
        } catch (Exception e) {
            logger.info(e.getMessage());
            resultMap.put("msg", "操作失败");
        }
        return resultMap;
    }
}
