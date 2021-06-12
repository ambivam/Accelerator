package com.accelerator.automation.runners;




/*import cucumber.api.CucumberOptions;*/
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = {"com.beachbody.automation.stepdefs","com.beachbody.automation.hooks"}, plugin = {"json:target/json-cucumber-reports/cukejson.json",
		"testng:target/testng-cucumber-reports/cuketestng.xml",
		"html:target/cucumber",
		"html:target/reports/htmlreport","json:target/cucumber4.json","html:target/site/cucumber-pretty"},
		features = "src/test/resources/features/ECOM/")


public class DefaultRunner4 extends AbstractTestNGCucumberParallelTests {

	
	
}
