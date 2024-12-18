package com.bcframworkhybridpage_object_models;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    WebDriver driver;

    @FindBy(linkText = "My Account")
    WebElement myAccountLink;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(id = "input-firstname")
    WebElement firstNameField;

    @FindBy(id = "input-lastname")
    WebElement lastNameField;

    @FindBy(id = "input-email")
    WebElement emailField;

    @FindBy(id = "input-telephone")
    WebElement telephoneField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField;

    @FindBy(name = "agree")
    WebElement agreeCheckbox;

    @FindBy(css = "input.btn.btn-primary")
    WebElement continueButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickMyAccountLink() {
        waitForElement(myAccountLink);
        myAccountLink.click();
    }

    public void clickRegisterLink() {
        waitForElement(registerLink);
        registerLink.click();
    }

    public void setFirstName(String firstName) {
        waitForElement(firstNameField);
        firstNameField.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        waitForElement(lastNameField);
        lastNameField.sendKeys(lastName);
    }

    public void setEmail(String email) {
        waitForElement(emailField);
        emailField.sendKeys(email);
    }

    public void setTelephone(String telephone) {
        waitForElement(telephoneField);
        telephoneField.sendKeys(telephone);
    }

    public void setPassword(String password) {
        waitForElement(passwordField);
        passwordField.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        waitForElement(confirmPasswordField);
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void agreeToPrivacyPolicy() {
        waitForElement(agreeCheckbox);
        agreeCheckbox.click();
    }

    public void clickContinueButton() {
        waitForElement(continueButton);
        continueButton.click();
    }


}
