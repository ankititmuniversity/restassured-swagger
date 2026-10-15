package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static ExtentTest getExtentTest(){
    	return extentTest.get();
    }
    
    public static void setExtentTest(ExtentTest extent_test) {
    	extentTest.set(extent_test);
    }
    
    public static void remove() {
    	extentTest.remove();
    }

}
