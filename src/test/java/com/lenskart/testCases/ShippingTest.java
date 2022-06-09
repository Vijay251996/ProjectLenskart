package com.lenskart.testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.lenskart.pageObjects.ShippingPage;
import com.lenskart.utility.XlUtils;


public class ShippingTest extends SeCartTest
{
	public static int count=1; 
	
	@Test(dataProvider="ShipData", dependsOnMethods={"cartTest"})
	public void ziShipping(String user,String last, String Mobile, String emailId, String AdressLine1,String AdressLine2, String zipCode, String cityname) throws InterruptedException
	{
		ShippingPage shp=new ShippingPage(driver);
		Thread.sleep(1000);
		shp.setfirstName(user);
		shp.setlastName(last);
		shp.setMobile(Mobile);
		shp.setAddressLine1(AdressLine1);
		shp.setAddressLine2(AdressLine2);
		shp.setzipCode(zipCode);
		while(count>0)
		{
		shp.empty();
		count--;
		}
		if(count==0)
		{
			shp.Continue();
		}
		 WebElement contBtn=driver.findElement(By.xpath("//a[@class='continue-shopping title']"));
         boolean isBoxPresent = contBtn.isEnabled();
         if(isBoxPresent) {
        	 Assert.assertTrue(true);
             System.out.println("Continue Your Shopping");
             contBtn.click();
         }
         else
         {
             Assert.fail(" box is not present in the webpage");
         }

	}
	
	
	
	@DataProvider(name ="ShipData") 
	public Object[][] excelDP() {
		XlUtils xl=new XlUtils();
		Object[][] arrObj = xl.getExcelData(System.getProperty("user.dir")+"/src/test/java/com/lenskart/testData/ShippingData.xlsx", "Sheet1");
		return arrObj;
	}

	
	
}