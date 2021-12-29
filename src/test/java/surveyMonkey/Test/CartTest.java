package surveyMonkey.Test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import surveyMonkeyBase.BasePage;
import surveyMonkeyPages.Cart;
import surveyMonkeyPages.LoginPage;

public class CartTest {

	WebDriver driver;
	BasePage basepageref;
	LoginPage loginpageref;
	Properties prop;
	Cart cartref;
	//ScreenShots s;
	
	@BeforeTest
	
	public void setup() throws IOException, InterruptedException {
		
		basepageref = new BasePage();
		prop= basepageref.init_prop();
		driver= basepageref.init_driver(prop);
		loginpageref=new LoginPage(driver);
		//cartref= new Cart(driver);
		cartref= loginpageref.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		//ScreenShots("loginPage");
	}
	@Test
	public void SearchItemCall() throws InterruptedException {
		cartref.SearchItem(); 
	}
}
