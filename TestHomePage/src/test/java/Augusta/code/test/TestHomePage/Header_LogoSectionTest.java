package Augusta.code.test.TestHomePage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Assert;
import org.testng.annotations.Test;

import operation.ReportGenerationBaseClass;

public class Header_LogoSectionTest extends ReportGenerationBaseClass {

	String Url;

	@Test
	public void homePageHeader_LogoDisplayTest() throws IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		Boolean result = false;

		result = (driver.findElement(readObjects.getObjectLocator("Logo")).isDisplayed());

		browserScreenshot.screenshotMethod(driver, "LogoValidation");

		test = extent.createTest("Ali Express Logo should be displayed");

		Assert.assertEquals(true, result);

	}

	@Test
	public void homePageHeader_LogoURLStatusTest() throws IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		Assert.assertTrue((driver.findElement(readObjects.getObjectLocator("Logo")).isDisplayed()));

		// browserScreenshot.screenshotMethod(driver, "Logo_URL_validation");

		String bannerURL = driver.findElement(readObjects.getObjectLocator("LogoSection")).getAttribute("href");

		HttpURLConnection con = (HttpURLConnection) new URL(bannerURL).openConnection();
		con.connect();

		Boolean a = (con.getResponseCode() == HttpURLConnection.HTTP_OK);

		test = extent.createTest("URL status of Logo should be OK");

		Assert.assertEquals(true, a);

	}

	@Test
	public void homePageHeader_LogoBottomTextTest() throws IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		Assert.assertTrue((driver.findElement(readObjects.getObjectLocator("LogoBaseText")).isDisplayed()));

		String logoBaseText = driver.findElement(readObjects.getObjectLocator("LogoBaseText")).getText();

		test = extent.createTest("Bottom text of Logo should be displayed");

		Assert.assertEquals("Smarter Shopping, Better Living!", logoBaseText);

	}

}
