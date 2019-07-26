package cigniti.runner;

import org.testng.annotations.AfterSuite;
import cigniti.utils.ReportGeneration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cigniti/features", tags = { "not @ignore" }, monochrome = true, plugin = {
		"pretty", "html:target/cucumber-report/restresult", "json:target/cucumber-report/restresult.json",
		"rerun:target/restrerun.txt" }, glue = { "/cigniti/steps" }

)
public class RestRunner extends AbstractTestNGCucumberTests {
	ReportGeneration generateReport = new ReportGeneration();

	@AfterSuite
	public void afterSuite() {
		generateReport.generateSummaryReport();
	}

}
