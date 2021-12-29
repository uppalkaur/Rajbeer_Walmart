package surveyMonkeyutil;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	WebDriver driver;
	public ChromeOptions ca;
	public FirefoxOptions fa;
	Properties prop;
	public OptionsManager(Properties prop) {
		this.prop=prop;
		
	}
	public ChromeOptions getChromeOptions() {
		ca= new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) ca.addArguments("headless");
		if(Boolean.parseBoolean(prop.getProperty("cognito"))) ca.addArguments("cognito");
		return ca;
	}
	public FirefoxOptions getfirefoxOptions() {
		fa= new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) ca.addArguments("headless");
		if(Boolean.parseBoolean(prop.getProperty("cognito"))) ca.addArguments("cognito");
		return fa;
	}
}
