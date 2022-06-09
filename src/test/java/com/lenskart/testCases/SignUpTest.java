package com.lenskart.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lenskart.pageObjects.SignUpPage;
import com.lenskart.utility.XlUtils;

public class SignUpTest extends BaseClass {

	@Test(dataProvider="SignUpData")
	public void signUpTest(String firstName, String LastName, String Mob, String Email, String Password) {
		 SignUpPage sup = new SignUpPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sup.setFirstName(firstName);
		sup.setLastname(LastName);
		sup.setMobile(Mob);
		sup.setEmail(Email);
		sup.setpassword(Password);
		sup.clickRegister();
		WebElement menuOption = driver.findElement(By.xpath("//div[@class='login-panel']"));
    	if(menuOption.isDisplayed()) {
       	 Assert.assertTrue(true);
            System.out.println("SignUp is Successfull");
        }
        else {
        	 Assert.assertTrue(false);
            
        }
		
	}
	
	@DataProvider(name ="SignUpData") 
	public Object[][] excelDP() {
		XlUtils xl=new XlUtils();
		Object[][] arrObj = xl.getExcelData(System.getProperty("user.dir")+"/src/test/java/com/lenskart/testData/SignUp.xlsx", "Sheet1");
		return arrObj;
	}
	
	@BeforeTest()
	public void base() {
		driver.get(baseURL);

		if (driver.findElement(By.xpath("//*[@id='wzrk_wrapper']")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='wzrk-cancel']")).click();
		}
       SignUpPage sup = new SignUpPage(driver);
        sup.clickSignUp();
		
	}
}
