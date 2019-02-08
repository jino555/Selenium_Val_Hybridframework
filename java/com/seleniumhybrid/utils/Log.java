package com.seleniumhybrid.utils;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

public class Log {

	 // Initialize Log4j logs

	  private  static  Logger Log = Logger.getLogger(Log.class.getName());
	 

	  // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

	   public static  void startTestCase(String sTestCaseName){
		  
		 PropertyConfigurator.configure("log4j.properties");
		 
	 

	 	Log.info("$$$$$$$$$$$$$$$$$$$$$                 "+sTestCaseName+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");

	 	
	 	}

	 	//This is to print log for the ending of the test case

	  public static void endTestCase(String sTestCaseName){
		  
		PropertyConfigurator.configure("log4j.properties");
		  
	 	Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+sTestCaseName+"             XXXXXXXXXXXXXXXXXXXXXX");

	 	}

	 	// Need to create these methods, so that they can be called  

	  public static  void info(String message) {
		  
		 
	 	  Log.info(message);

	 		}

	  /*
	  public static static void warn(String message) {

	      Log.warn(message);

	 	}
	  
     public static static void error(String message) {
	 
	     Log.error(message);

	 	}

	  public static void fatal(String message) {

	     Log.fatal(message);

	 	}

	  public static void debug(String message) {

	     Log.debug(message);

	 	}*/

	 }
	

	
	
	

