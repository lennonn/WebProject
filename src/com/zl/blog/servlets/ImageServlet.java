package com.zl.blog.servlets;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.zl.blog.beans.Image;
import com.zl.blog.daos.ImageDao;

public class ImageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String tid= request.getParameter("tid");
		if(action.equals("select"))
			this.adminSelectImage(request,response);		//查询所有图片
		if(action.equals("upload")&&tid!=null)
			this.addPhoto(request, response);
	}
	/**
	 * @功能 前台-查询所有图片

	public void selectPhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PhotoDao photoDao=new PhotoDao();
		List photoList=photoDao.queryPhoto("all");
		request.setAttribute("photoList", photoList);

		RequestDispatcher rd=request.getRequestDispatcher("/front/photo/PhotoList.jsp");
		rd.forward(request,response);
	}
	*
	 * @功能 后台-查询所有图片
	 */
	public void adminSelectImage(HttpServletRequest request,
			HttpServletResponse response)  {
		HttpSession session= request.getSession();
		try {
			ImageDao iDao=new ImageDao();
			//ImageType itype= new ImageType();
			int tid =Integer.parseInt(request.getParameter("imagetype"));
			List imageList=iDao.findImage(tid);

			session.setAttribute("imageList", imageList);
			response.sendRedirect("admin/test.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

		}

		//RequestDispatcher rd=request.getRequestDispatcher("admin/test.jsp");
		//rd.forward(request,response);
	}
	/**
	 * @功能 查看某个图片详细内容

	public void singlePhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PhotoDao photoDao=new PhotoDao();
		String strId=request.getParameter("id");
		int id=MyTools.strToint(strId);
		PhotoBean photoSingle=photoDao.queryPhoto(id);
		request.setAttribute("photoSingle",photoSingle);

		RequestDispatcher rd=request.getRequestDispatcher("/front/photo/PhotoSingle.jsp");
		rd.forward(request,response);
	}

	/**
	 * @功能 删除图片

	public void deletePhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String messages="";
		String forward="";
		String href="";

		RequestDispatcher rd=null;
		PhotoDao photoDao= new PhotoDao();
		int id = MyTools.strToint(request.getParameter("id"));
		String fileAddr=photoDao.queryPhoto(id).getPhotoAddr();
		String photoDir=request.getSession().getServletContext().getRealPath("\\");
		String delFile=photoDir+fileAddr;

		java.io.File file = new java.io.File(delFile);

		PhotoBean photoBean = new PhotoBean();
		photoBean.setId(id);
		if (photoDao.operationPhoto("delete", photoBean)) {
			boolean result=file.delete();
			if(result){
				messages="<li>删除照片成功！</li>";
				forward="/admin/success.jsp";
				href="<a href='PhotoServlet?action=adminList'>[继续删除其他照片]</a>";
			}
			else{
				messages="<li>删除照片失败！</li>";
				forward="/admin/error.jsp";
				href="<a href='javascript:window.history.go(-1)'>[返回]</a>";
			}

		} else {
			messages="<li>删除照片失败！</li>";
			forward="/admin/error.jsp";
			href="<a href='javascript:window.history.go(-1)'>[返回]</a>";
		}
		request.setAttribute("messages",messages);
		request.setAttribute("href",href);
		rd=request.getRequestDispatcher(forward);
		rd.forward(request,response);

	}
	*/
	public void addPhoto(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String filePath = "admin\\img\\";
		String messages="";
		String forward="";
		String href="";

		int tid =Integer.parseInt(request.getParameter("tid"));
		ImageDao idao = new ImageDao();
		Image image = new Image();
		SmartUpload su = new SmartUpload();
		long maxsize = 2 * 1024 * 1024; 									// 设置每个上传文件的大小，为2MB

		try {
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); 									// 限制上传文件的大小
			su.setAllowedFilesList("jpg,gif,bmp");							// 设置允许上传的文件类型
			su.upload();													// 上传文件
			//su.save(filePath);
			String imageDesc=su.getRequest().getParameter("info");
			if(imageDesc==null||imageDesc.equals("")){						//验证照片描述信息，若没有输入，则提示输入照片描述信息
				messages="请输入照片描述信息！";
				forward="/admin/error.jsp";
				href="<a href='javascript:window.history.go(-1)'>[返回]</a>";
			}
			else{
				File file = su.getFiles().getFile(0);						// 获取上传的文件，因为只上传了一个文件，所以可直接获取
				if (!file.isMissing()) { 									// 如果选择了文件
					String imageAddr=filePath+idao.findMaxId()+"."+file.getFileExt();		//filePath值(front\\photo\\pic\\)+图片信息在数据表中的id字段值+“.”+文件后缀名;最后生成例如“front\photo\pic\12.bmp”路径
					String imageName=idao.findMaxId()+"."+file.getFileExt();
					Date now=new Date();				//获取当前时间并格式化为字符串
					image.setImgname(imageName);
					image.setImgurl(imageAddr.substring(6));
					image.setTime(now);
					image.setImgdesc(imageDesc);

					boolean mark=idao.uploadImage(image,tid);
					if(mark){
						try {

							file.saveAs(imageAddr,File.SAVEAS_VIRTUAL);
							messages="上传文件成功！";
							forward="admin/success.jsp";
							href="<a href='admin/photo/PhotoUpload.jsp'>[继续上传]</a>";
						} catch (SmartUploadException ee) {
							messages="上传文件失败！";
							forward="/admin/error.jsp";
							href="<a href='javascript:window.history.go(-1)'>[返回]</a>";
							ee.printStackTrace();
						}
					}
					else{
						messages="保存文件信息失败！";
						forward="/admin/error.jsp";
						href="<a href='javascript:window.history.go(-1)'>[返回]</a>";
					}
				}
				else{
					messages="请选择要上传的文件！";
					forward="/admin/error.jsp";
					href="<a href='javascript:window.history.go(-1)'>[返回]</a>";
				}
			}

		}catch (java.lang.SecurityException e){
			messages="<li>上传文件失败！上传的文件类型只允许为：jpg,gif,bmp</li>";
			forward="/admin/error.jsp";
			href="<a href='javascript:window.history.go(-1)'>[返回]</a>";

		}catch (SmartUploadException e) {
			messages="上传文件失败！";
			forward="/admin/error.jsp";
			href="<a href='javascript:window.history.go(-1)'>[返回]</a>";
			e.printStackTrace();
		}

		request.setAttribute("messages",messages);
		request.setAttribute("href",href);

		response.sendRedirect(forward);
	}

}

