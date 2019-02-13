//Users_testcase


package com.valency.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.valency.base.basetest;
import com.valency.pages.users_page;
import com.valency.utils.Constants;
import com.valency.utils.TestUtil;

public class users_test extends basetest{
  
	users_page user;
	
	
	@BeforeMethod
	public void setup() {
	    
		
		user = new users_page();
		
		
	}
	
	
	
@Test(dataProvider ="testdata")

  public void VerifyUserDetails(String name ,String username, String password, String confirm_password, String hub_id) throws IOException {
		
		
		user.userdetails(name,username, password ,confirm_password, hub_id);
		
		
	}
		
		
@Test(dataProvider ="testdata")
	
	public void Verifyuserlist(String name ,String username, String password, String confirm_password, String hub_id){
		
		user.userlist(name,username, password ,confirm_password, hub_id);
		
	}
  
	
	

	@DataProvider(name = "testdata")
	   public Object [][] getdata(){
		   
		   
		   Object data [][] = TestUtil.testdata(Constants.path_TestData, Constants.secondsheet_TestData);
		   
		   return data;
	   }
		   
		 
	
	
}
