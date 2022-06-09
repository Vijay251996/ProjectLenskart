package com.lenskart.testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.lenskart.pageObjects.ShippingPage;
import com.lenskart.utility.XlUtils;

public class ShippingWithWrapTest extends SeCartTest {
	
	

	@Test(dataProvider="ShipData", dependsOnMethods={"cartTest"})
	public void ziShipping(String user,String last, String Mobile, String emailId, String AdressLine1,String AdressLine2, 
			               String zipCode, String cityname,String comment, String phone, String recName, String sendName, String messag) throws InterruptedException
	{

		ShippingPage shp=new ShippingPage(driver);
		shp.setfirstName(user);
		shp.setlastName(last);
		shp.setMobile(Mobile);
		shp.setEmail(emailId);
		shp.setAddressLine1(AdressLine1);
		shp.setAddressLine2(AdressLine2);
		shp.setzipCode(zipCode);
		//shp.setCity(cityname);
		shp.setcheck(comment);
		shp.setshowgift(phone, recName, sendName, messag);
		shp.Continue();
		
		 WebElement password=driver.findElement(By.xpath("//input[@placeholder='Enter Card Number']"));
         boolean isBoxPresent = password.isDisplayed();
         if(isBoxPresent) {
        	 Assert.assertTrue(true);
             System.out.println("Box is present");
         }
         else
             Assert.fail("Password text box is not present in the webpage");

	}
	
	
	
	@DataProvider(name ="ShipData") 
	public Object[][] excelDP() {
		XlUtils xl=new XlUtils();
		Object[][] arrObj = xl.getExcelData(System.getProperty("user.dir")+"/src/test/java/com/lenskart/testData/ShippingDataComment.xlsx", "Sheet1");
		return arrObj;
	}
	
	
}
