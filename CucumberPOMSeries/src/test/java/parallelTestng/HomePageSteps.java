package parallelTestng;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homepage;
	
	
	@Given("user is already logged in to application")
	public HomePage user_is_already_logged_in_to_application(DataTable CredTable) {
	   List<Map<String, String>> listMap = CredTable.asMaps();
	   String userName=listMap.get(0).get("username");
	   String Password=listMap.get(0).get("password");
	   DriverFactory.getDriver().get("http://localhost:8888/index.php");
	   homepage=loginPage.doLogin(userName, Password);
	   return homepage;
	   
	}

	@Given("user is on Home Page")
	public void user_is_on_home_page() {
	 Assert.assertTrue(homepage.getHomePageTite().contains("Home"));
	}

	@When("User selecting module by name {string}")
	public void user_selecting_module_by_name(String moduleName) {
	    String pageTitle=homepage.sectingModuleByName(moduleName);
	    Assert.assertTrue(pageTitle.contains(moduleName));
	}

	@Then("user gets module tab section")
	public void user_gets_module_tab_section(DataTable moduleSectiontable) {
		List<String> expectedModuleList = moduleSectiontable.asList();
		System.out.println("Expected module section list: "+expectedModuleList);
		List<String> actualModuleList = homepage.getModuleTabSectionList();
		System.out.println("Actual module section list: "+actualModuleList);
		Assert.assertTrue(expectedModuleList.containsAll(actualModuleList));
	}

	@Then("Module count should be {int}")
	public void module_count_should_be(Integer expectedcount) {
	  Assert.assertTrue(homepage.getModuleTabSectionCount()==expectedcount);
	}
}
