package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.CucumberReporting;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue = "stepDefinitions",
		tags = "@Test",
		dryRun = false,
		monochrome = true,
		strict = true,
		plugin = {
				"pretty", 
				"html:target/site/cucumber-pretty",
				"json:target/cucumber.json" }, 
		publish = true
		
		
		
		
		)

public class TestRunner {
	
	@AfterClass
	public static void generateReport() {
		CucumberReporting.reportConfig();
	}
	

}
