package tesena.automation.training.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tesena.automation.training.logger.TestLogger;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoggerListener implements ITestListener {
    private Calendar calendar = Calendar.getInstance();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String testName = iTestResult.getTestClass().getRealClass().getSimpleName();
        String destination = "test_reports" +
                        File.separator +
                        new SimpleDateFormat("MMMMM").format(calendar.getTime()) +
                        File.separator +
                        new SimpleDateFormat("dd").format(calendar.getTime()) +
                        File.separator +
                        new SimpleDateFormat("HH.mm").format(calendar.getTime()) +
                        File.separator
                        + testName + ".log";
        TestLogger.initLogger(testName, destination);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
