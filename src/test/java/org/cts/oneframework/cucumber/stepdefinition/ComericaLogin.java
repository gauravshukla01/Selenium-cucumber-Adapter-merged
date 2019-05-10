package org.cts.oneframework.cucumber.stepdefinition;

import org.cts.oneframework.configprovider.ConfigProvider;
import org.cts.oneframework.utilities.DateUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;

public class ComericaLogin extends AbstractSteps{
	public ComericaLogin() {
		super();
	}

	@When("Browser is launched and navigate to the specified url")
	public void browser_is_launched_and_navigate_to_specified_url() {
		startDriver();
		getPageObjectManager().getHomePage().get(ConfigProvider.getAsString("comericaUrl"));

	}

	@Then("Click on login link")
	public void click_on_login_link() {
		getPageObjectManager().getLoginPage().clickLoginLink();
	}
	
	@Then("Enter login credentials {string} and {string}")
	public void enter_login_credentials_and(String username, String password) {
		getPageObjectManager().getLoginPage().setUserPassword(DefaultStepDefinition.getCellData(username),DefaultStepDefinition.getCellData(password));
	}
	
	@Then("Click on login button")
	public void click_on_login_button() {
		getPageObjectManager().getLoginPage().enterCredential();
		
	}
	
	@And("validate login failure message")
	public void validate_login_failure_message() {
		getPageObjectManager().getLoginPage().checkOutput();
		//getPageObjectManager().getHomePage().search().setSource(DefaultStepDefinition.getCellData("from")).setDestination(DefaultStepDefinition.getCellData("to")).selectOnwardDate(DateUtils.getCurrentDate("d-MMM yyyy")).selectReturnDate(DateUtils.getTomorrowDate("d-MMM yyyy")).searchBuses();
		stopDriver();
	}
	
	
	
}
