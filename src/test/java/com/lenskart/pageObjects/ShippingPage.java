package com.lenskart.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
	
	public static WebDriver rdriver;
	public ShippingPage(WebDriver ldriver)
	{
		rdriver=ldriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;

	@FindBy(xpath="//input[@name='phone']")
	WebElement mobile;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="addressline1")
	WebElement addressLine1;
	
	@FindBy(id="addressline2")
	WebElement addressLine2;

	@FindBy(id="postcode")
	WebElement zipCode;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(xpath="//input[@name='country']")
	WebElement country;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	//comment to be checked
	@FindBy(xpath="//input[@name='showComments']")
	WebElement checkComment;
	
	@FindBy(id="comment")
	WebElement comment;
	
	@FindBy(xpath="//input[@name='showGift']")
	WebElement showgift;
	
	@FindBy(xpath="//input[@name='senderPhone']")
	WebElement senderPhone;
	
	@FindBy(id="receiverName")
	WebElement receiver;
	
	@FindBy(id="senderName")
	WebElement senderName;
	
	@FindBy(id="message")
	WebElement message;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement conti;
	public void setfirstName(String name)
	{
		firstName.sendKeys(Keys.CONTROL + "a");
		firstName.sendKeys(Keys.DELETE);
		firstName.sendKeys(name);
	}
	
	public void setlastName(String password)
	{
		lastName.sendKeys(Keys.CONTROL + "a");
		lastName.sendKeys(Keys.DELETE);
		lastName.sendKeys(password);
	}
	
	public void setMobile(String name)
	{
		mobile.sendKeys(Keys.CONTROL + "a");
		mobile.sendKeys(Keys.DELETE);
		mobile.sendKeys(name);
	}
	
	public void setEmail(String password)
	{
		
		email.sendKeys(Keys.CONTROL + "a");
		email.sendKeys(Keys.DELETE);
		email.sendKeys(password);
	}
	
	public void setAddressLine1(String name)
	{
		addressLine1.sendKeys(Keys.CONTROL + "a");
		addressLine1.sendKeys(Keys.DELETE);
		addressLine1.sendKeys(name);
	}
	
	public void setAddressLine2(String password)
	{
		addressLine2.sendKeys(Keys.CONTROL + "a");
		addressLine2.sendKeys(Keys.DELETE);
		addressLine2.sendKeys(password);
	}
	
	public void setzipCode(String password)
	{
		zipCode.sendKeys(Keys.CONTROL + "a");
		zipCode.sendKeys(Keys.DELETE);
		zipCode.sendKeys(password);
	}
	public void setCity(String password)
	{
		city.sendKeys(Keys.CONTROL + "a");
		city.sendKeys(Keys.DELETE);
		city.sendKeys(password);
	}
	
	/*public void setState()
	{
		
		city.sendKeys();
	}
	public void setCountry()
	{
	
		city.sendKeys();
	}
	*/

//---------new ----------------------------------------------------------------------------------------------------
	

	public void setcheck(String value)
	{
		
		if(checkComment.isSelected())
		{
			city.sendKeys(Keys.CONTROL + "a");
			city.sendKeys(Keys.DELETE);
		   comment.sendKeys(value);
		}
		else 
		{
			checkComment.click();
		   comment.sendKeys(value);
		}
	}
	
	public void setshowgift(String name, String rece, String send, String Messages )
	{
		
		if(showgift.isSelected())
		{
		senderPhone.sendKeys(Keys.CONTROL + "a");
	    senderPhone.sendKeys(Keys.DELETE);
		senderPhone.sendKeys(name);
		
		receiver.sendKeys(Keys.CONTROL + "a");
		receiver.sendKeys(Keys.DELETE);
		receiver.sendKeys(rece);
		
		senderName.sendKeys(Keys.CONTROL + "a");
		senderName.sendKeys(Keys.DELETE);
		senderName.sendKeys(send);
		
		message.sendKeys(Keys.CONTROL + "a");
		message.sendKeys(Keys.DELETE);
	    message.sendKeys(Messages);
		}
		else
		{
			showgift.click();
			senderPhone.sendKeys(name);
			receiver.sendKeys(rece);
			senderName.sendKeys(send);
		  message.sendKeys(Messages);
		}
	}
	
	public void Continue()
	{
		conti.click();
	}
	public void empty()
	{
		List<WebElement> ele=rdriver.findElements(By.xpath("//div[@class='row checkout-cart-items']/div"));
		System.out.print(ele.size());
		
		for(int i=1;i<=ele.size();i++)
		{
			rdriver.findElement(By.xpath("//div[@class='row checkout-cart-items']//div["+i+"]//div[1]//div[3]//span")).click();
		}
	}
	
}
