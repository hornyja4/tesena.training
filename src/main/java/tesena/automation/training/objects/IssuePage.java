package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;

public class IssuePage extends ProjectDetailPage {

    @FindBy(xpath = "//div[@id='flash_notice']")
    private WebElement notice;

    public IssuePage(DriverManager driverManager) {
        super(driverManager);
    }

    public void synchronize() {
        waitForElement(notice);
    }
}
