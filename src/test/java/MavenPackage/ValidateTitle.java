package MavenPackage;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;

public class ValidateTitle extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initiaized.");
//		driver.get(properties.getProperty("url"));
		driver.get("http://www.qaclickacademy.com/");
		log.info("Navigated to home page");

	}
	@Test
	public void basePageNavigation() throws IOException {
		
		
		
		//create object to that class and invoke methods of it
		LandingPage landingPage = new LandingPage(driver);
		//compare the text from the browser with actual text. -Error
		Assert.assertEquals(landingPage.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated title");

		
		

	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
