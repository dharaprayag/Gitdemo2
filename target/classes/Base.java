package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base 
{
	
	protected WebDriver driver;	
	protected String siteUrl;
	//protected String username;
	//protected String password;
	//protected String text;
	//protected String titleName;
	protected String forgotPasswordEmail;
	
	String fileInputStream = "C://Users//dhara//eclipse-workspace//E2EProject1//src//main//java//Resources//data.properties";
	public WebDriver initilizeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(fileInputStream); //Here input data properties path
		prop.load(fis);
		siteUrl = prop.getProperty("siteURL");
		//username = prop.getProperty("Username");
		//password = prop.getProperty("Password");
		//text = prop.getProperty("Text");
		//titleName = prop.getProperty("titleName");
		 
		
		String browserName = System.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome"))
		{
			//It executes in Chrome Browser
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromePath"));
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			//It executes in Firefox Browser
			System.setProperty("webdriver.gecko.driver",  prop.getProperty("firefoxPath"));
			driver = new FirefoxDriver();
			
		}
		else if (browserName.equals("IE"))
		{
			//It executes in Internet Explorer
			System.setProperty("webdriver.ie.driver",  prop.getProperty("internetExplorerPath"));
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;	
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports//"+testCaseName+".png"; 
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
		
	}
	
	
}
