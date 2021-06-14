package com.accelerator.automation.runners;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue = {"com.accelerator.automation.stepdefs.ecom","com.accelerator.automation.hooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:target/test-output-thread/"},
		features = {"src/test/resources/features/ECOM/"}
	)

public class DefaultRunner extends AbstractTestNGCucumberParallelTests {
	
}
