package com.passionInc.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassionIncForm {
	
	public WebDriver driver;
	
	public PassionIncForm(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	     
	}

	
	@FindBy(id="firstName")
	@CacheLookup
	WebElement txtfirstname;
	
	@FindBy(xpath="//*[@id=\"lastName\"]")
	@CacheLookup
	WebElement txtlastname;
	
	@FindBy(xpath="//*[@id=\"emailAddress\"]")
	@CacheLookup
	public WebElement txtemail;
	
	@FindBy(id="bySubmit")
	@CacheLookup
	WebElement btnsubmit;
	
	public void fName(String fname)
	{
		WebDriverWait wait = new WebDriverWait(driver,1000);
		wait.until(ExpectedConditions.visibilityOf(txtfirstname));
		txtfirstname.clear();
		txtfirstname.sendKeys(fname);
	}
	
	public void lname(String lname)
	{
		WebDriverWait wait = new WebDriverWait(driver,1000);
		wait.until(ExpectedConditions.visibilityOf(txtlastname));
		txtlastname.clear();
		txtlastname.sendKeys(lname);
	}
	public void email(String email)
	{
		WebDriverWait wait = new WebDriverWait(driver,1000);
		wait.until(ExpectedConditions.visibilityOf(txtemail));
		txtemail.clear();
		txtemail.sendKeys(email);
	}
	
	public void clickSubmit()
	{
	WebDriverWait wait = new WebDriverWait(driver,1000);
	wait.until(ExpectedConditions.visibilityOf(btnsubmit));
	btnsubmit.click();
	}

	public boolean isAlertPresent() 
    { 
        try 
        { 
            driver.switchTo().alert(); 
            return true; 
        }   // try 
        catch (NoAlertPresentException Ex) 
        { 
            return false; 
        }   // catch 
    }   // isAlertPresent() 
	
	public void handleAlert(){
        if(isAlertPresent()){
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
          }
        }
	public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }
}

