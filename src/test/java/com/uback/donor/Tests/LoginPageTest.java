package com.uback.donor.Tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.uback.Base.BasePage;
import com.uback.Listeners.ExtentReportListener;
import com.uback.Listeners.TestAllureListener;
import com.uback.Utils.Constants;
import com.uback.donor.Pages.HomePage;
import com.uback.donor.Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;



//@Listeners(ExtentReportListener.class)
@Listeners(TestAllureListener.class)
@Epic("Epic - 101 : design login feature")
@Feature("US - 105 : design test cases for login page feature")
public class LoginPageTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	Logger log = Logger.getLogger(LoginPageTest.class);


	@BeforeTest
	public void setUp() {
		
		
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		
	}

	
	@Test(priority = 1,enabled=true, description = "verifying login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify login page title test on Login Page")
	@Story("Story Name: To check login page title")
	public void verifyLoginPageTitleTest() {
		log.info("****************************** starting test case *****************************************");
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		log.info("login page title is--->"+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "title is not found...");
		log.info("****************************** ending test case *****************************************");
	}
	
	@Test(priority = 2,enabled=true, description = "verifying login page Logo")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify logo on Login Page")
	@Story("Story Name: To check logo on login Page")
	public void LogoTest(){
		boolean flag = loginPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority = 3, description = "verifying forgot pass link test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify forgot pass Link Test on Login Page")
	@Story("Story Name: To check forgot pass link")
	public void verifyForgotPassTest(){
		System.out.println("verify forgot pass link Test case....");
		Assert.assertTrue(loginPage.checkforgotPass(), "Forgot Pass link is not present....");
	}
	
	
	@Test(priority = 4,enabled=true, description = "verifying login page Footer Logo")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Footer logo on Login Page")
	@Story("Story Name: To check Footer logo on login Page")
	public void FooterLogoTest(){
		boolean flag = loginPage.validatefooterLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 5, description = "verifying footer link test")
	@Severity(SeverityLevel.MINOR)
	@Description("Test Case Description: Verify footer Link Test on Login Page")
	@Story("Story Name: To check footer link")
	public void CheckAllFooterLinkTest(){
		loginPage.CheckAllFooterLink();
	}
	
	@Test(priority = 3,enabled=true, description = "login into app test")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description: verify login into application with correct credentials")
	@Story("Story Name: To check login functionality")
	public void loginTest(){
		System.out.println("verify Login Test case....");
		HomePage homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		//Assert.assertEquals(homePage.getAccountName(), prop.getProperty("accountname"), "login is failed.....");
		System.out.println("end of Login Test case....");

	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("close the browser");
		driver.quit();
	}

}
