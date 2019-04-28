package com.passionInc.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig{

 Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String BaseURL=pro.getProperty("BaseURL");
		return BaseURL;
	}
	
	public String getFirstname()
	{
	String FirstName=pro.getProperty("FirstName");
	return FirstName;
	}
	
	public String getLastname()
	{
	String LastName=pro.getProperty("LastName");
	return LastName;
	}
	public String getEmail()
	{
		String Email=pro.getProperty("Email");
		return Email;
	}
	public String getInvalidEmail()
	{
		String Invalidemail=pro.getProperty("InvalidEmail");
		return Invalidemail;
	}
	
	public String getChromePath()
	{
	String Chromepath=pro.getProperty("Chromepath");
	return Chromepath;
	}
	
	
	
	
}
