package stepDefinitions;

import core.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Initializer extends Base {
	
	@Before
	public void beforeHooks(Scenario scenario) {
		logger.info(scenario.getName()+ " Started");
		scenario.log(scenario.getName()+ " Started");
		selectBrowser();
		openBrowser();
		
		
		
	}
	
	@After
	public void afterHooks(Scenario scenario) {
		tearDown();
		logger.info(scenario.getName()+ " " + scenario.getStatus());
		scenario.log(scenario.getName()+ " " + scenario.getStatus());
		
		
	}

}
