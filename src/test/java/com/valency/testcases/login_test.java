package com.valency.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.valency.base.basetest;
import com.valency.pages.login_page;
import com.valency.pages.users_page;

public class login_test extends basetest{
	
	login_page login;
	
	
	
	@BeforeMethod
	public void setup() {
	    
		
		login = new login_page();
		
		
	}
	
  @Test
  public void VerifyLogin() throws IOException {
	  
	  login.login();
	  
  }
  
  
  
}
