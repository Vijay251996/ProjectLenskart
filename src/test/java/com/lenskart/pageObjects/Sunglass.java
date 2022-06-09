package com.lenskart.pageObjects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sunglass {

	public static WebDriver rdriver;

	public Sunglass(WebDriver ldriver) {
		rdriver = ldriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@placeholder='What are you looking for ']")
	WebElement search;

	@FindBy(xpath = "//div[@role='rowgroup']//div")
	private List<WebElement> links;

	@FindBy(xpath = "//i[@class='search-icon']")
	WebElement searchIcon;

	@FindBy(xpath = "//span[normalize-space()='Technical Information']")
	WebElement techInfo;

	@FindBy(className = "ok-btn padding-5 fs14 letter-spacing-1 bg-white text-topaz text-uppercase")
	WebElement okBtn;

	public void setSeacrh(String productname) {
		System.out.println(productname);
		search.sendKeys(productname);

	}

	public void setsubmit() {
		searchIcon.click();
	}

	public void setProduct(int j, int k) {
		WebElement ele = rdriver.findElement(By.xpath("//div[@aria-label='grid']/div[@role='rowgroup']/div[" + j + "]/div[" + k + "]"));
		ele.click();
		ArrayList<String> tabs = new ArrayList<String>(rdriver.getWindowHandles());
		rdriver.switchTo().window(tabs.get(1));
		rdriver.switchTo().window(tabs.get(0));
		rdriver.close();
		tabs = new ArrayList<String>(rdriver.getWindowHandles());
		rdriver.switchTo().window(tabs.get(0));

	}

	public void setTechInfo() {
		Actions act = new Actions(rdriver);
		act.pause(Duration.ofSeconds(3));
		act.doubleClick().perform();
		JavascriptExecutor je = (JavascriptExecutor) rdriver;
		je.executeScript("window.scrollBy(0,350)", "");
		techInfo.click();
		je.executeScript("window.scrollBy(0,-350)", "");
	}

	public void technicalInfo(int i) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("Sheet1");

		List<WebElement> ele = rdriver.findElements(By.xpath("//div[contains(@class,'panel-collapse')]/div[@aria-label='panel']/div[2]/div"));
		System.out.println(ele.size());
//List<WebElement> el= driver.findElements(By.xpath("//div[@class='fb-55 padding-l30']/div"));

		for (int i1 = 1; i1 <= ele.size()+1; i1++) {
			Row r0 = sh.createRow(i1);
			for (int j = 0; j < 2; j++)
				{
				int n=i1-1;
				Cell c0 = r0.createCell(j);
				if(i1==1 && j==0)
				{  
                  WebElement ele1=rdriver.findElement(By.xpath("//div[@aria-label='panel']/div[contains(@class,'panel-collapse')]/div/div["+i1+"]/span"));
       		      String str1=ele1.getText();
       		      System.out.println(str1);
       		       c0.setCellValue(str1);
				}
				else if(i1==1 && j==1)
				{
					WebElement ele2=rdriver.findElement(By.xpath("//div[@aria-label='panel']/div[contains(@class,'panel-collapse')]/div/div["+i1+"]/span[2]"));
					   String str2=ele2.getText();
					   c0.setCellValue(str2);
					   System.out.println(str2);
				}
				else if (i1!=1 && j==0)
				{
					 WebElement ele4=rdriver.findElement(By.xpath("//div[@aria-label='panel']/div[contains(@class,'panel-collapse')]/div/div[2]/div["+n+"]/span"));
					   String str4=ele4.getText();
					   c0.setCellValue(str4);
					   System.out.println(str4);
				}
				else
				{
					 WebElement ele5=rdriver.findElement(By.xpath("//div[@aria-label='panel']/div[contains(@class,'panel-collapse')]/div/div[2]/div["+n+"]/span[2]/span"));
					   String str5=ele5.getText();
					   c0.setCellValue(str5);
					   System.out.println(str5);
				}
			} 
		}
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "Technical -Info-" + timeStamp + ".html";
		File file = new File(
				System.getProperty("user.dir") + "/src/test/resources/TestData/TestData_" + i + repName + ".xls");
		FileOutputStream fis = new FileOutputStream(file);
		wb.write(fis);
		wb.close();
		

	}
}
