package com.accelerator.automation.stepdefs.allstepdefs;



import com.accelerator.automation.common.World;

import cucumber.api.java.en.And;

public class StepDefinition{
	
	private String scenDesc;
	private World world;
	
	public StepDefinition(World world){
		this.world=world;
	}
	
	@And("this is {string} step")
	public void step(String stepNum) {
		
		System.out.format("Thread %2d -> %18s - %-6s STEP\n", Thread.currentThread().getId(), scenDesc, stepNum);
	}
	
	@And("this is {string} step and {string} step")
	public void this_is_step_and_step(String stepSum, String stepNum) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.format("Thread %2d -> %18s - %-6s STEP %-6s\n", Thread.currentThread().getId(), scenDesc, stepNum,stepSum);
	}
	
	
}