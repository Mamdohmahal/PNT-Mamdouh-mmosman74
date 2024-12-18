package com.bcframeworkhybrid_testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bcframeworkhybrid.utilities.ConfigReader;
import com.bcframeworkhybrid_Base.BaseClass;
import com.bcframworkhybridpage_object_models.LoginPage;


public class LoginTest extends BaseClass{
    LoginPage loginPage;
    ConfigReader ConfigReader;
    
    
    @BeforeMethod
    public void setup() {
        
    	super.setup(); // Call the setup method from BaseClass
        loginPage = new LoginPage(driver);
        ConfigReader = new ConfigReader();
    }

    @Test (priority=1)
    public void verifySuccessfulLogin() {
        loginPage.clickMyAccountLink();
        loginPage.clickLoginLink();
        loginPage.setEmail(ConfigReader.getProperty("validUsername"));;
        loginPage.setPassword(ConfigReader.getProperty("password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isLogoutLinkPresent(), "Login was not successful!");
    }

    @Test (priority=2)
    public void verifyLoginWithInvalidData() {
        loginPage.clickMyAccountLink();
        loginPage.clickLoginLink();
        loginPage.setEmail(ConfigReader.getProperty("invalidUsername"));
        loginPage.setPassword(ConfigReader.getProperty("password"));
        loginPage.clickLoginButton();
         
        
		String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);	
    }  
    
    @AfterMethod
    public void teardown() {
        super.teardown(); // Call the teardown method from BaseClass
    }

}
