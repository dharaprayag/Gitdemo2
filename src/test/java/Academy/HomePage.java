package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Resources.Base;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends Base
{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException
	{
		try {
			log.info("This is Info1");
			log.debug("This is Debuug1");
			log.error("This is error1");
			log.fatal("This is fatal1");
		driver = initilizeDriver();
		driver.get(siteUrl);
		LandingPage l = new LandingPage(driver);
		  
		LoginPage lp = l.getLogin();
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		
		
		/////Forgot Password
		ForgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys(forgotPasswordEmail);
		fp.sendMeInstructions().click();
		
		
		log.info(username);
		lp.getLogin().click();	
		}catch(Exception e) {
			log.error(e.getMessage());
			log.error("Error in Homepage");
		}		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data = new Object[3][3];
		//0th row
		data[0][0] = "nonrestricteduser@hfj.com";
		data[0][1] = "112324";
		data[0][2] = "text";
		
		//1st row
		data[1][0] = "restricteduser@dpd.com";
		data[1][1] = "17061992";
		data[1][2] = "Restricted User";
		
		//2nd row
		data[2][0] = "abdcdljd@jfj.com";
		data[2][1] = "u7t6757657";
		data[2][2] = "dbdjisos";
		
		return data;
		
	}
	

}
