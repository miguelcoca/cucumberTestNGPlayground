package cucumberTestNGPlayground.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-reports/report.html"},
        features = "src/test/resources/features/",
        glue = {"cucumberTestNGPlayground.stepDefinitions"},
        tags = ""
        )
class TestRunner extends AbstractTestNGCucumberTests{}