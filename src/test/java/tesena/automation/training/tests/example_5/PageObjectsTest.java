package tesena.automation.training.tests.example_5;

import org.testng.annotations.Test;
import tesena.automation.training.data.User;
import tesena.automation.training.data.Users;
import tesena.automation.training.factory.DataFactory;
import tesena.automation.training.objects.DefaultPage;
import tesena.automation.training.test.RedmineTest;

public class PageObjectsTest extends RedmineTest {

    @Test
    public void loginTest() {
        DefaultPage defaultPage = new DefaultPage(driverManager);
        defaultPage.clickToLogin();
    }
}
