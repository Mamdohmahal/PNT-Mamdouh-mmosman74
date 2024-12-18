package com.bcframeworkhybrid_testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bcframeworkhybrid.utilities.EmailDate;
import com.bcframeworkhybrid.utilities.ExcelReader;
import com.bcframeworkhybrid_Base.BaseClass;
import com.bcframworkhybridpage_object_models.RegisterPage;

public class RegisterTest extends BaseClass {

	RegisterPage registerPage;
	static ExcelReader excelReader;

	static {
		excelReader = new ExcelReader("C:\\Users\\HP-laptop\\eclipse-workspace\\BootCampFramworkHybrid-Mamdouh-mmosman74\\src\\test\\java\\UserRegistration.xlsx");

	}
	
	@BeforeMethod
	public void setup() {
		super.setup(); // Call the setup method from BaseClass
		registerPage = new RegisterPage(driver);
		
	}

	@DataProvider(name = "registrationData")
	public Object[][] registrationData() {
		int rowCount = excelReader.getRowCount("Sheet1");
		Object[][] data = new Object[rowCount][6];

		for (int i = 1; i <= rowCount; i++) {
			data[i - 1][0] = excelReader.getCellData("Sheet1", i, 0);
			data[i - 1][1] = excelReader.getCellData("Sheet1", i, 1);
			data[i - 1][2] = excelReader.getCellData("Sheet1", i, 2);
			data[i - 1][3] = excelReader.getCellData("Sheet1", i, 3);
			data[i - 1][4] = excelReader.getCellData("Sheet1", i, 4);
			data[i - 1][5] = excelReader.getCellData("Sheet1", i, 5);
		}

		return data;
	}

	@Test(dataProvider = "registrationData")
	public void verifySuccessfulRegistration(String FirsName, String LastName, String email, String Telephone, String Password, String ConfirmPassword) {
		driver.get("https://tutorialsninja.com/demo/");
		registerPage.clickMyAccountLink();
		registerPage.clickRegisterLink();
		registerPage.setFirstName(FirsName);
		registerPage.setLastName(LastName);
		registerPage.setEmail(EmailDate.emailWithDateTimeStamp());
		registerPage.setTelephone(Telephone);
		registerPage.setPassword(Password);
		registerPage.setConfirmPassword(ConfirmPassword);
		registerPage.agreeToPrivacyPolicy();
		registerPage.clickContinueButton();

		// Verify registration success
		Assert.assertTrue(driver.getPageSource().contains("Your Account Has Been Created!"),
				"Registration was not successful!");
	}

	@AfterMethod
	public void teardown() {
		super.teardown();
	}

}
