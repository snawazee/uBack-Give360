package com.uback.donor.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uback.Base.BasePage;
import com.uback.Utils.Constants;
import com.uback.donor.Pages.HomePage;
import com.uback.donor.Pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 102 : design home page features")
@Feature("US - 105 : design test cases for home page features")
public class HomePageTest {

	Properties prop;
	WebDriver driver;

	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	@Description("verify home Page Title Test....")
	@Severity(SeverityLevel.NORMAL)
	public void VerifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

	
	@Test(priority = 2)
	@Description("verify home Page header Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyHomePageHeaderTest() {
		String header = homePage.getHomePageHeader();
		System.out.println("home page header is : " + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}

	@Test(priority = 3)
	@Description("verify user has logged into the application Test....")
	@Severity(SeverityLevel.NORMAL)
	public void veriyLoggedInUserTest() {
		String accountName = homePage.getAccountName();
		System.out.println("logged account name is : " + accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
