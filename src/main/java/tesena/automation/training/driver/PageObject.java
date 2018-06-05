package tesena.automation.training.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import tesena.automation.training.factory.POFactory;

public abstract class PageObject {
    private DriverManager driverManager = DriverManager.getInstance();
    protected Logger logger = LogManager.getLogger();

    public PageObject() {
        POFactory.processPageObjectComponents(this);
    }

    public abstract void synchronize();

    protected void waitForElement(WebElement element){
        driverManager.waitForElement(element);
    }
}
