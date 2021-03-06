package appHooks;

import java.util.Properties;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;


	@Before (value="@skip",order=0)
	public void skip_scenario(Scenario sce) {
		System.out.println("Skipped scenario is : "+sce.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order = 1)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.initProp();

	}
    
	
	@Before(order = 2)
	public void launchBrowser() {
		String browserName  = prop.getProperty("Browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(browserName);
	}

	@After(order = 0)
	public void closeBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenShotName);
		}
	}
}
