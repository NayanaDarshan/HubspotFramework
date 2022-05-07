package com.qa.husbpot.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utilis.Constants;
import com.qa.hubspot.utilis.ElementUtil;

public class LoginPage  extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;

	//By Locators
	
	private By emailID= By.id("username");
	private By pswd= By.id("password");
	private By loginBtn= By.id("loginBtn");
	private By signUpLink= By.linkText("Sign up");


	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
		
	}
	
	//Page Actions
	
	public String getLoginPageTitle() {
		//return driver.getTitle();
		
		return elementUtil.getTitleDataWaitExact(Constants.LOGIN_PAGE_TITLE, 4000);
	}
	
	public boolean isSignUpLinkExist() {
		
		return elementUtil.doIsDisplayed(signUpLink);
		//return driver.findElement(signUpLink).isDisplayed();
	}
	
	public HomePage doLogin( String username, String password) {
		
		elementUtil.enterText(emailID, username);
		elementUtil.enterText(pswd, password);
		elementUtil.doClick(loginBtn);
		
		/*
		 * driver.findElement(emailID).sendKeys(username);
		 * driver.findElement(pswd).sendKeys(password);
		 * driver.findElement(loginBtn).click();
		 */
		return new HomePage(driver);
	
	}

}
