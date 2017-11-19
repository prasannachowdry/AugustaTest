package Augusta.code.test.TestHomePage;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import operation.ReadEnvironment;
import operation.ReadObjects;

public class MenClothingPageTest {

	WebDriver driver = null;
	String Url;
	String OS;
	String Browser;
	Properties allObjects;
	ReadObjects readObjects;
	ReadEnvironment object;
	Properties environmentProperties;

	@BeforeClass
	public void settingBrowserDefaults() throws IOException {

		object = new ReadEnvironment();

		environmentProperties = object.getEnvironmentParameters();

		driver = object.getEnvironmentRepository();

		readObjects = new ReadObjects();

		allObjects = readObjects.getObjectRepository();

	}

	@Test
	public void test2() throws InterruptedException {

		Url = environmentProperties.getProperty("MenClothingURL");

		// Will read the corresponding url

		driver.get(Url);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
