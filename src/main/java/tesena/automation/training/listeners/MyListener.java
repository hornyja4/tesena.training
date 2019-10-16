package tesena.automation.training.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tesena.automation.training.logger.TestLogger;

public class MyListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getTestClass().getRealClass().getSimpleName();
        TestLogger.initLogger(testName, "/reports/" + testName + "/" + testName + ".log");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
