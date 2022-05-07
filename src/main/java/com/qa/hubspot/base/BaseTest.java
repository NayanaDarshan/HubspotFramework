package com.qa.hubspot.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.husbpot.Page.ContactsPage;
import com.qa.husbpot.Page.DealsPage;
import com.qa.husbpot.Page.HomePage;
import com.qa.husbpot.Page.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public BasePage basepage;
	public LoginPage loginpage;
	public Properties prop;
	public HomePage homepage;
	public ContactsPage contactspage;
	public DealsPage dealspage;


	@BeforeTest
	public void setup() {

		basepage = new BasePage();
		prop=basepage.init_prop();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
		
		
	}
	
	
	  @AfterTest 
	  public void teardown() 
	  { 
		  driver.quit(); 
		  
	  }
	 
	 
}
