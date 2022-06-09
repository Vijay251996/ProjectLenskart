package com.lenskart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	public static WebDriver rdriver;
	
	public LoginPage(WebDriver ldriver)
	{
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//span[normalize-space()='Sign In &']")
	WebElement signin;
	@FindBy(xpath="//*[@id='wzrk-cancel']")
	WebElement popup;
	@FindBy(xpath="//input[@placeholder='Mobile / Email']")                                                                                                            
	WebElement usrname;
	
	@FindBy(xpath="//input[@placeholder='Please enter password']")                                                                                                            
	WebElement pass;
	
	@FindBy(xpath="//button[normalize-space()='Proceed']")                                                                                                            
	WebElement btnLogin;
	
	
	public void username(String name)
	{
		WebDriverWait wait=new WebDriverWait(rdriver,10);
   	 wait.until(ExpectedConditions.visibilityOf(usrname));
		usrname.sendKeys(name);
	}
	
	public void userpass(String password)
	{
		pass.sendKeys(password);
	}
	
	public void loginbtn()
	{
		btnLogin.click();
		
	}
	
	public void clickSignIn()
	{
		signin.click();
		
	}
	public void popUps()
	{
		popup.click();
		
	}
}

