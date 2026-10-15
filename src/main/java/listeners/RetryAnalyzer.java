package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	public final int MAX_RETRY = 2;
	public int count =0;
	public boolean retry(ITestResult result) {
		if(count<MAX_RETRY) {
			count++;
			System.out.println("Retrying test " + result.getName() +" with status " + result.getStatus() +" for the " + count + " time(s).");
			return true;
		}
		return false;

	}
}
