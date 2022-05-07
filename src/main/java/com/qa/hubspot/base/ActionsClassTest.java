package com.qa.hubspot.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassTest {
     
	static WebDriver driver;
	static Actions act;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		By Addons= By.xpath("//a[text()='Add-Ons']");
		
		act = new Actions(driver);
		doMouseover(Addons);
		
	}

	public static WebElement getWebElement(By Locator) {
		return driver.findElement(Locator);
	}
	
	public static void doMouseover(By Locator) {
		WebElement ele = getWebElement(Locator);
	    act.moveToElement(ele).perform();
		
	}
	
}
