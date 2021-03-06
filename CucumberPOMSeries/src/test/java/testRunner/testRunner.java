package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/parallelTestng/LoginPage.feature" }
                 ,glue = {"StepDefinations", "appHooks"}
                 ,monochrome = true
                 ,plugin = {"pretty",
       "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
       "timeline:test-output-thread/"
       , "rerun:target/failedrerun.txt"
                		}
          //   , tags = "not @skip or not @regression" //it will not run @skip tag
                 
 
              )
public class testRunner {

	
}
