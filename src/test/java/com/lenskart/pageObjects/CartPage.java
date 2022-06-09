package com.lenskart.pageObjects;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	public static WebDriver rdriver;
	
	public CartPage(WebDriver ldriver)
	{
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//button[@class='btn btn-topaz bg-color-primary buy-now-btn']")
	WebElement ByNow;
	
	@FindBy(xpath="//i[@aria-label='increase product item quantity']")
	WebElement increaseQty;
	
	@FindBy(xpath="//i[@aria-label='decrease product item quantity']")
	WebElement DecreaseQty;
	
	@FindBy(xpath="//a[@aria-label='proceed to checkout']")
	WebElement CheckOut;
	
	@FindBy(xpath="//div[@class='cart-content crt-prd-block']/div[1]/div")
	private List<WebElement> ele;
	
	@FindBy(xpath="//i[@class='cart-item_remove-icon']")
	WebElement empty;
	
	@FindBy(xpath="//span[@class='text-uppercase']")
	WebElement val;
	
	public void clickBynow()
	{
		ByNow.click();
	}
	
	
	public void clickIncrease()
	{
		increaseQty.click();
	}
	
	public void clickDecrease()
	{
		DecreaseQty.click();
	}
	public void clickCheckOut()
	{
		CheckOut.click();
	}
	
	public void setEmpty()
	{
		System.out.println(ele.size());
		for(int i=0; i<=ele.size();i++)
		{
			 WebDriverWait wait=new WebDriverWait(rdriver,10);
	    	 wait.until(ExpectedConditions.visibilityOf(empty));
			empty.click();
		}
	}
	
	public Boolean setval()
	{
		boolean tr=val.isEnabled();
		val.click();
		return tr;
				
	}
}
