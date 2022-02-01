//package parallelTestng;
//
//
//import org.junit.runner.RunWith;
//import org.testng.annotations.DataProvider;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = { "@target/failedrerun.txt" }, 
//                  glue = {"parallelTestng" }, 
//                  monochrome = true, 
//                  plugin = { "pretty",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
//				"timeline:test-output-thread/",
//				"rerun:target/failedrerun.txt"}
//
//                  )
//public class failedParallel extends AbstractTestNGCucumberTests{
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}
//}
