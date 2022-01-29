package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadsPage {

	private By addButton = By.xpath("//img[@title='Create Lead...']");
	private By leadForm = By.xpath("//span[text()='Creating New Lead']");
	private By first = By.name("firstname");
	private By last = By.name("lastname");
	private By company = By.name("company");
	private By saveButton = By.name("button");
	private By firstNameFromLeadInfo=By.id("dtlview_First Name");

	private WebDriver driver;

	public LeadsPage(WebDriver driver) {
		this.driver = driver;
	}

	public By getAddButton() {
		return addButton;
	}

	public By getLeadForm() {
		return leadForm;
	}

	public By getFirstName() {
		return first;
	}

	public By getLastName() {
		return last;
	}

	public By getCompanyName() {
		return company;
	}

	public By getSaveButton() {
		return saveButton;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void clickOnAddLead() {
		driver.findElement(addButton).click();
		
	}
	public void fillLeadForm(String firstName, String LastName, String CompanyName) {
		driver.findElement(first).sendKeys(firstName);
		driver.findElement(last).sendKeys(LastName);
		driver.findElement(company).sendKeys(CompanyName);
	}
	public void clickOnSaveButton() {
		driver.findElement(saveButton).click();
	}
	
	public String getLeadFormSubtitle() {
		return driver.findElement(leadForm).getText();
	}
	public String getLeadInformation() {
		return driver.findElement(firstNameFromLeadInfo).getText();
	}
	
}
