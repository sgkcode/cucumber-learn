package com.github.sgkcode.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber-reports/CucumberTests.html",
        "json:target/cucumber-reports/CucumberTests.json",
        "junit:target/cucumber-reports/CucumberTests.xml"},
    monochrome = true,
    tags = "",
    glue = "com.github.sgkcode",
    features = "src/test/resources/features"
)
public class CucumberTest {

}
