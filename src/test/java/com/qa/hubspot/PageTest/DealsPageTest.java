package com.qa.hubspot.PageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utilis.Constants;

public class DealsPageTest extends BaseTest{
	
	@BeforeClass
	public void dealsPageSetup() {
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	    dealspage=homepage.goToDealsPage();	
	}
	
	@Test
	public void verifyDealsPageTitleTest() {
		String title =dealspage.getDealsPageTitle();
		System.out.println("The tile of deals page "+title);
		Assert.assertEquals(Constants.DEALS_PAGE_TITLE, title);	
	
	}
	
	@Test
	public void verifyDealsPageHeaderTest() {
		String header=dealspage.getDealsPageHeader();
		System.out.println("The deals page is header "+header);
		Assert.assertEquals(Constants.DEALS_PAGE_HEADER, header);
	}
	
	@Test
	public void verifyCreateDealsTest() {
		dealspage.createDeal("Nayanadeals", "3000");
		
	}

}
