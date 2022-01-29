package parallelTestng;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import com.pages.LeadsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LeadPageSteps {
	
	private static String firstName =null;

	private LeadsPage leadPage = new LeadsPage(DriverFactory.getDriver());

	@Then("user should click on add button")
	public void user_should_click_on_add_button() {
		leadPage.clickOnAddLead();
	}

	@Then("user should be see {string} form")
	public void user_should_be_see_form(String expectedMessge) {
		Assert.assertEquals((leadPage.getLeadFormSubtitle()),expectedMessge);
	}

	@When("user should fill form with given sheetname {string} and rownumber {int}")
	public void user_should_fill_form_with_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) {
		ExcelReader excel = new ExcelReader();
		try {
			List<Map<String, String>> testdata = excel.getData("./src\\test\\resources\\VtigerCrmAutomation.xlsx",
					sheetName);
		    firstName = testdata.get(rowNumber).get("firstName");
			String LastNameName = testdata.get(rowNumber).get("lastName");
			String CompanyName = testdata.get(rowNumber).get("companyName");
			leadPage.fillLeadForm(firstName, LastNameName, CompanyName);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@When("user should click on save button")
	public void user_should_click_on_save_button() {
		leadPage.clickOnSaveButton();
	}

	@Then("it show lead information by getting first name")
	public void it_show_lead_information_by_getting_first_name() {
		Assert.assertEquals((leadPage.getLeadInformation()),firstName);
	}
}
