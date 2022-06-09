package com.lenskart.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lenskart.pageObjects.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		LoginPage lg = new LoginPage(driver);
		driver.get(baseURL);

		if (driver.findElement(By.xpath("//*[@id='wzrk_wrapper']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='wzrk-cancel']")).click();
		}
		lg.clickSignIn();
		lg.username(username); 
		lg.loginbtn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lg.userpass(password);
		lg.loginbtn();

		/*Actions act=new Actions(driver);
		WebElement menuOption = driver.findElement(By.xpath("//div[@class='login-panel']"));
    	act.moveToElement(menuOption).perform();
    	WebElement subMenuOption = driver.findElement(By.linkText("Account Information")); 
    	act.moveToElement(subMenuOption);
    */
		WebElement menuOption = driver.findElement(By.xpath("//div[@class='login-panel']"));
    	if(menuOption.isDisplayed()) {
       	 Assert.assertTrue(true);
            System.out.println("Login Is Successful");
        }
        else {
        	 Assert.assertTrue(false);
            
        }
	}
    	

		}
		