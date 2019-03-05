package com.valency.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.valency.base.basetest;
import com.valency.utils.TestUtil;

public class hubwise_pages extends basetest{
	
	
	
	
	@FindBy (how=How.LINK_TEXT, using = "Hubswise Stores")
	WebElement hubwise_store;
	
	@FindBy(how=How.XPATH ,using = "//*[@id='hubs-list']/select[1]")
	WebElement choose_hub;
	
	@FindBy(how=How.XPATH ,using = "//*[@id='hubs-list']/select[2]")
	WebElement choose_month;
	
	@FindBy(xpath = "//*[@id='storeTable']/tbody/tr[1]/td[8]")
	WebElement hub_code; 
	
	
	
	@FindBy(xpath = "//*[@id='storeTable']/tbody/tr[1]/td[9]")
	WebElement month; 
	
	
	public hubwise_pages() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public void  hubwisefilter(String hub, String mnth)  {
		
		
		hubwise_store.click();
		
		TestUtil.dropdown(driver, choose_hub, hub);
		
		
		basetest.extenttest.info(" Selected hub " +hub);
		
		TestUtil.dropdown(driver, choose_month, mnth);
		
		
		basetest.extenttest.info(" Selected Month " +mnth);
		
		
	//	boolean hubcode = hub_code.getText().contains(hub);
		//Assert.assertTrue(hubcode,  "HubCode is not filtered as per selection");
		
		boolean  actual_month_list = month.getText().contains(mnth);
		Assert.assertTrue(actual_month_list,  "Month  is not filtered as per selection");
		
		
}
	
	public String verifyfilter() {
		
		return	hub_code.getText();
		
		
			
		
	}
	
	
	
}
