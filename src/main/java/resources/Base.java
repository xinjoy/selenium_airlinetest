package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	//make it public so that other classes can call it
	public static WebDriver driver = null;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("data.properties");
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/PATH/geckodriver");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/PATH/chromedriver");
			driver = new ChromeDriver();
		}
		else {
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/PATH/testScreenshots/" + result + " screenshot.png"));
	}

}
