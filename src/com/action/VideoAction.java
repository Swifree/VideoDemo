package com.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;

import com.entity.Video;
import com.opensymphony.xwork2.ActionSupport;
import com.settting.Constant;
import com.utils.HibernateUtils;

public class VideoAction extends BaseAction<Video>{
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	
	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}



	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}
	


	/**
	 * @return the fileFileName
	 */
	public String getFileFileName() {
		return fileFileName;
	}



	/**
	 * @param fileFileName the fileFileName to set
	 */
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}



	/**
	 * @return the fileContentType
	 */
	public String getFileContentType() {
		return fileContentType;
	}



	/**
	 * @param fileContentType the fileContentType to set
	 */
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String list()
	{
		List<Video> list=HibernateUtils.query("from Video");
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}
	public String add()
	{
		if(file==null) return null;
		System.out.println(fileFileName);
		String filePath=ServletActionContext.getServletContext().getRealPath(Constant.VIDEODIR)+"\\"
		+fileFileName;
		System.out.println("filePath="+filePath);
		entity.setUrl("video/"+fileFileName);
		try {
			FileUtils.copyFile(file, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.add();
	}
}
