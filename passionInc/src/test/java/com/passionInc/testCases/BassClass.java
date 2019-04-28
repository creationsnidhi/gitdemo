package com.passionInc.testCases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.passionInc.utilities.ReadConfig;

public class BassClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String BaseURL=readconfig.getApplicationURL();/*"https://jsfiddle.net/rlourenco/cp6bc9ka/4/embedded/result/";*///readconfig.getApplicationURL();
	public String FirstName=readconfig.getFirstname();
	public String LastName=readconfig.getLastname();
	public String Email=readconfig.getEmail();
	public String InvalidEmail=readconfig.getInvalidEmail();
	public WebDriver driver;
	public static Logger logger;//Added logger
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("passionInc");//Added logger
		PropertyConfigurator.configure("Log4j.properties");//Added logger
		if (br.equals("firefox")) {
			// Firefox Browser
			logger.info("open the firfox browse...");
			System.setProperty("webdriver.gecko.driver",readconfig.getChromePath());
			driver = new FirefoxDriver();
		}

		else if (br.equals("chrome")) {
			// chrome browser
			logger.info("Open the chrome browser...");
			System.setProperty("webdriver.chrome.driver", "D:/workspace/passionInc/Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (br.equals("ie")) {
			// ie  browser
			logger.info("open the IE browser...");
			System.setProperty("webdriver.ie.driver","D:/workspace/passionInc/Driver/IEDriver.exe");
			driver = new InternetExplorerDriver();
		}

		// Global implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("maximize the browser window...");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info("close the browser...");
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
}
