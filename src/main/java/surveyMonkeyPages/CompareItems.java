package surveyMonkeyPages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import surveyMonkeyBase.BasePage;

public class CompareItems extends BasePage {

	WebDriver driver;
	
	

	public CompareItems(WebDriver driver) {
		this.driver= driver; 
		// TODO Auto-generated constructor stub
	}
	  
	  public void PrintItemDetails() throws InterruptedException {
		  Thread.sleep(1000);
		  driver.findElement(By.id("accept-privacy-policies")).click();
		  WebElement element= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[3]/div/div[1]/div[2]/div/form/div/input"));
		  element.sendKeys("Chocolates");
		  element.sendKeys(Keys.ENTER);
		//  driver.switchTo().alert().dismiss();
		  Thread.sleep(2000);
		  List<WebElement> vs = driver.findElements(By.xpath("//*[@id=\"browse-search-page\"]/div/div/div/div/div[7]/div[2]/div[2]/div[1]/div"));
	        System.out.println("total no of value"+vs.size());
	        for (WebElement product : vs) {
	            System.out.println(product.getText());
	            System.out.println("<======================================>");
	        }    
	        
	  }
	        
	        public void PageTwo() throws InterruptedException {
	        	Thread.sleep(1000);
	        	JavascriptExecutor js = (JavascriptExecutor) driver;
	   		 Thread.sleep(2000);
	   		 
	   		WebElement Element=driver.findElement(By.xpath("//*[@id=\"browse-search-page\"]/div/div/div/div/div[7]/div[2]/div[2]/div[2]/section/a[2]"));// click on page number 2
	   		js.executeScript("arguments[0].scrollIntoView();", Element);
	   		Thread.sleep(3000);
	   	 js.executeScript("window.scrollBy(0,50)", "");
	   		Element.click();
	   		Thread.sleep(2000);
	  		  List<WebElement> vs2 = driver.findElements(By.id("product-results"));
	  	        System.out.println("total no of value"+vs2.size());
	  	        for (WebElement product2 : vs2) {
	  	            System.out.println(product2.getText());
	  	            System.out.println("<======================================>");
	        }
	  }
	        
	        
		
	  
	  
}
