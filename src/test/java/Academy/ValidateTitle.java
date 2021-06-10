package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.LandingPage;

public class ValidateTitle extends Base
{
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initilizeDriver();
		log.info("Driver is Initilized");
		driver.get(siteUrl);
		log.info("Navigated to Homepage");
	}
	
	@Test
	public void validateAppTitle() throws IOException
	{
		LandingPage l = new LandingPage(driver);
		//compare the text from the browser with actual text. 
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message");
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
}
