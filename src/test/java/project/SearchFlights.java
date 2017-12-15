package project;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ConfirmPage;
import pageObjects.FlightsPage;
import pageObjects.HomePage;
import resources.Base;

public class SearchFlights extends Base{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();	
	}

	@Test(dataProvider="getData")
	public void searchFlights(String fromCity, String toCity, String yearMonth, String day, String adult) throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		
		HomePage hp = new HomePage(driver);
		
		hp.getOneway().click();
		hp.getFrom().sendKeys(fromCity);
		Thread.sleep(1000);
		hp.getFrom().sendKeys(Keys.ENTER);
		hp.getTo().sendKeys(toCity);
		Thread.sleep(1000);
		hp.getTo().sendKeys(Keys.ENTER);
		
		hp.getDepartureDate().click();
		Select s1 = new Select(hp.getYearMonth());
		s1.selectByVisibleText(yearMonth);
		hp.getDay(day).click();
		
		Select s2 = new Select(hp.getAdults());
		s2.selectByVisibleText(adult);
		
		hp.getSubmit().click();
		
		log.info("search flights successfully");
		
		Thread.sleep(3000);
		
		FlightsPage fp = new FlightsPage(driver);
		
		fp.getFlight().click();
		fp.getSubmit().click();
		
		log.info("book flight successfully");
		
		Thread.sleep(3000);
		
		ConfirmPage cp = new ConfirmPage(driver);
		AssertJUnit.assertTrue(cp.getCart().isDisplayed());
		
		log.info("flight is displayed");
	}
	
	@AfterTest
	public void teardown() {
		//driver.close();
		//driver = null;
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][5];
		
		data[0][0] = "san jose";
		data[0][1] = "seattle";
		data[0][2] = "Jan 2018";
		data[0][3] = "1";
		data[0][4] = "3 adults";
			
		return data;
	}
}
