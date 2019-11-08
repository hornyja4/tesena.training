package tesena.automation.training.tests.example_6;

import org.testng.annotations.Test;
import tesena.automation.training.objects.HomePage;
import tesena.automation.training.test.SazkaTest;

public class LotteryTest extends SazkaTest {

    @Test
    public void sportkaLotteryTest() throws InterruptedException {
        HomePage homePage = new HomePage(driverManager);
        homePage.clickOnSportkaBanner()
                .betOnline()
                .selectNumbers(new String[]{"1", "2", "4", "10", "12", "20"});
        Thread.sleep(10000);
    }
}
