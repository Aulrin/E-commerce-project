package com.niit.util;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component // create singleton instance and name is fileutil
public class FileUtil {

	@Autowired
	private HttpSession httpSession;
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	private static String rootPath = System.getProperty("niitprojects.dir");
	public boolean fileCopyNIO(MultipartFile file, String fileName) {
		System.out.println(rootPath);
		File dest = new File(rootPath + File.separator + fileName);
		System.out.println("where it is uploading ??" + dest.getAbsolutePath());
		try {
			file.transferTo(dest);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
