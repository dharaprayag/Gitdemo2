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



//org.apache.logging.log4j.simplelog.StatusLogger.level
//adding logs
//generating html reports
//screenshot on failure
//Jenkins integration


public class ValidateNavigationBar extends Base
{ 
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initilizeDriver();
		driver.get(siteUrl);
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		LandingPage l = new LandingPage(driver);
		//compare the text from the browser with actual text. 
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("Navigation bar is displayed");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
}
