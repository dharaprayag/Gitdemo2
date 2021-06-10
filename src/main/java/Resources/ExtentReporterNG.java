package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	static ExtentReports extent;
	
	public static  ExtentReports getReportObject()
	{
		//this is the sub class
				String path = System.getProperty("user.dir")+"//reports/index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Result");
				reporter.config().setDocumentTitle("Test Result");
				
				// this is the main class
				extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester", "DP");
				return extent;
	}
	
}
