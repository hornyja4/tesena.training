package tesena.automation.training.objects;

import org.openqa.selenium.WebElement;

public class HomePage extends Header {
    private WebElement loggedas;

    @Override
    public void synchronize() {
        waitForElement(loggedas);
    }
}
