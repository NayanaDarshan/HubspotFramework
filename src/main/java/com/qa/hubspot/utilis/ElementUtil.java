package com.qa.hubspot.utilis;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ElementUtil {
	WebDriver driver;
	List<WebElement> optionName;
	static Actions act;
	static WebDriverWait wait;
	JSUtil jsutil;
	

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	    jsutil = new JSUtil(driver);

	}

	/*
	 * Method to get title
	 */

	public String getBrowserTitle() {
		return driver.getTitle();

	}
	
	/*
	 * Method to get text
	 */
	
	public String doGetText(By Locator) {
		return driver.findElement(Locator).getText();
	}
	/*
	 *Method to verify the webelement is displayed 
	 */
	
	public boolean doIsDisplayed(By Locator) {
		
		return driver.findElement(Locator).isDisplayed();
	}

	/*
	 * Method to Inspect the Element returns WebElement
	 */
	public WebElement getElement(By locator) {
		WebElement element= driver.findElement(locator);
		if(Boolean.parseBoolean(BasePage.flashElement))
		jsutil.flash(element);
		return element;

	}

	/*
	 * Method to click on the Link
	 */
	public void doClick(By locator) {

		getElement(locator).click();

	}

	/*
	 * Method to enter the data to Textfield
	 * 
	 */
	public void enterText(By locator, String text) {
		getElement(locator).sendKeys(text);
	}

	/*
	 * Method to perform Single Link Click
	 */
	public void singleLinkClick(By locator) {
		getElement(locator).click();

	}

	/*
	 * Method to get all Link Details
	 */
	public List<WebElement> linkCount(By locator) {
		List<WebElement> linkdetails = driver.findElements(locator);

		return linkdetails;
	}
	/*
	 * Method to get Link count
	 */

	public void getlinkCount(By locator) {

		System.out.println(linkCount(locator).size());
	}

	/*
	 * Method to get Link Names
	 */
	public void getLinkNames(By locator) {

		List<WebElement> linkText = linkCount(locator);

		for (WebElement ele : linkText) {
			String lnkName = ele.getText();

			if (!lnkName.isEmpty()) {
				System.out.println("The link names are ==> " + lnkName);
			}
		}

		// linkCount(locator).stream().forEach(getLinkNames ->
		// System.out.println(getLinkNames.getText()));

	}

	/*
	 * Method to get Link Attribute value
	 */
	public void getLinkAttribute(By Locator) {
		List<WebElement> ll = linkCount(Locator);

		ll.stream().forEach(ele1 -> System.out.println(ele1.getAttribute("href")));

	}

	/*
	 * Select the drop down value by Index
	 */

	public void selectByIndex(By locator, int index) {
		WebElement dropdwnName = getElement(locator);
		Select sel = new Select(dropdwnName);
		sel.selectByIndex(index);
	}
	/*
	 * Select the drop down value by Option value
	 */

	public void selectByValue(By locator, String value) {
		WebElement dropdwnName = getElement(locator);
		Select sel = new Select(dropdwnName);
		sel.selectByValue(value);
	}

	/*
	 * Select the drop down value by Option Text
	 */
	public void selectByText(By locator, String text) {

		WebElement dropdwnName = getElement(locator);
		Select sel = new Select(dropdwnName);
		sel.selectByVisibleText(text);
	}

	/*
	 * Method to get all drop down values
	 */
	public void getAllDropOptions(By locator) {

		WebElement ele = getElement(locator);
		Select sel = new Select(ele);

		optionName = sel.getOptions();

		optionName.stream().forEach(optName -> System.out.println(optName.getText()));

	}

	/*
	 * Get the search results based on matching text from Google search
	 */
	public void getSearchResults(By Locator) {
		List<WebElement> nameList = driver.findElements(Locator);
		System.out.println(nameList.size());
		nameList.stream().forEach(ele -> System.out.println(ele.getText()));

	}

	/*
	 * Mouse over action on Single Element
	 */
	public void singleMouseHover(WebElement element) {

		act = new Actions(driver);

		act.moveToElement(element).perform();

	}
	/*
	 * Locator click
	 */

	public void optionClick(By locator) {

		getElement(locator).click();

	}
	/*
	 * This method is used to perform right click operation
	 */

	public void rightClick(WebElement ele) {

		Actions act = new Actions(driver);

		act.contextClick(ele).perform();


	}
	/*
	 * Using actions class clicking on elements
	 */

	public void actClick(WebElement ele) {

		act = new Actions(driver);

		act.click(ele).perform();
	}

	/*
	 * using actions class send keys on textfield
	 */

	public void actSendData(WebElement ele, String value) {

		act = new Actions(driver);

		act.sendKeys(ele, value).perform();
	}

	// ***************************************Wait
	// Utility********************************************************

	/*
	 * 
	 */
	public WebElement elementWait(By Locator, int time) {
		wait = new WebDriverWait(driver, time);

		return wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
	}

	/*
	 * 
	 */
	public String gettiledataWaitContains(String titlename, int time) {

		wait = new WebDriverWait(driver, time);

		wait.until(ExpectedConditions.titleContains(titlename));

		String titlenme = driver.getTitle();

		return titlenme;

	}
	/*
	 * 
	 */

	public String getTitleDataWaitExact(String titlename, int time) {

		wait = new WebDriverWait(driver, time);

		wait.until(ExpectedConditions.titleContains(titlename));

		return driver.getTitle();
	}

	/*
	 * 
	 */

	public void waitElement(By Locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(Locator)));
	}
	
	
	
	 /*
	  * click when webelement is ready and perform click action as well
	  */
	
	public void clickWhenReady(By Locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element =wait.until(ExpectedConditions.elementToBeClickable(Locator));
		element.click();
		
	}
}
