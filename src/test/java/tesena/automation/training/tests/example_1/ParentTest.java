package tesena.automation.training.tests.example_1;

import org.testng.annotations.*;

public class ParentTest {

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
