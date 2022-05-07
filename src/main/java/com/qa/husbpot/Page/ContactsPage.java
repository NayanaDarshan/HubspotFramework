package com.qa.husbpot.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utilis.Constants;
import com.qa.hubspot.utilis.ElementUtil;

public class ContactsPage extends BasePage {
	WebDriver driver;
	ElementUtil elementutil;
	String fullname;
	String contactName;

	private By contactsHeader = By.cssSelector("h1[class*=IndexPageRedesignHeader]");
	private By conatctsPrimaryButton = By.xpath("//span[text()='Create contact']");

	private By emailId = By.xpath("//input[@data-field='email']");
	private By firstName = By.xpath("//input[@data-field='firstname']");
	private By lastName = By.xpath("//input[@data-field='lastname']");
	private By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	private By createContactBtn = By.xpath("(//span[text()='Create contact'])[position()=2]");
	private By contactsBackLink = By.xpath("(//*[text()='Contacts'])[1]");
	

	public ContactsPage(WebDriver driver) {
		elementutil = new ElementUtil(driver);
		this.driver = driver;
	}

	public String getContactPageTitle() {
		return elementutil.gettiledataWaitContains(Constants.CONTACT_PAGE_TITLE, 20);
	}

	public String getContactPageHeader() {
		elementutil.gettiledataWaitContains(Constants.CONTACT_PAGE_HEADER, 20);
		return elementutil.doGetText(contactsHeader);
	}

	public void createContact(String emailId, String firstName, String lastName, String jobTitle) {
		
		
		elementutil.clickWhenReady(conatctsPrimaryButton, 20);
		elementutil.elementWait(this.emailId, 10);
		elementutil.enterText(this.emailId, emailId);
		elementutil.enterText(this.firstName, firstName);
		elementutil.enterText(this.lastName, lastName);
		elementutil.waitElement(this.jobTitle, 10);
		elementutil.enterText(this.jobTitle, jobTitle);
		elementutil.clickWhenReady(createContactBtn, 20);
		
		
		fullname = firstName + " " + lastName;
//		elementUtil.waitForElementToBeVisible(By.xpath("//span[text()= '" + fullName + "']"), 10);
//		boolean flag = elementUtil.doIsDisplayed(By.xpath("//span[text()= '" + fullName + "']"));
		elementutil.clickWhenReady(contactsBackLink, 10);
		//return flag;
		
		elementutil.clickWhenReady(contactsBackLink, 3000);
		
		//return Flag;

	}

}
