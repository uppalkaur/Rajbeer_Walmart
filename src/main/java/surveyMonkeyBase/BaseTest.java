package surveyMonkeyBase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import surveyMonkeyPages.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public BasePage basepageref;
	public LoginPage loginpageref;
	public Properties prop;
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		basepageref= new BasePage();
		prop= basepageref.init_prop();
		driver= basepageref.init_driver(prop);
		loginpageref= new LoginPage(driver);
	}
	@AfterTest 
	public void tearDown() {
		driver.quit();
	}
}
