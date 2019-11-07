package tesena.automation.training.tests.example_1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest extends ParentTest {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @Test
    public void login() {
        System.out.println("login done");
    }

    @Test
    public void logout() {
        System.out.println("logout done");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }
}
