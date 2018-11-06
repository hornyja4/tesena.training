package tesena.automation.training.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.driver.DriverManager;

public class ProjectsPage extends Header {

    @FindBy(xpath = "//div[@id='projects-index']")
    private WebElement projectsList;

    public ProjectsPage(DriverManager driverManager) {
        super(driverManager);
    }

    @Override
    public void synchronize() {
        waitForElement(projectsList);
    }

    public ProjectDetailPage openProjectDetail(String projectName) {
        projectsList
                .findElement(By.xpath(".//a[text()='" + projectName + "']"))
                .click();
        return new ProjectDetailPage(driverManager);
    }
}
