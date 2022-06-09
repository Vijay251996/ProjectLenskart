package com.lenskart.testCases;


	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

	import org.testng.annotations.Test;
	import com.lenskart.pageObjects.Sunglass;

	public class SearchTechinfo extends LoginTest{
		@Test
		public void searchTest() throws IOException {
		
			Sunglass sp = new Sunglass(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			int count=0;
			for(int i=1;i<=3;i++)
			{
				for(int l=1;l<=3;l++)
				{
					int m=count++;
			sp.setSeacrh(productname);
			sp.setsubmit();
			sp.setProduct(i,l);
			sp.setTechInfo();
			sp.technicalInfo(m);
			}
			}
			

		}
		
		
	}

