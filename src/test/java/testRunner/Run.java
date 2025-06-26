package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
	features = ".//Features/LoginFeatures.feature", //Path to feature files

			glue = "stepdefination",  //Path to step defination
			plugin = {"pretty","html:target/cucumber-reports.html"},   //Generates a nice report
			monochrome = true,   //Makes the console output readable
			dryRun = false // Set to true to validate steps without running tests
)

public class Run 
{


}
