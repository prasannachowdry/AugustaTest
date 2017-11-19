package Augusta.code.test.TestHomePage;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import operation.ReportGenerationBaseClass;

public class Header_SearchBarSectionTest extends ReportGenerationBaseClass {

	String Url;

	@Test
	public void homePageHeader_SearchBarDisplayTest() throws IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		Boolean result = false;

		result = (driver.findElement(readObjects.getObjectLocator("SearchBox")).isDisplayed());

		browserScreenshot.screenshotMethod(driver, "SearchBoxValidation");

		test = extent.createTest("Search box should be displayed near logo");

		Assert.assertEquals(true, result);

	}

	@Test
	public void homePageHeader_searchBoxFilterTest() throws IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		Assert.assertTrue((driver.findElement(readObjects.getObjectLocator("SearchBox")).isDisplayed()));

		String searchText = "shoes";

		driver.findElement(readObjects.getObjectLocator("SearchBox")).sendKeys(searchText);

		driver.findElement(readObjects.getObjectLocator("SearchBox")).sendKeys(Keys.ENTER);

		String result = driver.findElement(readObjects.getObjectLocator("SearchResult")).getText();

		test = extent.createTest("Search result should be the same as searched");

		Assert.assertTrue(result.contains(searchText));

	}

	@Test
	public void homePageHeader_categoryOptionDisplayTest() throws IOException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		browserScreenshot.screenshotMethod(driver, "CategoryOptionValidation");

		test = extent.createTest("Category selection option should be displayed");

		Assert.assertTrue((driver.findElement(readObjects.getObjectLocator("CategoryOption")).isDisplayed()));

	}

	@Test
	public void homePageHeader_categoryOptionClickTest() throws IOException, InterruptedException {

		Url = environmentProperties.getProperty("HomePageurl");

		driver.get(Url);

		browserScreenshot.screenshotMethod(driver, "CategoryOptionValidation");

		WebElement element = driver.findElement(readObjects.getObjectLocator("CategoryOption"));

		test = extent.createTest("Category selection option should be displayed");

		Assert.assertTrue(element.isDisplayed());

		Actions action = new Actions(driver);

		action.moveToElement(element).perform();

		action.click();

		Thread.sleep(1900);

		WebElement object = driver.findElement(readObjects.getObjectLocator("CategoryOptions"));

		object.isDisplayed();

		Select selectByValue = new Select(object);

		String selectValue = "Computer & Office";

		selectByValue.selectByVisibleText("Computer & Office");

		driver.findElement(readObjects.getObjectLocator("CategoryOptions")).submit();

		String result = driver.findElement(readObjects.getObjectLocator("SearchResultPage")).getText();

		test = extent.createTest("Category selected field should be displayed");

		Assert.assertTrue(result.contains(selectValue));

	}

}
