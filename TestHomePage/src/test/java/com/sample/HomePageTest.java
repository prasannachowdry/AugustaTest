package com.sample;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentTestInterruptedException;
import com.relevantcodes.extentreports.LogStatus;

import operation.BrowserScreenshot;
import operation.ReadEnvironment;
import operation.ReadObjects;
import operation.ReportGenerationBaseClass;

public class HomePageTest {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTestInterruptedException testexception;

	WebDriver driver = null;
	String Url;
	String OS;
	String Browser;
	Properties allObjects;
	ReadObjects readObjects;
	ReadEnvironment object;
	Properties environmentProperties;
	BrowserScreenshot browserScreenshot;

	@BeforeClass
	public void settingBrowserDefaults() throws IOException {

		object = new ReadEnvironment();

		environmentProperties = object.getEnvironmentParameters();

		driver = object.getEnvironmentRepository();

		readObjects = new ReadObjects();

		allObjects = readObjects.getObjectRepository();

		browserScreenshot = new BrowserScreenshot();

		extent = new ExtentReports("/home/prasanna/test/execution_report.html", true);
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()), method.getName()); // Test
		test.assignAuthor("Prasanna");
	}

	@Test
	public void test1() throws InterruptedException, IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		try {

			Assert.assertTrue((driver.findElement(readObjects.getObjectLocator("FirstName")).isDisplayed()));

			test.log(LogStatus.PASS, "Step details");

		} catch (Exception e) {

			test.log(LogStatus.FAIL, "Step details");
		}

	}

	@Test
	public void test2() throws InterruptedException, IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		Boolean result = false;

		result = (driver.findElement(readObjects.getObjectLocator("FirstName")).isDisplayed());

		browserScreenshot.screenshotMethod(driver, "FirstNameValidation");

		if (result.equals(true)) {
			test.log(LogStatus.PASS, "Step details");
		} else {
			test.log(LogStatus.FAIL, "Step details");
		}

	}

	@Test
	public void homePageHeader_BrandsSectionTest() throws MalformedURLException, IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		try {

			Assert.assertTrue((driver.findElement(readObjects.getObjectLocator("BrandsSectionsBanner")).isDisplayed()));

			test.log(LogStatus.PASS, "Brands sections is displayed in Home page header");

			browserScreenshot.screenshotMethod(driver, "Brands_banner_sections");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Brands sections is not displayed in Home page header");
		}

		String bannerURL = driver.findElement(readObjects.getObjectLocator("BrandsSectionsBanner"))
				.getAttribute("href");

		HttpURLConnection con = (HttpURLConnection) new URL(bannerURL).openConnection();
		con.connect();
		// Checking redirection as href value set with temporary redirect
		Boolean a = (con.getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP);

		if (a.equals(true)) {
			test.log(LogStatus.PASS, "URL status of Brand section banner is success");
		} else {
			test.log(LogStatus.FAIL, "URL status of Brand section banner is failing");
		}

	}

	@AfterMethod
	public void afterMethod() {
		extent.endTest(test);
		extent.flush();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		extent.close();
	}

}
