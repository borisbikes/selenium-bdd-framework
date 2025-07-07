package com.epam.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report.html", "json:cucumber.json"},
        features = "src/test/resources/feature_files",
        glue = {"com.epam.automation.step_definition"},
        tags = ""
)
public class RunCucumberTest {

}
