package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static ExtentReports extentReports;

	public static ExtentReports getInstance() {
		if(extentReports==null) {
			ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/ExtentReport.html");
			extentReports = new ExtentReports();
			extentReports.attachReporter(spark);

			spark.config().setDocumentTitle("My Rest Assured Report Document!");
			spark.config().setReportName("RestAssured API Testing");

			extentReports.setSystemInfo("Machine", "Windows");
			extentReports.setSystemInfo("Env", "SIT1");
			extentReports.setSystemInfo("Role", "QA");
		}
		return extentReports;
	}
}
