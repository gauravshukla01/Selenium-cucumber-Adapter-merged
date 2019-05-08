package org.cts.oneframework.cucumber;

import org.openqa.selenium.WebDriver;

public class CucumberRuntime {

	private WebDriver driver;

	public CucumberRuntime() {
	}

	public CucumberRuntime(WebDriver driver) {
		this.driver = driver;
	}

	private static ThreadLocal<CucumberRuntime> instances = new ThreadLocal<>();

	public static synchronized CucumberRuntime get() {
		return instances.get();
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static synchronized void set(WebDriver driver) {
		instances.set(new CucumberRuntime(driver));
	}


}
