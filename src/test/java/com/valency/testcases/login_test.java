package com.valency.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.valency.base.basetest;
import com.valency.pages.login_page;
import com.valency.pages.users_page;
import com.valency.utils.Constants;
import com.valency.utils.TestUtil;

public class login_test extends basetest{
	
	login_page login;
	
	
	
	@BeforeMethod
	public void setup() {
	    
		
		login = new login_page();
		
		
	}
	
  @Test(dataProvider = "testdata")
  
  public void VerifyLogin(String username , String password) throws IOException {
	  
	  login.login(username, password);
	  
  }
  
	@DataProvider(name = "testdata")
	   public Object [][] getdata(){
		   
		   
		   Object data [][] = TestUtil.testdata(Constants.path_TestData, Constants.firstsheet_TestData);
		   
		   return data;
	   }
		   
		 
  
}
