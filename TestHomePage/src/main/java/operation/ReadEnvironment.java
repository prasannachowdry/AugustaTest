package operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadEnvironment {
	Properties p = new Properties();

	WebDriver driver = null;
	String OS;
	String Browser;

	public Properties getEnvironmentParameters() throws IOException {
		// Read object repository file
		InputStream stream = new FileInputStream(
				new File(System.getProperty("user.dir") + "//src//main/java//objects//environment.properties"));
		// load all properties
		p.load(stream);
		return p;

	}

	public WebDriver getEnvironmentRepository() throws IOException {

		//Reading required property values

		OS = p.getProperty("OS");
		Browser = p.getProperty("Browser");

		if (OS.equals("linux") && Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/prasanna/Downloads/chromedriver");
			return driver = new ChromeDriver();

		} else

		if (OS.equals("linux") && Browser.equals("Firefox")) {

			System.setProperty("webdriver.firefox.marionette", "/home/prasanna/geckodriver");
			return driver = new FirefoxDriver();

		} else {
			System.out.println("Entered last");
			return driver;
		}

		// Similarly we can extend to IE, Safari ,etc...

	}

}
