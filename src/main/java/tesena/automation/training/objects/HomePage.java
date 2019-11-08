package tesena.automation.training.objects;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;

public class HomePage extends HeaderMenu {

    @FindBy(xpath = "//a[@href='/loterie/sportka']")
    private WebElement sportkaBanner;

    @FindBy(xpath = "//a[@href='/loterie/eurojackpot']")
    private WebElement eurojackpotBanner;

    @FindBy(xpath = "//a[@href='/loterie/s10']")
    private WebElement s10Banner;

    public HomePage(DriverManager driverManager) {
        super(driverManager);
    }

    public SportkaHomePage clickOnSportkaBanner() {
        waitForElement(sportkaBanner).click();
        return new SportkaHomePage(driverManager);
    }
}
