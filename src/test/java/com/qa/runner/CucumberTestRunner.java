
package com.qa.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/Features",glue = {"com.qa.stepDefinitions"},plugin = {"pretty","html:target/htmlReport"})
public class CucumberTestRunner {

}
