package com.inetbanking.utilities;

import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e){
			System.out.println("Exception is"+ e.getMessage());
		}
	}
	 
	public String getApplicationUrl()
	{
		String url=pro.getProperty("baseURL");
		return url;	
	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;	
	}
	
	public String getpwd()
	{
		String pwd=pro.getProperty("password");
		return pwd;	
	}
	
	public String getChromePath()
	{
		String chromePath=pro.getProperty("chromedriver");
		return chromePath;	
	}
	
	public String getFirefoxPath()
	{
		String FirefoxPath=pro.getProperty("firefoxDriver");
		return FirefoxPath;	
	}
	
	
}
