package surveyMonkeyBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import surveyMonkeyutil.OptionsManager;

public class BasePage {

	

	static WebDriver driver;
	Properties prop;
	public OptionsManager optionManagerRef;
	
	
	public WebDriver init_driver(Properties prop) throws InterruptedException {
		optionManagerRef = new OptionsManager(prop);
		String browserName= prop.getProperty("browserName");
		if(browserName.equalsIgnoreCase("chrome")) {
			DesiredCapabilities capabilities =  new DesiredCapabilities();
			
			 WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver(capabilities);
			 Thread.sleep(2000);
			 }
		 else if(browserName.equalsIgnoreCase("ie")) {
			 DesiredCapabilities caps = new DesiredCapabilities();
			 caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "private");
			 caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
			 caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			 caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			 WebDriverManager.iedriver().setup();
			 driver= new InternetExplorerDriver();
		 }
		driver.get(prop.getProperty("url"));
		 return driver;
		 }
	public Properties init_prop() throws IOException {
		prop=new Properties();
		
		//String env= null;
		try {
			String path= System.getProperty("user.dir") + "//src//main//java//surveyMonkeyConfig/config.properties";
		
		
		
			FileInputStream fs= new FileInputStream(path);
		prop.load(fs);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				return prop;
		
		
		
}
	public void HandleCaptha() throws InterruptedException {
		WebElement addelement = driver.findElement(By.id("px-captcha"));
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		 for(int i =0;i<=6;i++) {
		Actions action = new Actions(driver);
		action.clickAndHold(addelement);
		//WebDriverWait(driver, 10).until(alert_is_present);
		action.perform();
		Thread.sleep(8000);
		action.release(addelement);
		action.perform();
		 }
		//Thread.sleep(2000);
	}
	
	
	public static void ScreenShots(String FileName)   {
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFileToDirectory(file, new File("C:\\Users\\DELL\\eclipse-workspace\\SurveyMonkey\\src\\test\\java\\Screenshot\\screenshotfolder" +FileName+ ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
