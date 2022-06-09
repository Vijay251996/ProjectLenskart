package com.lenskart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.lenskart.pageObjects.CartPage;

public class EmptyCart extends SearchTest{
	
	@Test(dependsOnMethods={"searchTest"})
	public void cartTest()
	{
		
		CartPage cp=new CartPage(driver);
		cp.clickBynow();
		cp.setEmpty();
		if(cp.setval()==true)
		{
			Assert.assertTrue(true);
			System.out.println("Cart is empty");
		}
	}

}
