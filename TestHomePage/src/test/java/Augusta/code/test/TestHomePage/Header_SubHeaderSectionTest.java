package Augusta.code.test.TestHomePage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Assert;
import org.testng.annotations.Test;

import operation.ReportGenerationBaseClass;

public class Header_SubHeaderSectionTest extends ReportGenerationBaseClass {

	String Url;

	@Test
	public void homePageSubHeader_BuyerProtectionTest() throws IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		browserScreenshot.screenshotMethod(driver, "Buyer_Protection_link");

		test = extent.createTest("Buyer protection link should be displayed in the header");

		Assert.assertTrue((driver.findElement(readObjects.getObjectLocator("BuyerProtection")).isDisplayed()));

	}

	@Test
	public void homePageSubHeader_BuyerProtectionLinkTest() throws IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		Assert.assertTrue((driver.findElement(readObjects.getObjectLocator("BuyerProtection")).isDisplayed()));

		String bannerURL = driver.findElement(readObjects.getObjectLocator("BuyerProtection"))
				.getAttribute("href");

		HttpURLConnection con = (HttpURLConnection) new URL(bannerURL).openConnection();
		con.connect();
		System.out.println(con.getResponseCode());
		// Checking redirection as href value set with temporary redirect
		Boolean a = (con.getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM);

		test = extent.createTest("Buyer protection link should have OK status");

		Assert.assertEquals(true, a);

	}

}
