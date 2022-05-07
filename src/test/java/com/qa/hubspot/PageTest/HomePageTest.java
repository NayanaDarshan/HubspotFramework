package com.qa.hubspot.PageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utilis.Constants;
import com.qa.husbpot.Page.HomePage;

public class HomePageTest extends BaseTest {

	
	
	
	  @BeforeClass public void homePageSetup() { homepage =
	  loginpage.doLogin(prop.getProperty("username"),
	  prop.getProperty("password"));
	  
	  
	  }
	 

	@Test(priority = 1)
	public void verifyHomepageTitleTest() {
		String title = homepage.getHomePageTitle();
		System.out.println("The home page title is:" + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifyHomePageHeaderTest() {
		String header = homepage.getHomePageHeaderValue();
		System.out.println("The homepage header is: " + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);

	}

	@Test(priority = 3)
	public void verifySettingsIconDisplayTest() {
		Assert.assertTrue(homepage.isSettingIconExists());
	}

}
