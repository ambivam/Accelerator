package com.accelerator.automation.runners;

import java.util.List;

import com.accelerator.automation.utilities.ExamplesBuilder;
import com.accelerator.automation.utilities.MongoDBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;


import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import gherkin.events.PickleEvent;


public abstract class AbstractTestNGCucumberParallelTests extends AbstractTestNGCucumberTests {

    static Logger logger = LogManager.getLogger(MongoDBUtils.class);
    private static long duration;

    @BeforeClass
    public void before() {

        duration = System.currentTimeMillis();
        System.out.println("Thread Id  | Scenario Num       | Step Count");

    }

    @AfterClass
    public void after() {
        duration = System.currentTimeMillis() - duration;
        System.out.println("DURATION - " + duration);

    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Override
    @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        //System.out.println("this is something"+pickleWrapper.getPickleEvent().pickle.getSteps().get(0).getText());
        PickleEvent pEvent = pickleWrapper.getPickleEvent();
        ExamplesBuilder example = new ExamplesBuilder(pEvent);
        List<PickleEvent> pEvents = example.createPickle();
        for (PickleEvent pE : pEvents) {
            PickleEventWrapper yo = new ExamplesBuilder(pE);
            super.runScenario(yo, featureWrapper);
        }
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        try {
            logger.info("Sucessfully inserted into mongodb");
            MongoDBUtils.storeResultsIntoMongoDB();
        } catch (Exception e) {
            logger.info("Not Sucessfully inserted into mongodb");
            throw new Exception(e.getMessage());
        }
    }

}