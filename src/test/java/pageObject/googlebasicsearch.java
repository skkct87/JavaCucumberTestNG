package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class googlebasicsearch {
	
	 WebDriver driver;
	 
	 public googlebasicsearch(WebDriver driver) {
		 this.driver = driver;
	 }

	 
	By searchbar = By.name("q") ;
	By enter = By.name("btnK");
	
	public String searchbox() {
		return driver.findElement(searchbar).getAttribute("value");	
		}

	 
	public void iosearch(String searchdata) {
	driver.findElement(searchbar).sendKeys(searchdata);	
	
	}
	
	public void submit() {
		driver.findElement(searchbar).sendKeys(Keys.RETURN);
	}
	}