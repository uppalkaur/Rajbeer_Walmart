package surveyMonkeyPages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import surveyMonkeyBase.BasePage;

public class Cart extends BasePage {
WebDriver driver;
	

	  public Cart( WebDriver driver) {
		  this.driver= driver; 
		  }
	  
	  public void SearchItem() throws InterruptedException {
		  Thread.sleep(1000);
		  WebElement element= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]/div/form/div/input"));
		  element.sendKeys("Chocolates");
		  element.sendKeys(Keys.ENTER);
		  Thread.sleep(2000);
		 driver.findElement(By.xpath("//*[@id=\"product-results\"]/div[1]/div/a/div")).click();// click on selected item
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,350)", "");
		 Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div[1]/div[6]/div[2]/div/div[2]/div[2]/div/button[1]")).click();// click on add to cart
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"atc-root\"]/div[3]/div[2]/button[1]")).click();//click on checkout
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"98733B0DB97C40DC815AC50A8CCEA134\"]/div[2]/div[3]/button[1]")).click(); //click on remove item
	  }
	  
	 
	  
}
