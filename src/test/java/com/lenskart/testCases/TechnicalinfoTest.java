package com.lenskart.testCases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TechnicalinfoTest extends SearchTest {

	@Test
	public void  technicalInfo() throws IOException
	{
	driver.findElement(By.xpath("//div[@aria-label='show tech info btn']")).click();

	XSSFWorkbook wb=new XSSFWorkbook();
	XSSFSheet sh= wb.createSheet("Sheet1");
	
List<WebElement> ele= driver.findElements(By.xpath("//div[@class='fb-40']/div"));
//List<WebElement> el= driver.findElements(By.xpath("//div[@class='fb-55 padding-l30']/div"));


  for(int i=1;i<ele.size();i++)
  {
	  Row r0=sh.createRow(i);
	  for(int j=0; j<4;j++)
	  {
	 
	  Cell c0=r0.createCell(j);
	  if(j==0 && i!=0)
	  {
	  WebElement ele1=driver.findElement(By.xpath("//div[@class='fb-40']/div["+i+"]/div[1]/span"));
	   String str=ele1.getText();
	   c0.setCellValue(str);
	  }
	   else if(j==1 && i==2 || i==3)

	   {
		   WebElement ele2=driver.findElement(By.xpath("//div[@class='fb-40']/div["+i+"]/div[1]/span[2]/a"));
		   String str2=ele2.getText();
		   c0.setCellValue(str2);
	   }
	   else if(j==2 && i!=0)
		  {
		  WebElement ele4=driver.findElement(By.xpath("//div[@class='fb-55 padding-l30']/div["+i+"]/div/span"));
		   String str4=ele4.getText();
		   c0.setCellValue(str4);
		  }
	   else if (j==3)
	   {
		   WebElement ele5=driver.findElement(By.xpath("//div[@class='fb-55 padding-l30']/div["+i+"]/div/span[2]"));
		   String str5=ele5.getText();
		   c0.setCellValue(str5);
	   }
	   else
	   {
		   WebElement ele3=driver.findElement(By.xpath("//div[@class='fb-40']/div["+i+"]/div[1]/span[2]/span"));
		   String str3=ele3.getText();
		   c0.setCellValue(str3);
	   }
	  }
  } 
	

	File file=new File(System.getProperty("user.dir")+"/src/test/java/com/lenskart/testData/ShippingData.xlsx");
	FileOutputStream fis= new FileOutputStream(file);
	wb.write(fis);
	wb.close();

	}
}
