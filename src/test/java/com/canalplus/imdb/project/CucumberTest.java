package com.canalplus.imdb.project;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"}, // location of test result data output
        features = {"classpath:features"},  // location of feature files
        glue = {"com.canalplus.imdb.project"})
public class CucumberTest {
}
