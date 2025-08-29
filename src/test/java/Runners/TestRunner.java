package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/java/features",

		glue = "StepDefinition",

		dryRun = false,

		monochrome = true

		)
public class TestRunner {

}
