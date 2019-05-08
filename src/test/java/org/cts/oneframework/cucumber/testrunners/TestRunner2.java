package org.cts.oneframework.cucumber.testrunners;

import org.cts.oneframework.cucumber.AbstractTestNGCucumberTest;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/BNYMTestFeature.feature", glue =
{ "org.cts.oneframework.cucumber.stepdefinition" }, 
plugin = { "pretty" })
public class TestRunner2 extends AbstractTestNGCucumberTest {
}