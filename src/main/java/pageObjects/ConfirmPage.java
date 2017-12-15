package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmPage {
	public WebDriver driver;
	
	By cart = By.id("bookingBannerH1");
	
	public ConfirmPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCart() {
		return driver.findElement(cart);
	}
	
}
