package com.valency.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.valency.base.basetest;
import com.valency.pages.hubwise_pages;
import com.valency.pages.users_page;
import com.valency.utils.Constants;
import com.valency.utils.TestUtil;

public class hubwise_test  extends basetest{
	
	hubwise_pages hub;
	
	
	@BeforeMethod
	public void setup() {
	    
		
		 hub = new hubwise_pages();
		
		
	}
	
	
	@Test(dataProvider ="testdata")
	
	public void VerifyHubwiseFilter(String hubwise, String month) {
		
		
	hub.hubwisefilter(hubwise, month);
		
	}
	
 


@DataProvider(name = "testdata")
public Object [][] getdata(){
	
	
	Object data [][] = TestUtil.testdata(Constants.path_TestData, Constants.thirdsheet_TestData);
	
	return data;
}
}