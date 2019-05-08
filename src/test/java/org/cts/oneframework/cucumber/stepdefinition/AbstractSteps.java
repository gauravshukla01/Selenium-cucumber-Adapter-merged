package org.cts.oneframework.cucumber.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.cts.oneframewok.seleniumadapter.drivers.DriverManager;
import org.cts.oneframewok.seleniumadapter.drivers.DriverManagerFactory;
import org.cts.oneframework.configprovider.ConfigProvider;
import org.cts.oneframework.cucumber.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps {

	private static ThreadLocal<DriverManager> driverManager = new ThreadLocal<>();
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static ThreadLocal<PageObjectManager> pageObjectManager = new ThreadLocal<>();

	public void startDriver() {
		if (driverManager.get() == null)
			driverManager.set(DriverManagerFactory.getManager(ConfigProvider.getAsString("browser")));
		driver.set(driverManager.get().getDriver());
		driver.get().manage().timeouts().implicitlyWait(ConfigProvider.getAsInt("IMPLICIT_WAIT"), TimeUnit.SECONDS);
		if (!ConfigProvider.getAsString("browser").equalsIgnoreCase("chrome"))
			driver.get().manage().window().maximize();
		pageObjectManager.set(new PageObjectManager(driver.get()));
	}

	public void stopDriver() {
		if (driverManager.get() != null)
			driverManager.get().stopService();
		else {
			throw new RuntimeException("DriverManager is null");
		}
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager.get();

	}

}
