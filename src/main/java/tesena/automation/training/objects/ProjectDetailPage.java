package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;

public class ProjectDetailPage extends Header {

    @FindBy(xpath = "//a[@class='new-issue']")
    private WebElement newIssue;

    public ProjectDetailPage(DriverManager driverManager) {
        super(driverManager);
    }

    public NewIssuePage newIssue() {
        newIssue.click();
        return new NewIssuePage(driverManager);
    }
}
