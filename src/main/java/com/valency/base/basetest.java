package com.valency.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.valency.utils.TestUtil;
import com.valency.utils.WebEventListener;

public class basetest {
	
	 public static Properties pro;
	 public static  File src;
	 public static WebDriver driver;
	 public  static EventFiringWebDriver e_driver;
	 public static WebEventListener eventListener;
	public ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest extenttest;
	//public static ExtentTest childtest;
	// public String url;
	
	
	public   basetest()  {
		
		
		       try {
					pro = new Properties();
					src = new File ("./src/test/resources/config.properties");
					FileInputStream fis = new  FileInputStream(src);
					pro.load(fis);
					System.out.println("Property file loaded");
					
				}
		       
		        catch (FileNotFoundException e) {
		        	
				      e.printStackTrace();
				
				} 
		        catch (IOException e) {	
					
					e.printStackTrace();
				}
		
		      
		       
	
	}
	
	

	
	@Parameters({"browser", "project.url"})
	@BeforeTest
	
	 public void BrowserInitialisation(String browser ,String url) throws Exception {
		
		
	if(browser.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver", pro.getProperty("ChromeDriver"));
        driver = new ChromeDriver();
        System.out.println(" Browser is " +browser);
        
       
      
        
        
        
	}
	
	
        else if (browser.equals("firefox"))
    	{
    		System.setProperty("webdriver.gecko.driver", pro.getProperty("GeckoDriver"));
            driver = new FirefoxDriver(); 
            System.out.println(" Browser loaded  is " +browser);
            
            
    	}
	
        else {
        	
        	 System.out.println(" Browser is not provided ");
             
        	
        	
        }
	
	
	

	    e_driver = new EventFiringWebDriver(driver);
	// create object of EventListerHandler to register it with EventFiringWebDriver
	   eventListener = new WebEventListener();
	   e_driver.register(eventListener);
	   driver = e_driver;
	   
	      
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        
        
      driver.get(url);
     
      /*  if (pro.getProperty("environment").equals("liveurl"))
        	
        {
        System.out.println( "Live url loaded is " +pro.getProperty("liveurl"));
        driver.get(pro.getProperty("liveurl"));
        }
        
        
        else if  (pro.getProperty("environment").contains("stagingurl")) {
        	
        	
        	 System.out.println( "Staging url loaded is " +pro.getProperty("stagingurl"));
        	 driver.get(pro.getProperty("stagingurl"));
        	
        }
        
        else{
        	
        	System.out.println( "Provide  Application url");
        	
        }	
        		
     */
	}
	
	
	   
	  @BeforeTest
	   public void setupreport() throws FileNotFoundException {
		   
		  
		     System.out.println("=====Extent Report Started======");
		    htmlreporter = new ExtentHtmlReporter("./test-output/AutomationReport.html");
		    htmlreporter.config().setDocumentTitle("Project Result");
		    htmlreporter.config().setReportName("VALENCY MARKETING AUTOMATION REPORT");
	        htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlreporter.config().setTheme(Theme.DARK);
	    
	        extent = new ExtentReports();
	        extent.setSystemInfo("OS", "Windows 10");
	        
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("User Name", "Jino Philip");
	        extent.setSystemInfo("Host Name ", "Jino Philip");
			extent.attachReporter(htmlreporter);
			
	   }
	   
	@BeforeMethod
	   
	   public void methodname (Method method) {
		   
		   
		extenttest = extent.createTest(method.getName());
		   
		   
	   }
	
	@AfterTest
	
	public void browserclose() {
		
		
		driver.quit();

		
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=TestUtil.getScreenshot(driver);
			extenttest.fail( "Test Case FAILED is "+result.getName());
			extenttest.fail( "Test Case FAILED is " +result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
			
		}
		
		else if(result.getStatus()==ITestResult.SKIP){
			extenttest.log(Status.SKIP, "Test Case SKIPPED is " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extenttest.log(Status.PASS, "Test Case PASSED is  " + result.getName());

		}
	    extent.flush();
	    System.out.println("=====Extent Report generated======");
	}
		
   
   

}