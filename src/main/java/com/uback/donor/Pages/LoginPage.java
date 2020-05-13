package com.uback.donor.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uback.Base.BasePage;
import com.uback.Utils.Constants;
import com.uback.Utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. By locators:
	
	By logo=By.xpath("//img[@alt='uback']");
	By username = By.id("email_login");
	By password = By.id("password_login");
	By loginButton = By.xpath("//button[@type='submit']");
	By forgotPass = By.xpath("/html/body/div[1]/section/div/form/p");
	By TermsConditions=By.xpath("//li[.='Terms and Conditions']");
	By PrivacyPolicy=By.xpath("//li[.='Privacy Policy']");
	By ContactuBack=By.xpath("Contact uBack");
	By footerLogo=By.xpath("(//img[@src='images/Give360v1.2.png'])[2]");
	By forgotPassEmail=By.xpath("//input[@id='txtEmailID']");
	By sendRequest=By.xpath("//button[@type='button']");
	By loginErrorText=By.xpath("//span[@ng-show='signin.authMsg']");
	
	

	// 2. constructor of the page class:

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. page actions/methods:
	
	@Step("get login page title...")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 20);
	}

	@Step("Check that the company logo is clearly visible")
	public boolean validateLogo(){
		return elementUtil.doIsDisplayed(logo);
	}
	
	@Step("check sign up link on login page...")
	public boolean checkforgotPass() {
		return elementUtil.doIsDisplayed(forgotPass);
	}
	
	@Step("Check that the company footer logo is clearly visible")
	public boolean validatefooterLogo(){
		return elementUtil.doIsDisplayed(footerLogo);
	}
	
	@Step("Check All Footer Link")
	public void CheckAllFooterLink() {
	List<WebElement> allElements = driver.findElements(By.xpath("/html/body/div[1]/footer/div/span[2]/ul/li"));
    System.out.println(allElements);

    for (WebElement element: allElements) {
        System.out.println(element.getText());
        element.click();      
    }
}
	
	@Step("login with - username : {0} and pasword : {1}")
	public HomePage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new HomePage(driver);
	}

}
