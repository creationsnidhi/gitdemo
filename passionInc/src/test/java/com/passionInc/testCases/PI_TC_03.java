package com.passionInc.testCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.passionInc.pageObject.PassionIncForm;

public class PI_TC_03 extends BassClass {
	
	@Test
	public void chechemailformat() {
		logger.info("Start the Test case PI_TC_03");
		logger.info("Open URL");
		driver.get(BaseURL);
		logger.info("Switch to frame");
		driver.switchTo().frame(0);
	
		PassionIncForm pf= new PassionIncForm(driver);
		
		logger.info("enter first name");
		pf.fName(FirstName);
		
		logger.info("enter last name");
		pf.lname(LastName);
		
		logger.info("enter invalid email");
		pf.email(InvalidEmail);
	
		logger.info("click submit");
		pf.clickSubmit();
		
		logger.info("alert is present or not");
		pf.isAlertPresent();
	
		String emailVal="Please enter valid email address.";
		if(pf.isAlertPresent()) {
			
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			String actEmailVal=alert.getText();
			Assert.assertEquals(actEmailVal,emailVal);
			Assert.assertTrue(true);
			
			logger.info("Verify testdata is passed or not");
			alert.accept();
			logger.info("Press ok on Alert window");
		}
		logger.info("Clear the email address field");
		pf.txtemail.clear();
		
		logger.info("enter valid email address");
		pf.email(Email);
		
		logger.info("Verify the email format");
		if(pf.isValidEmailAddress(Email)) {
			
			logger.info("Valid Email Address");
			Assert.assertTrue(true);
			
			logger.info("Click submit");
			pf.clickSubmit();
			
			logger.info("Verify the alert");
			pf.isAlertPresent();
		
			String expValue="You have sucessfully registered!!";
			if(pf.isAlertPresent()) {
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
	     
				String actValue=alert.getText();
				Assert.assertEquals(expValue, actValue);
				
				logger.info("verify test case is passed or not");
				alert.accept();
				logger.info("Click ok on alert window");
			} else {
				logger.info("InvalidEmail Address");
				Assert.fail();
			}
		}
	}
}
