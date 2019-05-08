package org.cts.oneframework.cucumber.stepdefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.cts.oneframework.excelreader.ReadExcel;
import org.cts.oneframework.exception.ExcelDetailException;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class DefaultStepDefinition {

	private static ThreadLocal<String> testDataId = new ThreadLocal<>();
	private static ThreadLocal<String> scenarioName = new ThreadLocal<>();
	private static ThreadLocal<String> excel = new ThreadLocal<>();
	private static ThreadLocal<String> sheet = new ThreadLocal<>();
	private static Logger logger = Logger.getLogger(DefaultStepDefinition.class.getName());
	private static ThreadLocal<ArrayList<Map<String, String>>> excelData = new ThreadLocal<ArrayList<Map<String, String>>>() {
		@Override
		protected ArrayList<Map<String, String>> initialValue() {
			return new ArrayList<>();
		}
	};

	private static ThreadLocal<Map<String, String>> excelRowData = new ThreadLocal<Map<String, String>>() {
		@Override
		protected HashMap<String, String> initialValue() {
			return new HashMap<>();
		}
	};

	@Before
	public void readScenarioName(Scenario scenario) {
		testDataId.set(scenario.getName());
	}

	@Given("^A workbook named \"([^\"]*)\" and sheet named \"([^\"]*)\" is read$")
	public synchronized void a_workbook_named_and_sheet_named_is_read(String excelName, String sheetName) {
		excelRowData.set(null);
		if (scenarioName.get() == null || !sheetName.equals(sheet.get()) || !excelName.equals(excel.get()) || !testDataId.get().equals(scenarioName.get())) {
			excelData.get().addAll(ReadExcel.readData(excelName, sheetName));
		}
		List<Map<String, String>> removeData = new ArrayList<>();
		for (Map<String, String> map : excelData.get()) {
			if (map.get("TestDataID").equals(testDataId.get())) {
				excelRowData.set(map);
				removeData.add(map);
				break;
			}
		}
		if (!removeData.isEmpty())
			excelData.get().remove(removeData.get(0));
		scenarioName.set(testDataId.get());
		sheet.set(sheetName);
		excel.set(excelName);
	}

	public static String getCellData(String columnName) {
		String cellValue = null;
		if (columnName != null) {
			if (excelRowData.get() != null) {
				cellValue = excelRowData.get().get(columnName.trim());
				if (cellValue == null) {
					logger.warning("Cell value for column '" + columnName + "' from Excel '" + excel.get() + "' sheet '" + sheet.get() + "' is null. Respective row data is: " + excelRowData.get());
				}
			} else {
				throw new ExcelDetailException("Not able to find row in excel with TestDataID: " + testDataId.get() + ". It could be because number of rows in Examples table is greater than number of rows with same TestDataId in the corrsponding excel. ");
			}
		}
		return cellValue;
	}
}