package surveyMonkeyPages;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import surveyMonkeyBase.BasePage;

public class LoginPage extends BasePage{
	WebDriver driver;
	//WebElement addelement = driver.findElement(By.id("px-captcha"));
	By username = By.id("username");
	By password= By.id("password");
	By loginButton=By.xpath("//*[@id=\"login-form\"]/div/div[7]/button");
	//By signupButton=By.linkText("Sign Up");
	public LoginPage(WebDriver driver) {
		this.driver= driver;;
	}
	public String getPageTitle() {
		 return driver.getTitle();
	}


	public CompareItems doLogin(String username, String password) throws InterruptedException {
		
		//HomePage homePageref= new HomePage(driver);
		driver.manage().window().maximize();
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		
	driver.findElement(loginButton).click();
		//HandleCaptha();
	
	   return new  CompareItems(driver);
	   
		}
		
	}

