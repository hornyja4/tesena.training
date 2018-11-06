package tesena.automation.training.tests.example_4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class SimpleListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test success:" + iTestResult.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        RemoteWebDriver driver = ParentTest.remoteWebDriver;
        File screen = driver.getScreenshotAs(OutputType.FILE);
        try {
            new File("..\\target\\images").mkdirs();
            FileUtils.copyFile(screen, new File("..\\target\\images\\screen.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
