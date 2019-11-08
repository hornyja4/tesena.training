package tesena.automation.training.tests.example_5;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class NewListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        result.getTestClass().getRealClass().getName();
        System.out.println("Test started: "
                + result.getTestClass().getRealClass().getName()
                + "."
                + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (ListenerTest.driver == null) {
            return;
        }
        File screen = ListenerTest.driver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(
                        screen,
                        new File("/screens/" + result.getMethod().getMethodName() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
