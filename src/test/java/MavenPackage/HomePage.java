package MavenPackage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String User, String Pass, String Text) throws IOException {

//		driver.get(properties.getProperty("url"));
		driver.get("http://www.qaclickacademy.com/");
		// create object to that class and invoke methods of it
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getLogin().click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(User);
		loginPage.getPass().sendKeys(Pass);
//		System.out.println(Text);
		log.info(Text);


		loginPage.getButton().click();

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		// row stands for how many different data types test should run
		// column stand for how many values per each test

		Object[][] data = new Object[2][3];
		// 0th row
		data[0][0] = "Non-restricteduser@abc.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		// 1st row
		data[1][0] = "restricteduser@abc.com";
		data[1][1] = "123456";
		data[1][2] = "Non-restricted User";

		return data;

	}

}
