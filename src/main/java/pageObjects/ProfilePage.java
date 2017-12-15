package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	public WebDriver driver;
	
	By profile = By.id("FormUserControl__myOverview__mileagePlanInfo");
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getProfile() {
		return driver.findElement(profile);
	}
}
