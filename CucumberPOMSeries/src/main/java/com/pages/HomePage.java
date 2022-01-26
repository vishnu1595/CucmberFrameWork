package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;

	private By listOfMoudle=By.xpath("//tbody/tr/td[@class='tabUnSelected']/a");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public int getModuleTabSectionCount() {
		return driver.findElements(listOfMoudle).size();
	}
	
	public List<String> getModuleTabSectionList() {
		List<String> actualModuleList=new ArrayList<>();
		List<WebElement> listmodules = driver.findElements(listOfMoudle);
		for(WebElement e : listmodules) {
			String text = e.getText();
			System.out.println(text);
			actualModuleList.add(text);
		}
		return actualModuleList;
	}
	
	public String getHomePageTite() {
		return driver.getTitle();
	}
	
	public String sectingModuleByName(String moduleName) {
		List<WebElement> listOfModules = driver.findElements(listOfMoudle);
		for(WebElement e : listOfModules) {
			if(e.getText().equalsIgnoreCase(moduleName)) {
				e.click();
				break;
			}
		}
		return driver.getTitle();
	}
}
