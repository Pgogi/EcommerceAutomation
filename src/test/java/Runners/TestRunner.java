package Runners;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = "StepDefinition",
	    dryRun = false,
	    monochrome = true,
   		plugin = {"pretty", "html:target/cucumber-reports.html"}
	)

public class TestRunner extends AbstractTestNGCucumberTests {

}
