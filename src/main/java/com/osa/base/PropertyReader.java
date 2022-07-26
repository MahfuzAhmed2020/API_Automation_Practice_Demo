package com.osa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {
	public static String readProperty(String key) {
	Properties pro=new Properties();
	try {
	FileInputStream fs=new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties"));
	pro.load(fs);
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
   String value= pro.getProperty(key).toString();
 return value;
}



}
