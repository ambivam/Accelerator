package com.accelerator.automation.runners;

import java.util.List;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public abstract class AbstractTestNGCucumberParallelTests extends AbstractTestNGCucumberTests {

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




}