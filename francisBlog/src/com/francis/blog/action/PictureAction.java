package com.francis.blog.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component("picture")
@Scope("prototype")
public class PictureAction extends ActionSupport{
	private File file;
	private String fileFileName;
	private String fileContentType;
	
	private String result;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String load() throws Exception {
		String rootPath = ServletActionContext.getRequest().getRealPath("/upload");
		InputStream inputStream = new FileInputStream(file);
		File destFile = new File(rootPath, fileFileName);
		
//		File destFile = new File("E:/PictureUpload", fileFileName);
		OutputStream outputStream = new FileOutputStream(destFile);
		byte[] buffer = new byte[400];
		int length = 0;
		while((length = inputStream.read(buffer)) > 0){
			outputStream.write(buffer, 0, length);
			System.out.println("写入啊");
		}
		System.out.println(rootPath);
		System.out.println("enter dest " + fileFileName);
		inputStream.close();
		outputStream.close();
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("success", true + "");
		map.put("file_path", rootPath+fileFileName);
		JSONObject jsonObject = JSONObject.fromObject(map);
		this.result = jsonObject.toString();
		return SUCCESS;
	}
	
}
