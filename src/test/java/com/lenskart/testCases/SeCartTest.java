package com.lenskart.testCases;

import org.testng.annotations.Test;

import com.lenskart.pageObjects.CartPage;

public class SeCartTest extends SearchTest{

	@Test(dependsOnMethods={"searchTest"})
	public void cartTest()
	{
		
		CartPage cp=new CartPage(driver);
		cp.clickBynow();
		cp.clickIncrease();
		cp.clickDecrease();
		cp.clickCheckOut();
	}
}
