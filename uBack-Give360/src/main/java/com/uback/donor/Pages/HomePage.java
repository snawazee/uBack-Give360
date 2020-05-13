package com.uback.donor.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.uback.Base.BasePage;
import com.uback.Utils.Constants;
import com.uback.Utils.ElementUtil;

import io.qameta.allure.Step;

public class HomePage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;

	By header = By.cssSelector("h1.private-page__title");
	By accountName = By.cssSelector("span.account-name ");
	
	By contactsLinkPrimary = By.id("nav-primary-contacts-branch");
	By contactsLinkSecondary = By.id("nav-secondary-contacts");


	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

	@Step("get Home Page Title....")
	public String getHomePageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);

	}
	
	@Step("get Home Page header....")
	public String getHomePageHeader() {
		if (elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}

	@Step("get account name on Home Page....")
	public String getAccountName() {
		elementUtil.waitForElementToBePresent(accountName, 10);
		if (elementUtil.doIsDisplayed(accountName)) {
			return elementUtil.doGetText(accountName);
		}
		return null;
	}

	@Step("navigate to contacts page....")
	public ContactsPage goToContactsPage(){
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts(){
		elementUtil.waitForElementToBePresent(contactsLinkPrimary, 10);
		elementUtil.doClick(contactsLinkPrimary);
		elementUtil.waitForElementToBePresent(contactsLinkSecondary, 5);
		elementUtil.doClick(contactsLinkSecondary);
	}
	
	
	
}
