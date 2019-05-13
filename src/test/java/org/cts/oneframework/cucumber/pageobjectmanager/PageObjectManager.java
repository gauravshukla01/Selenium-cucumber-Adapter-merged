package org.cts.oneframework.cucumber.pageobjectmanager;

import org.cts.oneframework.cucumber.pages.HomePage;
import org.cts.oneframework.cucumber.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager{

	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
}