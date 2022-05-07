package com.qa.hubspot.utilis;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class linkTest {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.freshworks.com/");

		List<WebElement> linknames = driver.findElements(By.tagName("a"));

		for (WebElement ele : linknames) {

			System.out.println(ele.getAttribute("href"));

		}

	}

}
