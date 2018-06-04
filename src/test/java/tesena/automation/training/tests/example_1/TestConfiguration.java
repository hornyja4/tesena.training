package tesena.automation.training.tests.example_1;

import org.testng.annotations.*;

public class TestConfiguration {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod");
    }

    @Test
    public void login() {
        System.out.println("login done");
    }

    @Test(enabled = false)
    public void logout() {
        System.out.println("logout done");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite");
    }
}
