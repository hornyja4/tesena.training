package tesena.automation.training.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.*;
import tesena.automation.training.driver.DriverManager;
import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed.");
    }

    public void onTestFailure(ITestResult result) {
        DriverManager driverManager = DriverManager.getInstance();
        File screenshot = driverManager.getDriver().getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("target\\images\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Test failed.");
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}
