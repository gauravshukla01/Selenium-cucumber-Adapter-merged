package org.cts.oneframework.cucumber.pages;

import org.cts.oneframework.utilities.AssertionLibrary;
import org.cts.oneframework.utilities.BasePageObject;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private String title = "//a[text()='redbus']";
	private String src = "//*[@id='src']";
	private String dest = "//*[@id='dest']";
	private String onwardDate = "//label[@for='onward_cal']";
	private String returnDate = "//label[@for='return_cal']";
	private String setDay = "//div[@class='rb-calendar']//td[text()='%s']";
	private String getMonthYear = "//div[@class='rb-calendar']//td[@class='monthTitle']";
	private String searchBuses = "//button[@id='search_btn']";

	public Search search() {
		return new Search();
	}

	public void assertPageIsDisplayed() {
		AssertionLibrary.assertEquals(getText(title), "redbus", "Verify user is on RedBus home page.");
	}

	public class Search {

		public Search setSource(String source) {
			setInputValue(src, source);
			shiftFocusAway(src);
			return this;
		}

		public Search setDestination(String destination) {
			setInputValue(dest, destination);
			shiftFocusAway(dest);
			return this;
		}

		private String getMonthYearFromCalendar() {
			return getText(getMonthYear);
		}

		private void selectDay(String day) {
			clickElement(String.format(setDay, day), "Day");
		}

		public Search selectOnwardDate(String date) {
			clickElement(onwardDate, "Onward date");
			String[] dateArray = date.split("-");
			if (getMonthYearFromCalendar().equals(dateArray[1])) {
				selectDay(dateArray[0]);
			}
			return this;
		}

		public Search selectReturnDate(String date) {
			clickElement(returnDate, "Return date");
			String[] dateArray = date.split("-");
			if (getMonthYearFromCalendar().equals(dateArray[1])) {
				selectDay(dateArray[0]);
			}
			return this;
		}

		public void searchBuses() {
			clickElement(searchBuses, "Search button");
		}
	}
}
