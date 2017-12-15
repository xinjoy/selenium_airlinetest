package project;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProfilePage;
import resources.Base;

public class Login extends Base{
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();	
	}

	@Test(dataProvider="getData")
	public void login(String id, String password, String name, String number) throws IOException {
		driver.get(prop.getProperty("url"));
		
		HomePage hp = new HomePage(driver);
		hp.getLogin().click();
		hp.getUserId().sendKeys(id);
		hp.getPassword().sendKeys(password);
		hp.getSignin().click();
		
		log.info("login successfully");
		
		ProfilePage pp = new ProfilePage(driver);
		String profile = pp.getProfile().getText();
		
		AssertJUnit.assertTrue(profile.contains(name));
		log.info("user name match");
		
		AssertJUnit.assertTrue(profile.contains(number));
		log.info("plan number match");
			
	}
		
	@AfterTest
	public void teardown() {
		//driver.close();
		//driver = null;
	}
		
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][4];
			
		data[0][0] = "ALASKA_AIR_USERID";
		data[0][1] = "ALASKA_AIR_PASSWORD";
		data[0][2] = "ALASKA_AIR_ACCOUNT_NAME";
		data[0][3] = "ALASKA_AIR_PLAN_NUMBER";
				
		return data;
	}
}
