package com.bcframworkhybridpage_object_models;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    WebDriver driver;

    @FindBy(name = "search")
    WebElement searchField;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    WebElement searchButton;

    @FindBy(xpath = "//h1[contains(text(),'Search')]")
    WebElement searchResultsHeader;

    @FindBy(linkText = "HP LP3065")
    WebElement specificProductLink;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSearchField(String productName) {
        searchField.sendKeys(productName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isSearchResultsHeaderPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchResultsHeader));
        return searchResultsHeader.isDisplayed();
    }

    public void clickSpecificProductLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(specificProductLink));
        specificProductLink.click();
    }

}
