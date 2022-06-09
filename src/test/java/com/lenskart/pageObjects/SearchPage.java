package com.lenskart.pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public static WebDriver rdriver;
	public SearchPage(WebDriver ldriver)
	{
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	


	@FindBy(xpath="//input[@placeholder='What are you looking for ']")
	WebElement search;
	
	
	
	@FindBy(xpath="//div[@role='rowgroup']//div")
	private List<WebElement> links;
	
	@FindBy(xpath="//i[@class='search-icon']")
	WebElement searchIcon; 
	
	@FindBy(xpath="//span[normalize-space()='Technical Information']")
	WebElement techInfo;

	public void setSeacrh(String productname)
	{
		System.out.println(productname);
		search.sendKeys(productname);
		
	}
	public void setsubmit()
	{
		searchIcon.click();
	}
	public void setProduct() 
	{
		for(int i=1;i<2;i++)
		{
		  for(int j=1;j<2;j++)
		  {
			WebElement ele= rdriver.findElement(By.xpath("//div[@aria-label='grid']/div[@role='rowgroup']/div[1]/div["+j+"]"));
			ele.click();	
			Set<String> sh=rdriver.getWindowHandles();
			ArrayList<String> tabs= new ArrayList<String>(sh);
		String newtab=	tabs.get(1);
			rdriver.switchTo().window(newtab);
		  }
		}	
	}
	public void setTechInfo()
	{
		JavascriptExecutor je = (JavascriptExecutor) rdriver;
		je.executeScript("window.scrollBy(0,350)","");
		techInfo.click();
		je.executeScript("window.scrollBy(0,-350)","");
	}
	
}
