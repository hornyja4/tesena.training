package tesena.automation.training.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
    private DriverManager driverManager;

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
