package com.zlennon.admin.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlennon.Constants;
import com.zlennon.admin.service.SysMenuService;
import com.zlennon.business.model.Article;
import com.zlennon.business.service.DailyContentService;
import com.zlennon.webmagic.DailyProcessor;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import us.codecraft.webmagic.Spider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    private DailyContentService dailyContentService;
    @RequestMapping("/ckeditorUpload")
    @ResponseBody
    public void upload(@RequestParam("upload") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
            try {
                String path=getStorePath(request);
                PrintWriter out = response.getWriter();
                String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
                String fileName = file.getOriginalFilename();
                if (file.getSize() > 1024 * 1024 * 2) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.parent.CKEDITOR.tools.callFunction("
                            + CKEditorFuncNum + ",''," + "'文件大小不得大于2M');");
                    out.println("</script>");
                    return;
                }
                String proName = request.getContextPath();
                String dateStr=DateFormatUtils.format(new Date(),"yyyy-MM-dd");
                String returnPath=proName+ Constants.UPLOAD_PATH+dateStr;
                createDir(path);
                path=path+"/"+fileName;
                file.transferTo(new File(path));// 返回"图像"选项卡并显示图片 request.getContextPath()为web项目名
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction("
                        + CKEditorFuncNum + ",'" + returnPath+"/"+fileName
                        + "','')");
                out.println("</script>");
                return;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    /**
     * 通过粘贴的方式上传图片
     * @param file
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/uploadByPaste")
    public void  uploadByPaste(@RequestParam("upload") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String path=getStorePath(request);
        String jsonResult="";
        try{
        PrintWriter out = response.getWriter();
        String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
        String fileName = file.getOriginalFilename();

        if (file.getSize() > 1024 * 1024 * 2) {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction("
                    + CKEditorFuncNum + ",''," + "'文件大小不得大于2M');");
            out.println("</script>");
        }
        createDir(path);
        Long timeStr=  Calendar.getInstance().getTimeInMillis();
        fileName =timeStr+fileName.substring(fileName.indexOf("."));

        path=path+"/"+fileName;
        String proName = request.getContextPath();
        String dateStr=DateFormatUtils.format(new Date(),"yyyy-MM-dd");
        String returnPath=proName+ Constants.UPLOAD_PATH+dateStr+"/"+fileName;
        file.transferTo(new File(path));// 返回"图像"选项卡并显示图片 request.getContextPath()为web项目名
         //jsonResult = "{\"uploaded\" : 1, \"fileName\" :\""+ fileName+"\", \"url\":\""+returnPath+"\" , \"error\" : { \"message\":\"errorMsg\" } }";
         jsonResult = "{\"uploaded\" : 1, \"fileName\" :\""+ fileName+"\", \"url\":\""+returnPath+"\" }";

            out.write(jsonResult);
        } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }


    private String getStorePath( HttpServletRequest request) {
        String proPath = request.getSession().getServletContext().getRealPath("/");
        String proName = request.getContextPath();
        String dateStr=DateFormatUtils.format(new Date(),"yyyy-MM-dd");
        String path=proPath+ Constants.UPLOAD_PATH+dateStr;
        return path;
    }

    private String validFileType(MultipartFile file){
        String uploadContentType = file.getContentType();
        String expandedName = "";
        if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {// IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
            expandedName = ".jpg";
        } else if (uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")) {// IE6上传的png图片的headimageContentType是"image/x-png"
            expandedName = ".png";
        } else if (uploadContentType.equals("image/gif")) {
            expandedName = ".gif";
        } else if (uploadContentType.equals("image/bmp")) {
            expandedName = ".bmp";
        }
        return expandedName;
    }

    private void createDir(String path) {
        File f = new File(path);
        if(!f.exists())
            f.mkdirs();
    }

    @RequestMapping("/test")
    public String test() {
       // DailyProcessor my = new DailyProcessor(this.dailyContentService);
       // Spider.create(my).addUrl("http://sentence.iciba.com/index.php?c=dailysentence&m=getTodaySentence").thread(5).run();
        return "/test/test";
    }

}