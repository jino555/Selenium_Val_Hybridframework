package com.valency.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.valency.base.basetest;
import com.valency.pages.hubwise_pages;
import com.valency.pages.users_page;

public class hubwise_test  extends basetest{
	
	hubwise_pages hub;
	
	
	@BeforeMethod
	public void setup() {
	    
		
		 hub = new hubwise_pages();
		
		
	}
	
	
	
  @Test
  public void Verifyhubwisefilter()  {
	  
	  hub.hubwisefilter();
	  
	  
  }
}
