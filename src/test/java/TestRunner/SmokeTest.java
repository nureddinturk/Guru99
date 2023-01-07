package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(features = "src/test/java/Features", glue = "StepDefinitions",
            monochrome = true, tags = "@SmokeTest", plugin = {"pretty",
            "html:target/cucumber-reports.html", "json:target/cucumber-reports.json",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
    public class SmokeTest  extends AbstractTestNGCucumberTests {
    }

