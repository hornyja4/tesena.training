package tesena.automation.training.tests.example_3;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class RedmineTest {
    protected String browser;

    @Parameters({"browser", "version", "env"})
    @BeforeSuite
    public void init(@Optional("chrome") String browser, @Optional("65") int version, @Optional("UAT") String env) {
        this.browser = browser;
        System.out.println(browser + ", " + version + ", " + env);
    }
}
