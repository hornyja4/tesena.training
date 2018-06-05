package tesena.automation.training.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tesena.automation.training.factory.POFactory;

public class ProjectsPage extends Header {

    @FindBy(id = "projects-index")
    private WebElement projectsList;

    @Override
    public void synchronize() {
        waitForElement(projectsList);
    }

    public ProjectDetailOverviewPage projectDetail(String name) {
        try {
            projectsList.findElement(By.xpath(".//a[text()='" + name + "']")).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Searched project '" + name + "' does not exist.\n" + e.getLocalizedMessage());
        }
        return POFactory.createObject();
    }
}
