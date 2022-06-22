package cucumberTestNGPlayground.stepDefinitions;

import com.google.common.io.Files;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumberTestNGPlayground.containers.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Hooks {
	
	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = new TestContext() ;
	}
	
	@Before
	public void beforeScenario(Scenario scenario) {
//	    Reporter.assignAuthor("Miguel A Coca - cucumberWebdriverPlayground");
	}
	
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				Files.copy(sourcePath, destinationPath);   
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			} 
		}
	}
	
	
	@After(order = 0)
	public void AfterSteps() {
		testContext.getWebDriverManager().quitDriver();
	}

}
