package tesena.automation.training.driver;

import org.openqa.selenium.WebElement;

public abstract class PageObject {
    private DriverManager driverManager = DriverManager.getInstance();

    public abstract void synchronize();

    protected void waitForElement(WebElement element){
        driverManager.waitForElement(element);
    }
}
