package operation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

public class BrowserScreenshot {

	public void screenshotMethod(WebDriver driver2, String fileName) throws IOException {
		// TODO Auto-generated method stub

		File scrFile = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "/test-output/screenprints/"+fileName+ ".png"));

	}
}
