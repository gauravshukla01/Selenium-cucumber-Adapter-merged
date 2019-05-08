package org.cts.oneframework.cucumber.stepdefinition;

import org.cts.oneframework.configprovider.ConfigProvider;
import org.cts.oneframework.utilities.DateUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RedbusSteps extends AbstractSteps {

	public RedbusSteps() {
		super();
	}

	@When("^Browser is launched and navigate to specified url$")
	public void browser_is_launched_and_navigate_to_specified_url() {
		startDriver();
		getPageObjectManager().getHomePage().get(ConfigProvider.getAsString("url"));
	}

	@Then("^Book a bus ticket$")
	public void book_a_bus_ticket() {
		getPageObjectManager().getHomePage().search().setSource(DefaultStepDefinition.getCellData("from")).setDestination(DefaultStepDefinition.getCellData("to")).selectOnwardDate(DateUtils.getCurrentDate("d-MMM yyyy")).selectReturnDate(DateUtils.getTomorrowDate("d-MMM yyyy")).searchBuses();
	}

	@Then("Book a bus ticket from {string} to {string}")
	public void book_a_bus_ticket_from_to(String from, String to) {
		getPageObjectManager().getHomePage().search().setSource(DefaultStepDefinition.getCellData(from)).setDestination(DefaultStepDefinition.getCellData(to)).selectOnwardDate(DateUtils.getCurrentDate("d-MMM yyyy")).selectReturnDate(DateUtils.getTomorrowDate("d-MMM yyyy")).searchBuses();
		stopDriver();
	}

}
