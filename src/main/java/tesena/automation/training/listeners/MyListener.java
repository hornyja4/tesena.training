package tesena.automation.training.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tesena.automation.training.logger.TestLogger;
import tesena.automation.training.test.SimpleTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String destination = "/reports/"
                + new SimpleDateFormat("yyyyMMdd").format(new Date())
                + "/" + result.getTestClass().getRealClass().getName()
                + "/" + testName + ".log";
        TestLogger.initLogger(testName, destination);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
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
