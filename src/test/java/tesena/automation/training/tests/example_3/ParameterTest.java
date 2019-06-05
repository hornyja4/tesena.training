package tesena.automation.training.tests.example_3;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    private String browser;

    @Parameters({"browser", "version", "env"})
    @BeforeSuite
    public void init(@Optional("CHROME") String browser, @Optional("65") int version, @Optional("UAT") String env) {
        this.browser = browser;
        System.out.println(browser + ", " + version + ", " + env);
    }

    @Test
    public void parameterTest() {
        System.out.println("Test: " + browser);
    }
}
