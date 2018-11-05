package tesena.automation.training.driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
    private DriverManager driverManager = DriverManager.getInstance();

    public PageObject() {
        PageFactory.initElements(driverManager.getDriver(), this);
        synchronize();
    }

    public abstract void synchronize();

    protected void waitForElement(WebElement element) {
        driverManager.waitForElement(element);
    }
}
