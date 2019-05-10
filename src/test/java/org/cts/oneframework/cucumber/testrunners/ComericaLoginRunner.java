package org.cts.oneframework.cucumber.testrunners;

import org.cts.oneframework.cucumber.AbstractTestNGCucumberTest;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/ComericaLogin.feature", 
	glue = { "org.cts.oneframework.cucumber.stepdefinition" }, 
	plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class ComericaLoginRunner extends AbstractTestNGCucumberTest {
}