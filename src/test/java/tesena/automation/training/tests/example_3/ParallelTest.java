package tesena.automation.training.tests.example_3;

import net.bytebuddy.utility.RandomString;
import org.testng.annotations.*;

public class ParallelTest {
    private String testName = "";

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeTest(@Optional("CHROME") String browser) {
        this.testName = RandomString.make(10);
        long id = Thread.currentThread().getId();
        System.out.println("Before test: " + testName + ". Thread id is: " + id);
    }

    @Test
    public void testMethodOne() {
        long id = Thread.currentThread().getId();
        System.out.println("Test: " + testName
                + ". Thread id is: " + id);
    }

    @AfterMethod
    public void afterTest() {
        long id = Thread.currentThread().getId();
        System.out.println("After test: " + testName + ". Thread id is: " + id);
    }
}
