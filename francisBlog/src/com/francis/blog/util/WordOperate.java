package com.francis.blog.util;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class WordOperate {
	public void saveAsWord(String content, String path) throws Exception{
		InputStream inputStream = new ByteArrayInputStream(content.getBytes("UTF-8"));
		OutputStream outputStream = new FileOutputStream(path);
		POIFSFileSystem poifs = new POIFSFileSystem();
		poifs.createDocument(inputStream, "WordDocument");
		poifs.writeFilesystem(outputStream);
		outputStream.close();
		inputStream.close();
	}
}
