package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utilis.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	OptionsManager optionsmanager;
	public static String flashElement;
	public static String s;
	//public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	/*
	 * author : Nayana Raghu
	 */

	/*
	 * This is the method is used to initialize the driver on the basis of given
	 * browser Name
	 * 
	 * @param browserName
	 * 
	 * @return driver
	 * 
	 */
	public WebDriver init_driver(Properties prop) {
		flashElement =prop.getProperty("highlight").trim();
		String browserName = prop.getProperty("browser").trim();

		System.out.println("The browser name is:" + browserName);

		optionsmanager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(optionsmanager.getChromeOptions());
			//tldriver.set(new ChromeDriver(optionsmanager.getChromeOptions()));
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(optionsmanager.getFirefoxoptions());
		}

		else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}

		else {
			System.out.println("Please pass the correct browser: " + browserName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

		return driver;
	}

	/*
	 * This method is used to get the properties value from config.properties file
	 * 
	 * @return it return prop
	 */

	public Properties init_prop() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}

		return prop;
	}
}
