package org.cts.oneframework.cucumber.stepdefinition;

import org.cts.oneframework.dbadapter.mongo.DatabaseProvider;

import java.sql.SQLException;

import org.bson.Document;
import org.cts.oneframework.configprovider.ConfigProvider;
import org.cts.oneframework.utilities.DateUtils;

import com.mongodb.client.FindIterable;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DBStepDefinition {
	
	@Then("Get records from Database")
	public void get_records_from_database() throws SQLException {
		FindIterable<Document> documents = DatabaseProvider.executeQuery(ConfigProvider.getAsString("host"),ConfigProvider.getAsInt("port"),ConfigProvider.getAsString("dbName"),ConfigProvider.getAsString("collectionName"));		
		for( Document document : documents) {
			System.out.println(document.toString());
		}
	}

}
