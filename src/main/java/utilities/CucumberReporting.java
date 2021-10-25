package utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import core.Base;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

public class CucumberReporting  extends Base{
	
	public static void reportConfig() {
		File reportOutputDirectory = new File("target");
		
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target\\cucumber.json");
		

		String buildNumber = properties.getProperty("buildVersion");
		String projectName = properties.getProperty("projectName");

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc for details
		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		// do not make scenario failed when step has status SKIPPED
		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", properties.getProperty("platform"));
		configuration.addClassifications("Browser", getBrowserName());
		configuration.addClassifications("Branch", properties.getProperty("branch"));
		configuration.addClassifications("Environment", properties.getProperty("environment"));

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
		// and here validate 'result' to decide what to do if report has failed
	}


}
