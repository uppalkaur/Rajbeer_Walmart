package surveyMonkey.Test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import surveyMonkeyBase.BasePage;

import surveyMonkeyPages.CompareItems;
import surveyMonkeyPages.LoginPage;

public class CompareitemTest {

	
	WebDriver driver;
	BasePage basepageref;
	LoginPage loginpageref;
	Properties prop;
	CompareItems camref;
	//ScreenShots s;
	
	@BeforeTest
	
	public void setup() throws IOException, InterruptedException {
		
		basepageref = new BasePage();
		prop= basepageref.init_prop();
		driver= basepageref.init_driver(prop);
		loginpageref=new LoginPage(driver);
		//cartref= new Cart(driver);
		camref= loginpageref.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		//ScreenShots("loginPage");
	}
	
	@Test(priority = 1)
	public void CallPrintItemDetails() throws InterruptedException{
		camref.PrintItemDetails();
	}
	@Test(priority = 2)
	public void PageTwo() throws InterruptedException{
		camref.PageTwo();
	}
}
