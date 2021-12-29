package surveyMonkey.Test;

import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import surveyMonkeyBase.BasePage;
import surveyMonkeyPages.LoginPage;
import surveyMonkeyutil.Constant;

public class LoginPageTest extends BasePage{

	WebDriver driver;
	BasePage basepageref;
	LoginPage loginpageref;
	Properties prop;
	//ScreenShots s;
	
	@BeforeTest
	
	public void setup() throws IOException, InterruptedException {
		
		basepageref = new BasePage();
		prop= basepageref.init_prop();
		driver= basepageref.init_driver(prop);
		loginpageref=new LoginPage(driver);
		//ScreenShots("loginPage");
	}
	@Test
	public void verifyLoginPage() {
		String title= loginpageref.getPageTitle();
		Assert.assertEquals(title, Constant.LOGIN_TITLE_PAGE);
	}
		  @Test
		  public void LoginTest() throws InterruptedException {
			  loginpageref.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		  }
		 
	public void CloseBrowser() {
		driver.quit();
	}

}
