package surveyMonkey.Test;


import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import surveyMonkeyBase.BasePage;
import surveyMonkeyPages.HomePage;
import surveyMonkeyPages.LoginPage;


public class HomePageTest extends BasePage {
	WebDriver driver;
	BasePage basepageref ;
	LoginPage loginpageref;
	Properties prop;
	HomePage homepageref;
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException {
		
	basepageref= new BasePage();
		prop=basepageref.init_prop();
		driver= basepageref.init_driver(prop);
		loginpageref=new LoginPage(driver);
		homepageref= loginpageref.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}

@Test
public void MyAccountCall() throws InterruptedException {
	
	homepageref.MyAccount();
	
	Thread.sleep(1000);
	 }
@Test
public void ProfileSettingCall() throws InterruptedException {
	homepageref.ProfileSetting(prop.getProperty("firstname"),prop.getProperty("lastname"));
	
}
}


