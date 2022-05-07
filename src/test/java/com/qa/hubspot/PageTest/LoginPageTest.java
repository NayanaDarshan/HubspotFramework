package com.qa.hubspot.PageTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utilis.Constants;

public class LoginPageTest extends BaseTest{
	
	
	@Test(priority=2)
	public void verifyLoginPageTitleTest() {
		String title= loginpage.getLoginPageTitle();
		System.out.println("The Login page title is:" +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority=1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginpage.isSignUpLinkExist());
	}
	
	@Test(priority=3)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	

}
