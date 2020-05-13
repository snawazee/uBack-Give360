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

@Epic("Epic - 101 : design login feature")
@Feature("US - 105 : design test cases for login page feature")
public class LoginPageTest {

	Properties prop;
	WebDriver driver;

	BasePage basePage;
	LoginPage loginPage;
	

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	
	@Test(priority=1, enabled=true)
	@Description("verify Login Page Title Test....")
	@Severity(SeverityLevel.TRIVIAL)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "title is not found...");
	}
	
	@Test(priority=2, enabled=true)
	@Description("Verify that the company logo is clearly visible")
	@Severity(SeverityLevel.NORMAL)
	public void LogoTest(){
		boolean flag = loginPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3,enabled = true)
	@Description("verify forgot pass link Test case....")
	@Severity(SeverityLevel.CRITICAL)
	public void verifyForgotPassTest(){
		System.out.println("verify forgot pass link Test case....");
		Assert.assertTrue(loginPage.checkforgotPass(), "Forgot Pass link is not present....");
	}
	
	
	@Test(priority=4, enabled=true)
	@Description("Verify that the company logo is clearly visible")
	@Severity(SeverityLevel.NORMAL)
	public void FooterLogoTest(){
		boolean flag = loginPage.validatefooterLogo();
		Assert.assertTrue(flag);
	}
	
	
	
	@Test(priority=5, enabled=true)
	@Description("Verify that the company logo is clearly visible")
	@Severity(SeverityLevel.NORMAL)
	public void CheckAllFooterLinkTest(){
		loginPage.CheckAllFooterLink();
	}
	
	@Test(priority=6,enabled = true)
	@Description("verify user is able to Login - feature Test....")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest(){
		System.out.println("verify Login Test case....");
		HomePage homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.getAccountName(), prop.getProperty("accountname"), "login is failed.....");
		System.out.println("end of Login Test case....");

	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("close the browser");
		driver.quit();
	}

}
