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
			this.adminSelectImage(request,response);		//��ѯ����ͼƬ
		if(action.equals("upload")&&tid!=null)
			this.addPhoto(request, response);
	}
	/**
	 * @���� ǰ̨-��ѯ����ͼƬ

	public void selectPhoto(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PhotoDao photoDao=new PhotoDao();
		List photoList=photoDao.queryPhoto("all");
		request.setAttribute("photoList", photoList);

		RequestDispatcher rd=request.getRequestDispatcher("/front/photo/PhotoList.jsp");
		rd.forward(request,response);
	}
	*
	 * @���� ��̨-��ѯ����ͼƬ
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
	 * @���� �鿴ĳ��ͼƬ��ϸ����

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
	 * @���� ɾ��ͼƬ

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
				messages="<li>ɾ����Ƭ�ɹ���</li>";
				forward="/admin/success.jsp";
				href="<a href='PhotoServlet?action=adminList'>[����ɾ��������Ƭ]</a>";
			}
			else{
				messages="<li>ɾ����Ƭʧ�ܣ�</li>";
				forward="/admin/error.jsp";
				href="<a href='javascript:window.history.go(-1)'>[����]</a>";
			}

		} else {
			messages="<li>ɾ����Ƭʧ�ܣ�</li>";
			forward="/admin/error.jsp";
			href="<a href='javascript:window.history.go(-1)'>[����]</a>";
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
		long maxsize = 2 * 1024 * 1024; 									// ����ÿ���ϴ��ļ��Ĵ�С��Ϊ2MB

		try {
			su.initialize(this.getServletConfig(), request, response);
			su.setMaxFileSize(maxsize); 									// �����ϴ��ļ��Ĵ�С
			su.setAllowedFilesList("jpg,gif,bmp");							// ���������ϴ����ļ�����
			su.upload();													// �ϴ��ļ�
			//su.save(filePath);
			String imageDesc=su.getRequest().getParameter("info");
			if(imageDesc==null||imageDesc.equals("")){						//��֤��Ƭ������Ϣ����û�����룬����ʾ������Ƭ������Ϣ
				messages="��������Ƭ������Ϣ��";
				forward="/admin/error.jsp";
				href="<a href='javascript:window.history.go(-1)'>[����]</a>";
			}
			else{
				File file = su.getFiles().getFile(0);						// ��ȡ�ϴ����ļ�����Ϊֻ�ϴ���һ���ļ������Կ�ֱ�ӻ�ȡ
				if (!file.isMissing()) { 									// ���ѡ�����ļ�
					String imageAddr=filePath+idao.findMaxId()+"."+file.getFileExt();		//filePathֵ(front\\photo\\pic\\)+ͼƬ��Ϣ�����ݱ��е�id�ֶ�ֵ+��.��+�ļ���׺��;����������硰front\photo\pic\12.bmp��·��
					String imageName=idao.findMaxId()+"."+file.getFileExt();
					Date now=new Date();				//��ȡ��ǰʱ�䲢��ʽ��Ϊ�ַ���
					image.setImgname(imageName);
					image.setImgurl(imageAddr.substring(6));
					image.setTime(now);
					image.setImgdesc(imageDesc);

					boolean mark=idao.uploadImage(image,tid);
					if(mark){
						try {

							file.saveAs(imageAddr,File.SAVEAS_VIRTUAL);
							messages="�ϴ��ļ��ɹ���";
							forward="admin/success.jsp";
							href="<a href='admin/photo/PhotoUpload.jsp'>[�����ϴ�]</a>";
						} catch (SmartUploadException ee) {
							messages="�ϴ��ļ�ʧ�ܣ�";
							forward="/admin/error.jsp";
							href="<a href='javascript:window.history.go(-1)'>[����]</a>";
							ee.printStackTrace();
						}
					}
					else{
						messages="�����ļ���Ϣʧ�ܣ�";
						forward="/admin/error.jsp";
						href="<a href='javascript:window.history.go(-1)'>[����]</a>";
					}
				}
				else{
					messages="��ѡ��Ҫ�ϴ����ļ���";
					forward="/admin/error.jsp";
					href="<a href='javascript:window.history.go(-1)'>[����]</a>";
				}
			}

		}catch (java.lang.SecurityException e){
			messages="<li>�ϴ��ļ�ʧ�ܣ��ϴ����ļ�����ֻ����Ϊ��jpg,gif,bmp</li>";
			forward="/admin/error.jsp";
			href="<a href='javascript:window.history.go(-1)'>[����]</a>";

		}catch (SmartUploadException e) {
			messages="�ϴ��ļ�ʧ�ܣ�";
			forward="/admin/error.jsp";
			href="<a href='javascript:window.history.go(-1)'>[����]</a>";
			e.printStackTrace();
		}

		request.setAttribute("messages",messages);
		request.setAttribute("href",href);

		response.sendRedirect(forward);
	}

}

