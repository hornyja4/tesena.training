package tesena.automation.training.tests.example_6;

import org.testng.annotations.Test;
import tesena.automation.training.objects.SeznamPage;
import tesena.automation.training.test.RBTest;

public class PageObjectsTest extends RBTest {

    @Test
    public void loginTest() {
        SeznamPage seznamPage = new SeznamPage(driverManager);
        seznamPage.clickToMaps();
    }
}
