package com.sample;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;

public class Driver {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTestInterruptedException testexception;

	
	
	//Messages on Dashboard Section of HTML Report
	
	@BeforeSuite(groups = { "Sanity" })
	public void beforeSuite() {
		//Report Directory and Report Name
		extent = new ExtentReports("/home/prasanna/test/execution_report.html", true); //Provide Desired Report Directory Location and Name
		extent.loadConfig(new File("extent-config.xml")); //Supporting File for Extent Reporting
		extent.addSystemInfo("Environment","QA-Sanity"); //It will provide Execution Machine Information
	}
	
	//Messages on Categories Section of HTML Report
	
	@BeforeMethod(groups = { "Sanity" })
	public  void beforeMethod(Method method) 
	{
		test = extent.startTest( (this.getClass().getSimpleName() +" :: "+  method.getName()),method.getName()); //Test Case Start Here
		test.assignAuthor("Prasanna"); //Test Script Author Name
		String env = "QA";
		test.assignCategory("Sanity  :: " + env ); //Test Category Defined Here
	}
	
	//Write Your Test Script Here
	
	   //Test Case 1
	   @Test
	   public void testCase1() 
	   	{
	    		System.out.println("in test case 2");
	    		test.log(LogStatus.FAIL, "Step details");
	   	}
	   	
	   //Test Case 2
	   @Test
	   public void testCase2() 
	   	{
	    		System.out.println("in test case 2");
	    		test.log(LogStatus.FAIL, "Step details");
	   	}
	
	//Test Case Reporting Ends Here
	@AfterMethod(groups = { "Sanity" })
	public void afterMethod() 
	{
		extent.endTest(test);
		extent.flush();
	}
		
	@AfterSuite(groups = { "Sanity" })
	public void afterSuite() 
	{
		//System.out.println("in afterSuite");
		extent.close();  // close the Test Suite
	}
	
}

