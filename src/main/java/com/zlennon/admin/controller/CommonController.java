package com.zlennon.admin.controller;


import com.zlennon.Constants;
import com.zlennon.admin.service.SysMenuService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
@RequestMapping
public class CommonController {

    @Autowired
    SysMenuService sysMenuService;

    @RequestMapping("/ckeditorUpload")
    @ResponseBody
    public void upload(@RequestParam("upload") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
            try {
                String proPath = request.getSession().getServletContext().getRealPath("/");
              //  String proName = request.getContextPath();
                //String path=proName + Constants.UPLOAD_PATH;
                String dateStr=DateFormatUtils.format(new Date(),"yyyy-MM-dd");
                String path="D:/IdeaProjects/zlennon/WebContent/images/ckeditor"+"/"+dateStr;

                PrintWriter out = response.getWriter();
                String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
                String fileName = file.getOriginalFilename();
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
                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.parent.CKEDITOR.tools.callFunction("
                            + CKEditorFuncNum + ",'',"
                            + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
                    out.println("</script>");
                    return;
                }
                if (file.getSize() > 1024 * 1024 * 2) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("window.parent.CKEDITOR.tools.callFunction("
                            + CKEditorFuncNum + ",''," + "'文件大小不得大于2M');");
                    out.println("</script>");
                    return;
                }
                createDir(path);
                path=path+"/"+fileName;
                file.transferTo(new File(path));// 返回"图像"选项卡并显示图片 request.getContextPath()为web项目名
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction("
                        + CKEditorFuncNum + ",'" + request.getContextPath()+"/images/ckeditor/"+dateStr+"/" + fileName
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

    private void createDir(String path) {
        File f = new File(path);
        if(!f.exists())
            f.mkdirs();
    }

}