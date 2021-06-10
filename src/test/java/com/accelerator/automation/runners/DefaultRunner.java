package com.accelerator.automation.runners;




import cucumber.api.CucumberOptions;


@CucumberOptions(
		glue = {"com.accelerator.automation.stepdefs","com.accelerator.automation.hooks"},
		plugin = {"json:target/json-cucumber-reports/cukejson.json",
				"testng:target/testng-cucumber-reports/cuketestng.xml",
				"html:target/cucumber",
				"html:target/reports/htmlreport",
				"json:target/cucumber1.json",
				"html:target/site/cucumber-pretty"},
		features = "src/test/resources/features/e2e/TCID_C6019498.feature")

public class DefaultRunner extends AbstractTestNGCucumberParallelTests {

	
	
}
