package com.lenskart.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		pro = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/Configuration/Config.properties");
		
			pro.load(fis);  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	

	//SignUP
	
	public String getFirstName()
	{
		String first=pro.getProperty("FirstName");
		return first;
	}
	
	public String geLastname()
	{
	String last=pro.getProperty("Lastname");
	return last;
	}
	
	public String getEmail()
	{
	String emailId=pro.getProperty("email");
	return emailId;
	}
	public String getMobile()
	{
	String phone=pro.getProperty("MobileNo");
	return phone;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	public String getProduct()
	{
	String prod=pro.getProperty("productname");
	return prod;
	}
}
