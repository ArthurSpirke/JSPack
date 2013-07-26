package com.arthurspirke.jspack.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class ServiceUtils {
  private static ResourceBundle res = ResourceBundle.getBundle("com.arthurspirke.jspack.prop");
	
	
	public static String createHeaderOfFile(String finalFile) {
		StringBuffer sb = new StringBuffer();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		sb.append("/*\r\n");
		sb.append("#\r\n");
		sb.append("#\r\n");
		sb.append("# File name - " + finalFile + "\r\n");
		sb.append("# Create Date - " + dateFormat.format(cal.getTime()) + "\r\n");
		sb.append("#\r\n");
		sb.append("# Created by JSPack (https://github.com/ArthurSpirke/JSPack)\r\n");
		sb.append("#\r\n");
		sb.append("#\r\n");
		sb.append("*/\r\n");

		return sb.toString();
	}

	public static String createWhiteSpace() {
		StringBuffer sb = new StringBuffer();
		sb.append("\r\n");
		sb.append("\r\n");
		sb.append("\r\n");
		return sb.toString();
	}
	
	
	public static String getCurrentProject(){
		return res.getString("assembly_project");
	}
}


