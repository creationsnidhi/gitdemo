package com.passionInc.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.passionInc.pageObject.PassionIncForm;
import com.passionInc.utilities.XLUtils;

public class PI_TC_02 extends BassClass{
	
	@Test(dataProvider="DataNegative")
	public void submitNegative(String fName, String lName, String emailAddress)
	
	{
		logger.info("start the Test case PI_TC_02");
		logger.info("open URL..");
		driver.get(BaseURL);
		logger.info("switch to frame..");
		driver.switchTo().frame(0);
		PassionIncForm pf= new PassionIncForm(driver);
		logger.info("first name provided..");
		pf.fName(fName);
		logger.info("last name provided..");
		pf.lname(lName);
		logger.info("email address provided..");
		pf.email(emailAddress);
		logger.info("clicked submit..");
		pf.clickSubmit();
		
		String lastVal="Please enter valid last name.";
		String firstVal="Please enter valid first name.";
		String emailVal="Please enter valid email address.";
		if(pf.isAlertPresent()) {
			Alert alert=driver.switchTo().alert();
			System.out.println(alert.getText());
			logger.info("please enter valid lastname message on alert window.");
			String lastact_val=alert.getText();
			if(alert.getText().contains(firstVal)) {
				logger.info("Enter a First Name");
				String actfirst_val=alert.getText();
				Assert.assertEquals(actfirst_val,firstVal);
				Assert.assertTrue(true);
			} else if(alert.getText().contains(lastVal)) {
				logger.info("Enter a Last Name");
		    	Assert.assertEquals(lastact_val,lastVal);			
		    	Assert.assertTrue(true);
			} else if(alert.getText().contains(emailVal)) {
				logger.info("Enter a Email Address");
				String actemail_val=alert.getText();
				Assert.assertEquals(actemail_val,emailVal);
				Assert.assertTrue(true);
			}
			logger.info("verify testdata is passed or not");
			alert.accept();
			logger.info("Click OK button on alert window");
		} else {
			Assert.fail();
		}
	}
	
	@DataProvider(name="DataNegative")
	public String [][] getdata() throws IOException {
		String path=System.getProperty("user.dir")+"/src/test/java/com/passionInc/testData/DataNegative.xlsx";
		int rowNum=XLUtils.getRowCount(path, "Sheet1");
		
		int colCount=XLUtils.getCellCount(path,"Sheet1",1);
		logger.info("Print value row and column.."+rowNum + " "+ colCount);
		String submitData[][]=new String[rowNum][colCount];
		
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<colCount;j++) {
				submitData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
	    	}
		}
		return submitData;	
	}
}

	


