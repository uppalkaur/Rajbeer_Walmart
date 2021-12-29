package surveyMonkeyPages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import surveyMonkeyBase.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;
	
	By firstname = By.id("firstName");
	By lastname= By.id("lastName");
	  public HomePage( WebDriver driver) {
		  this.driver= driver; 
		  }
	 
	 public void MyAccount() throws InterruptedException {
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/div[4]/div/span/a/div/span")).click();
	 }
	

	

	public void ProfileSetting(String firstname, String lastname) throws InterruptedException {
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,350)", "");
		WebElement element=driver.findElement(By.xpath("//*[@id=\"accounts-home-page\"]/div[3]/div[1]/div[4]/a[1]"));// profile settings
		element.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[1]/div[1]/button")).click();  //edit button
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[1]/button")).click(); //first name cross button
		 Thread.sleep(1000);
		 driver.findElement(this.firstname).sendKeys(firstname);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[2]/button")).click();//last name cross button
		 driver.findElement(this.lastname).sendKeys(lastname);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//*[@id=\"skip-to-main\"]/div[1]/div[1]/div/div[3]/button[1]")).click();

	}
	
}
	
	
	
	 
	 
	 
	 

