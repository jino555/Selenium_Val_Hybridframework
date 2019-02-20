//Userspage_locators

package com.valency.pages;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

import com.valency.base.basetest;
import com.valency.utils.Constants;
import com.valency.utils.TestUtil;



public class users_page extends basetest {
	
	
	
	
	String url = pro.getProperty("stagingurl");
	 
	//POM with PageFactory
	
	
	 
	 @FindBy (id = "name")
	 WebElement name;
	 
	 
	 @FindBy (how=How.ID , using="userid")
	 @CacheLookup
	 WebElement username;
	 
	 
	 @FindBy (id = "password")
	 WebElement password;
	 
	 
	 @FindBy (id = "confirm_password")
	  WebElement confirm_password;
	 
	 @FindBy (id ="select-hub-list")
	  WebElement hub_id;
	 
	 
	 @FindBy(xpath = "//input[@type='submit']")
	 WebElement submit;
	 
	
	 
	 @FindBy(xpath =  "//*[@id='userTable']/tbody/tr[1]/td[1]")
	 WebElement serial_no_xpath;
	 
	 @FindBy(xpath = "//*[@id='userTable']/tbody/tr[1]/td[2]")
	 WebElement name_xpath;
	 
	 @FindBy(xpath = "//*[@id='userTable']/tbody/tr[1]/td[3]")
	 WebElement username_xpath;
	 
	 @FindBy(xpath = "//*[@id='userTable']/tbody/tr[1]/td[4]")
	 WebElement hubcode_xpath;
	 
	 @FindBy (xpath = "//table[@id='userTable']/tbody/tr")
	 List<WebElement> namelist;
	 
			 
			 
	 //Intialising PageObjects
	 
	 public users_page() {
		 
		 PageFactory.initElements(driver, this);
		 
		 
	 }
	
	 
	 //Actions
	 
	
	public  void userdetails(String nm, String un, String pw, String cpw, String hub) throws IOException {
		
		 

		
		   basetest.extenttest.info("Navigated to " +url);
			
		    //TestUtil.acceptAlert(driver);
		     
		    name.sendKeys(nm);
		    basetest.extenttest.info("Name entered " +nm);
		    
		    
		    username.sendKeys(un);
		    basetest.extenttest.info("Username entered " +un);
		    
		    
		    password.sendKeys(pw);
		    basetest.extenttest.info("Password entered " +pw);
		    
		    
		    confirm_password.sendKeys(cpw);
		    basetest.extenttest.info("Confirmpassword entered " +cpw);
		     
		     
			Select dropdown = new Select (hub_id);
			dropdown.selectByVisibleText(hub);
	  
	
			 submit.click();
			 
			 TestUtil.acceptAlert(driver);
			
			}


		



  
			
	
public void userlist(String nm, String un, String pw, String cpw, String hub) {
			 
		//String before_xpath = "//table[@id='userTable']/tbody/tr[";
			 
		//String after_xpath = "]/td[2]";
		
		//String serial_no_xpath = "//*[@id='userTable']/tbody/tr[1]/td[1]";
		//String name_xpath = "//*[@id='userTable']/tbody/tr[1]/td[2]";
		//String username_xpath = "//*[@id='userTable']/tbody/tr[1]/td[3]";
		//String hubcode_xpath = "//*[@id='userTable']/tbody/tr[1]/td[4]";
		
		     //List<WebElement> row =namelist;
	       //   int row_count = row.size();
	    // System.out.println("Total no of rows " +row_count);
		
			// for(int i=1;i<row_count;i++) {
			
							
			// String actual_xpath = before_xpath + i +after_xpath;
			// WebElement element =  driver.findElement(By.xpath(actual_xpath));
			 ////*[@id="userTable"]/tbody/tr[1]/td[2]
	        
	           //driver.switchTo().alert().accept();
	         //WebElement serial_no  =  driver.findElement(By.xpath(serial_no_xpath));
			// WebElement name =  driver.findElement(By.xpath(name_xpath));
			// WebElement username =  driver.findElement(By.xpath(username_xpath));
			// WebElement hubcode =  driver.findElement(By.xpath(hubcode_xpath));
	
			 System.out.println("SerialNo  is verified " +serial_no_xpath.getText());
			 
			 if( name_xpath.getText().equals(nm)) {

			 System.out.println("Name  is verified " +name_xpath.getText());
			 basetest.extenttest.info("Name is Verfied in the Listing page " +nm);
			 }
			 
			 
			 
			 if (username_xpath.getText().equals(un)) {
			 System.out.println("UserName  is verified " +username_xpath.getText());
			 basetest.extenttest.info("UserName is Verfied in the Listing page " +un);
			 }
			 
			 
			 if (hubcode_xpath.getText().equals(hub)) {
			 System.out.println("hubCode  is verified " +hubcode_xpath.getText());
			 basetest.extenttest.info("HubCode is Verfied in the Listing page " +hub);
			 }
			 
			 
	  }}



			 

 

 


