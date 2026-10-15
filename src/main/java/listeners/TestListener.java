package listeners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;
import utils.ExtentTestManager;

public class TestListener implements ITestListener {
	public void onStart(ITestContext context) {
		ExtentManager.getInstance();
	}
	public void onFinish(ITestContext context) {
		ExtentManager.getInstance().flush();
	}
	public void onTestStart(ITestResult result) {
		ExtentTest test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
		ExtentTestManager.setExtentTest(test);
	}
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getExtentTest().pass("Name of Test Passed successfully is : "+result.getMethod().getMethodName());
		ExtentTestManager.remove();
	}

	public void onTestFailure(ITestResult result) {		
		String time_stamp =LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		ExtentTestManager.getExtentTest().fail(result.getThrowable());
		ExtentTestManager.remove();
	}
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getExtentTest().skip("Test skipped: " + result.getMethod().getMethodName());
		ExtentTestManager.remove();
	}

}
