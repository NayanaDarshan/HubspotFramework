package com.qa.hubspot.PageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utilis.Constants;
import com.qa.hubspot.utilis.ExcelUtil;

public class ContactsPageTest extends BaseTest {

	@BeforeClass
	public void homePageSetup() {
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.goToContactsPage();
	}

	@Test(priority = 1)
	public void verifyContactsPageTitleTest() {
		String title = contactspage.getContactPageTitle();
		System.out.println("The contacts page title is :" + title);
		Assert.assertEquals(Constants.CONTACT_PAGE_TITLE, title);

	}

	@Test(priority = 2)

	public void verifyConactsPageHeaderTest() {
		String header = contactspage.getContactPageHeader();
		System.out.println("The header of contacts page:" + header);
		Assert.assertTrue(header.contains(Constants.CONTACT_PAGE_HEADER));

	}

	@DataProvider()
	public Object[][] getContactsTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.CONTACT_SHEET_NAME);
		return data;
	}

	@Test(dataProvider = "getContactsTestData")
	public void verifyCreateContactTest(String email, String firstName, String lastName, String jobTitle) {
		contactspage.createContact(email, firstName, lastName, jobTitle);

	}

}
