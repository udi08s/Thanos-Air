package com.testingfoo.BDDRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

public class BDDRunner {
	

 
@RunWith(Cucumber.class)

@CucumberOptions(
 features = {"src/test/java/com/testingfoo/featurefiles"}
 ,glue={"src/test/java/com/testingfoo/stepfiles"}
 ,monochrome = true
 ,tags= {} 
 )
 
public class TestRunner {

}
 

}
