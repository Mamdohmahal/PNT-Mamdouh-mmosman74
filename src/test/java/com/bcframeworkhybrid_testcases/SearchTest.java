package com.bcframeworkhybrid_testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bcframeworkhybrid.utilities.ConfigReader;
import com.bcframeworkhybrid_Base.BaseClass;
import com.bcframworkhybridpage_object_models.SearchPage;

public class SearchTest extends BaseClass {

	SearchPage searchPage;
	ConfigReader ConfigReader;

	@BeforeMethod
	public void setup() {
		super.setup(); // Call the setup method from BaseClass
		searchPage = new SearchPage(driver);
		ConfigReader = new ConfigReader();

	}

	@Test(priority = 1)
	public void verifySearchFunctionality() {

		searchPage.setSearchField(ConfigReader.getProperty("validProduct"));
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isSearchResultsHeaderPresent(), "Search results header is not present!");
		searchPage.clickSpecificProductLink();
		Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getProperty("validProductID")),
				"Did not navigate to the correct product details page!");
	}

	@Test(priority = 2)
	public void verifySearchInvalidProduct() {

		searchPage.setSearchField(ConfigReader.getProperty("invalidProduct"));
		searchPage.clickSearchButton();
		Assert.assertTrue(driver.findElement(By.cssSelector("input#button-search + h2 + p")).isDisplayed());
	}

	@AfterMethod
	public void teardown() {
		super.teardown();
	}

}
