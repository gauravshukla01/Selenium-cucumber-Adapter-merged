package org.cts.oneframework.webapicucumber.stepdefinition;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.cts.oneframework.excelreader.ReadExcel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class DefaultStepDefinition {

	public static ThreadLocal<Map<String, String>> currentIterationMap = new ThreadLocal<>();
	private Map<String, Map<String, String>> excelData = new LinkedHashMap<>();
	private static String rowName;

	@Before
	public void readScenarioName(cucumber.api.Scenario scenario) {
		rowName = scenario.getName();
	}

	@Given("^A workbook named \"([^\"]*)\" and sheet named \"([^\"]*)\" is read$")
	public synchronized void a_workbook_named_and_sheet_named_is_read(String excelName, String sheetName) {
		List<Map<String, String>> data = ReadExcel.readData(excelName, sheetName);
		for (Map<String, String> map : data) {
			excelData.put(map.get("TestDataID").trim(), map);
		}
		currentIterationMap.set(excelData.get(rowName));
	}
}
