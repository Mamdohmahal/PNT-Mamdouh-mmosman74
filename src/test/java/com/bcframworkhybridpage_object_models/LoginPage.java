package com.bcframworkhybridpage_object_models;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    @FindBy(linkText = "My Account")
    WebElement myAccountLink;

    @FindBy(linkText = "Login")
    WebElement loginLink;

    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(css = "input.btn.btn-primary")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickMyAccountLink() {
        waitForElement(myAccountLink);
        myAccountLink.click();
    }

    public void clickLoginLink() {
        waitForElement(loginLink);
        loginLink.click();
    }

    public void setEmail(String email) {
        waitForElement(emailField);
        emailField.sendKeys(email);
    }

    public void setPassword(String password) {
        waitForElement(passwordField);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        waitForElement(loginButton);
        loginButton.click();
    }

    public boolean isLogoutLinkPresent() {
        return driver.getPageSource().contains("Logout");
    }

}
