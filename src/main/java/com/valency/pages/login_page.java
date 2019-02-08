package com.valency.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.valency.base.basetest;

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
	 
	
	 public void login()throws IOException {
		 
		 
		 
		 
		 driver.switchTo().alert().accept();
		 
		 username.sendKeys("admin");
		// basetest.extenttest.info("Username entered " );
		 
		 
		 password.sendKeys("admin@123#");
		 basetest.extenttest.info("Password entered ");
		 
		 
		 submit.click();
		 basetest.extenttest.info("Submit clicked");
		 
	 }
	 
	 
	 
	 
	 
	 
}
