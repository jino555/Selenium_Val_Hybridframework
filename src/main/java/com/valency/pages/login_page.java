package com.valency.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.valency.base.basetest;
import com.valency.utils.TestUtil;

public class login_page extends basetest {
	
	
	//PageObject
	
	 @FindBy (how=How.ID , using  ="auserid")
	 WebElement username;
	

	 @FindBy ( id = "apassword")
	 WebElement password;
  
	 
	 
	 @FindBy (how=How.XPATH ,using = "//button[@type='submit']")
	 WebElement submit;
	 
	 
	 public login_page() {
		 
		 PageFactory.initElements(driver, this);
	 }
	 
	 
	 //Actions
	 
	
	 public void login(String un , String pw)throws IOException {
		 
		 
		
		 TestUtil.acceptAlert(driver);
		 
		 username.sendKeys(un);
		 basetest.extenttest.info("Username entered " +un);
		 
		 
		 password.sendKeys(pw);
		 basetest.extenttest.info("Password entered "+pw);
		 
		 
		 submit.click();
		 basetest.extenttest.info("Submit clicked");
		 
		 TestUtil.acceptAlert(driver);
		 
		 
	 }
	 
	 
	 
	 
	 
	 
}
