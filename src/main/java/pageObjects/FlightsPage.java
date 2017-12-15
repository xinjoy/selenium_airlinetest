package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightsPage {
	public WebDriver driver;
	
	By flightTabelBody = By.xpath("//*[@id='MatrixTable0']/tbody[1]");
	By flightsRow = By.tagName("tr");
	By fligthsCol = By.tagName("td");
	By addToCart = By.id("ContinueButton");
	
	public FlightsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getFlight() {
		WebElement table = driver.findElement(flightTabelBody);
		WebElement row = table.findElements(flightsRow).get(0);
		WebElement flight = row.findElements(fligthsCol).get(2);
		
		return flight;
	}
	
	public WebElement getSubmit() {
		return driver.findElement(addToCart);
	}
	
}
