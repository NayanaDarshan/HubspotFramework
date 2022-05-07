package com.qa.husbpot.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utilis.Constants;
import com.qa.hubspot.utilis.ElementUtil;

public class HomePage extends BasePage {
	

	private WebDriver driver;
	ElementUtil elementUtil;

	// By Locators

	private By homePageHeader = By.xpath("//h1[text()='Sales Dashboard']");
	private By settingsIcon = By.xpath("//a[@id='navSetting']");
	private By contactsParentMenu=By.id("nav-primary-contacts-branch");
	private By contactsSubMenu=By.id("nav-secondary-contacts");
	private By salesLink = By.xpath("//a[@id='nav-primary-sales-branch']");
	private By dealsLink = By.xpath("//a[@id='nav-secondary-deals']");

	// Constructor

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// Page Actions

	public String getHomePageTitle() {
		return elementUtil.gettiledataWaitContains(Constants.HOME_PAGE_TITLE, 10);
		//return driver.getTitle();
	}

	public String getHomePageHeaderValue() {

		if (driver.findElement(homePageHeader).isDisplayed()) {
			return elementUtil.gettiledataWaitContains(Constants.HOME_PAGE_HEADER, 50);
			//return driver.findElement(homePageHeader).getText();
		}
		return null;

	}
	
	public boolean isSettingIconExists() {
		
		return elementUtil.doIsDisplayed(settingsIcon);
	//return	driver.findElement(settingsIcon).isDisplayed();
	}
	
	public ContactsPage goToContactsPage() {
		clickOnCotacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnCotacts() {
		elementUtil.waitElement(contactsParentMenu, 10);
		elementUtil.doClick(contactsParentMenu);
		elementUtil.waitElement(contactsSubMenu, 5);
		elementUtil.doClick(contactsSubMenu);
	}
	
	public DealsPage goToDealsPage() {
		clickOnDeals();
		return new DealsPage(driver);	
	}
	
	
	private void clickOnDeals() {
		elementUtil.elementWait(salesLink, 10);
		elementUtil.doClick(salesLink);
		elementUtil.waitElement(dealsLink, 5);
		elementUtil.doClick(dealsLink);
	}
	
	
}
