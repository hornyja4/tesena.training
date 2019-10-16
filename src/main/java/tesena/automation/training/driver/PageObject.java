package tesena.automation.training.driver;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tesena.automation.training.logger.TestLogger;

public abstract class PageObject {
    protected Logger logger = TestLogger.getLogger();
    protected DriverManager driverManager;

    public PageObject(DriverManager driverManager) {
        this.driverManager = driverManager;
        PageFactory.initElements(driverManager.getDriver(), this);
        driverManager.waitForPageToLoad();
        synchronize();
    }

    public abstract void synchronize();

    protected void waitForElement(WebElement element) {
        driverManager.waitForElement(element);
    }
}
