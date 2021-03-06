package parallelTestng;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("user is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("http://localhost:8888/index.php");
		 
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		 title = loginPage.getLoginPageTitle();
		System.out.println("page titles is :" + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expTitle) {
		//title = loginPage.getLoginPageTitle();
		//System.out.println("page titles is :" + title);
		Assert.assertTrue(title.contains(expTitle));
	}

	@Then("Read License link should be displayed")
	public void read_license_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isreadLicenseLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.ClickOnLogin();
	}


}
