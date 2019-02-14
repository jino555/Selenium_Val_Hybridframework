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
	public void  hubwisefilter ()  {
		
		
		hubwise_store.click();
		
		
		
		Select hub = new Select(choose_hub);
		hub.selectByVisibleText("VGRO-KL-MLP01");
		
		
		Select choosemonth = new Select(choose_month);
		choosemonth.selectByVisibleText("February");
		
		
		String hubcode = hub_code.getText();
		Assert.assertEquals("VGRO-KL-MLP01", hubcode);
		
		System.out.println(" HubCode is filtered as per selection " +hubcode);
		
		
				String  actual_month_list = month.getText();
				String expected_month = "February";
			
			
			
			boolean status = actual_month_list.contains(expected_month);
			
		 //boolean status =Assert.assertEquals(actual_month_list.contains(expected_month);
		
	System.out.println(" Month  is filtered as per selection " +status);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
