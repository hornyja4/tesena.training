package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;

public class LoginPage extends Header {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submit;

    public LoginPage(DriverManager driverManager) {
        super(driverManager);
    }

    public LoggedPage login(String user, String pwd) {
        this.username.sendKeys(user);
        this.password.sendKeys(pwd);
        this.submit.click();
        return new LoggedPage(driverManager);
    }
}
