package com.sample;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import operation.BrowserScreenshot;
import operation.ReadEnvironment;
import operation.ReadObjects;
import operation.ReportGenerationBaseClass;

public class HomePageTest3 extends ReportGenerationBaseClass {

	// public static ExtentReports extent;
	// public static ExtentTest test;
	// public static ExtentTestInterruptedException testexception;

	String Url;
	String OS;
	String Browser;

	// @BeforeClass
	// public void settingBrowserDefaults() throws IOException {
	//
	// object = new ReadEnvironment();
	//
	// environmentProperties = object.getEnvironmentParameters();
	//
	// driver = object.getEnvironmentRepository();
	//
	// readObjects = new ReadObjects();
	//
	// allObjects = readObjects.getObjectRepository();
	//
	// browserScreenshot = new BrowserScreenshot();
	//
	//// extent = new ExtentReports("/home/prasanna/test/execution_report.html",
	// true);
	// }

	// @Test
	// public void functionality1Test1()
	// {
	// test = extent.createTest("functionality1Test1");
	// Assert.assertTrue(1 > 0);
	//
	// }
	// @Test
	// public void functionality1Test2()
	// {
	// test = extent.createTest("functionality1Test2");
	// Assert.assertFalse(0 > 1);
	//
	//
	// }
	//
	// @Test
	// public void test1() throws InterruptedException, IOException {
	//
	// Url = environmentProperties.getProperty("HomePageurl");
	//
	// driver.get(Url);
	//
	// test = extent.createTest("functionality1Test3");
	//
	// Assert.assertTrue((driver.findElement(readObjects.getObjectLocator("BrandsSectionsBanner")).isDisplayed()));
	//
	// }
	//
	// @Test
	// public void test2() throws InterruptedException, IOException {
	//
	// Url = environmentProperties.getProperty("HomePageurl");
	//
	// driver.get(Url);
	//
	// Boolean result = false;
	//
	// result =
	// (driver.findElement(readObjects.getObjectLocator("BrandsSectionsBanner")).isDisplayed());
	//
	// browserScreenshot.screenshotMethod(driver, "FirstNameValidation");
	//
	// test = extent.createTest("functionality1Test4");
	//
	// Assert.assertEquals( true, result);
	//
	// }

	@Test
	public void homePageHeader_BrandsSectionTest() throws IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		test = extent.createTest("Brands section should be displayed in Home page header");

		Assert.assertTrue((driver.findElement(readObjects.getObjectLocator("BrandsSectionsBanner")).isDisplayed()));

		browserScreenshot.screenshotMethod(driver, "Brands_banner_sections");

		String bannerURL = driver.findElement(readObjects.getObjectLocator("BrandsSectionsBanner"))
				.getAttribute("href");

		HttpURLConnection con = (HttpURLConnection) new URL(bannerURL).openConnection();
		con.connect();
		// Checking redirection as href value set with temporary redirect
		Boolean a = (con.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP);

		test = extent.createTest("URL status of Brand section banner should be redirection");

		Assert.assertEquals(true, a);

	}

	// @AfterClass
	// public void tearDown() {
	// driver.quit();
	//
	// }

}
