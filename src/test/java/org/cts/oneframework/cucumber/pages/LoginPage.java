package org.cts.oneframework.cucumber.pages;

import org.cts.oneframework.cucumber.pages.HomePage.Search;
import org.cts.oneframework.utilities.AssertionLibrary;
import org.cts.oneframework.utilities.BasePageObject;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	

	private String loginLink = "//img[@class='img-fluid']";
	private String userNamePath = "//input[@name='txtUsername']";
	private String passwordPath = "//input[@name='txtPassword']";
	private String submitDetails = "//button[@id='login_button']";
	private String checkError = "//div[@id='SERVERSIDEERROR']";
	

	
	public void clickLoginLink() {
		clickElement(loginLink, "on Login Button");
	}
	
	public void setUserPassword(String userName,String password) {
		setInputValue(userNamePath, userName);
		shiftFocusAway(userNamePath);
		setInputValue(passwordPath, password);
		shiftFocusAway(passwordPath);	
	}
	
	public void enterCredential() {
		clickElement(submitDetails, "on Submit Login Button");
	}
	
	public void checkOutput() {
		AssertionLibrary.assertEquals(getText(checkError), 
				"We do not recognize your User ID or password. Please try again or click \"Forgot Your Password?\" for assistance.",
				"Verify Login Failure");
		
	}
}
