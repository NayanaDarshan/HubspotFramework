package com.qa.husbpot.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utilis.ElementUtil;

public class DealsPage extends BasePage {

	WebDriver driver;
	ElementUtil elementutil;

	// Constructors
	public DealsPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
	}

	// By Locators

	private By dealsHeader = By.xpath("//span[text()='Deals']");
	private By createDealsBtn = By.xpath("//span[text()='Create deal']");
	private By dealName = By.xpath("//input[@data-field='dealname']");
	private By amount = By.xpath("//input[@data-field='amount']");
	private By createBtn = By.xpath("//button[@data-confirm-button='accept']");
	private By dealsBackLink = By.xpath("//*[text()='Deals'][position()=1]");

	// Page Actions

	public String getDealsPageTitle() {
		elementutil.waitElement(dealsHeader, 2000);
		return elementutil.getBrowserTitle();

	}

	public String getDealsPageHeader() {

		return elementutil.doGetText(dealsHeader);
	}

	public void createDeal(String dealName, String amount) {
		elementutil.doClick(createDealsBtn);
		elementutil.waitElement(dealsHeader, 20);
		elementutil.enterText(this.dealName, dealName);
		elementutil.enterText(this.amount, amount);
		elementutil.doClick(createBtn);
		elementutil.clickWhenReady(dealsBackLink, 20);
		elementutil.doClick(dealsBackLink);

	}

}
