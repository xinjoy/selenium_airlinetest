package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	public WebDriver driver;
	
	By oneway = By.id("oneWay");
	By from = By.id("fromCity1");
	By to = By.id("toCity1");
	By departureDate = By.id("departureDate1");
	By yearMonth = By.id("month-dropdown");
	By daysTable = By.id("cal1");
	By daysRow = By.tagName("tr");
	By daysCol = By.tagName("td");
	By adults = By.id("adultCount");
	By submit = By.id("findFlights");
	
	By login = By.id("navbar-greeting-link");
	By userId = By.id("sign-in-username");
	By password = By.id("sign-in-password");
	By signin = By.id("sign-in-btn");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getOneway() {
		return driver.findElement(oneway);
	}
	
	public WebElement getFrom() {
		return driver.findElement(from);
	}
	
	public WebElement getTo() {
		return driver.findElement(to);
	}
	
	public WebElement getDepartureDate() {
		return driver.findElement(departureDate);
	}
	
	public WebElement getYearMonth() {
		return driver.findElement(yearMonth);
	}
	
	public WebElement getDay(String dayStr) {
		WebElement day = null;
		WebElement table = driver.findElement(daysTable);
		
		List<WebElement> rows = table.findElements(daysRow);
		
		for (WebElement eachRow : rows) {
			List<WebElement> cols = eachRow.findElements(daysCol);
			
			for (WebElement text : cols) {
				if (text.getText().equals(dayStr)) {
					day = text;
					break;
				}
			}
		}
		return day;
	}
	
	public WebElement getAdults() {
		return driver.findElement(adults);
	}
	
	public WebElement getSubmit() {
		return driver.findElement(submit);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getUserId() {
		return driver.findElement(userId);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getSignin() {
		return driver.findElement(signin);
	}
}
