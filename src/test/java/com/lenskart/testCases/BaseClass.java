package com.lenskart.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.lenskart.utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	ReadConfig rd=new ReadConfig();
	public String baseURL=rd.getApplicationURL();
	public String username=rd.getUsername();
	public String password=rd.getPassword();
	public String productname= rd.getProduct();
	
	//signup
	public String firstName=rd.getFirstName();
	public String lastname=rd.geLastname();
	public String email=rd.getEmail();
	public String mob=rd.getMobile();
  
	public static Logger logger;

    @Parameters("browser")
	@BeforeTest
	public void launchapp(String br)
	{
              if (br.equals("chrome"))
              {
            	  WebDriverManager.chromedriver().setup();
            	  driver=new ChromeDriver();
            	  driver.manage().window().maximize();
            	   }
              else if (br.equals("firefox"))
              {
            	  WebDriverManager.firefoxdriver().setup();
            	  driver=new FirefoxDriver();
            	   }
              else if (br.equals("edge"))
              {
            	  WebDriverManager.edgedriver().setup();
            	  driver=new EdgeDriver();
            	   }
              
	}
    public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
    }

}
