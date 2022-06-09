package com.lenskart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TechnicalInfoPage {
	public static WebDriver rdriver;
	public TechnicalInfoPage(WebDriver ldriver)
	{
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	


	@FindBy(xpath="//input[@placeholder='What are you looking for ']")
	WebElement search;
}
