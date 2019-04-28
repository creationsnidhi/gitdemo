package com.passionInc.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.passionInc.pageObject.PassionIncForm;

import junit.framework.Assert;

public class PI_TC_01 extends BassClass {
	
	@Test
	public void submit() throws InterruptedException {
		
		logger.info("Start the Test case PI_TC_01");
		
		logger.info("Open URL");
		driver.get(BaseURL);
		
		logger.info("Switch to frame");
		driver.switchTo().frame(0);
		
		PassionIncForm pf= new PassionIncForm(driver);
		
		logger.info("enter first name");
		pf.fName(FirstName);
		
		logger.info("enter last name");
		pf.lname(LastName);
		
		logger.info("enter email address");
		pf.email(Email);
		
		logger.info("click on submit");
		pf.clickSubmit();
		
		logger.info("alert is present or not");
		pf.isAlertPresent();
		
		String expValue="You have sucessfully registered!!";
	    if(pf.isAlertPresent()) {
	    	
	    	Alert alert = driver.switchTo().alert();
	    	System.out.println(alert.getText());
	    	String actValue=alert.getText();
	    	Assert.assertEquals(expValue, actValue);
	     
	    	logger.info("verify test case is passed or not");
	    	alert.accept();
	    	logger.info("Test case PI_TC_01 passed..");
	    }	
	}	
}
