package com.lenskart.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
public static WebDriver rdriver;
	
	public SignUpPage(WebDriver ldriver)
	{
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//span[normalize-space()='Sign Up']")
	WebElement signUp;
	
	@FindBy(xpath="//span[contains(text(),'Please enter a valid mobile number (eg. 9987XXXXXX')]")
	WebElement mobveri;
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastname; 	 	
	
	@FindBy(xpath="//input[@name='mobile']")                                                                                                            
	WebElement mobile;
	
	@FindBy(xpath="//input[@name='email']")                                                                                                            
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")                                                                                                            
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Register']")                                                                                                            
	WebElement register;
	
	public void clickSignUp()
	{
		signUp.click();
	}
	
	
	public void setFirstName(String name)
	{
		firstname.sendKeys(Keys.CONTROL + "a");
		firstname.sendKeys(Keys.DELETE);
		firstname.sendKeys(name);
	}
	
	public void setLastname(String last)
	{
		lastname.sendKeys(Keys.CONTROL + "a");
		lastname.sendKeys(Keys.DELETE);
		lastname.sendKeys(last);
	}
	
	public void setMobile(String mobNo)
	{
		mobile.sendKeys(Keys.CONTROL + "a");
		mobile.sendKeys(Keys.DELETE);
		mobile.sendKeys(mobNo);
	}
	
	public void setEmail(String e_mail)
	{
		email.sendKeys(Keys.CONTROL + "a");
		email.sendKeys(Keys.DELETE);
		email.sendKeys(e_mail);
	}
	
	public void setpassword(String passwords)
	{
		password.sendKeys(Keys.CONTROL + "a");
		password.sendKeys(Keys.DELETE);
		password.sendKeys(passwords);
	}
	
	public void clickRegister()
	{
		register.click();
	}
}
