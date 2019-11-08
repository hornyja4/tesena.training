package tesena.automation.training.objects;

import tesena.automation.training.driver.DriverManager;

public class SportkaBettingPage extends LotteryBettingPage {

    public SportkaBettingPage(DriverManager driverManager) {
        super(driverManager);
    }

    public SportkaBettingPage selectNumbers(String[] numbers) {
        if (numbers.length != 6) {
            throw new RuntimeException("Sportka needs 6 numbers");
        }
        super.selectGameNumbers(numbers);
        return this;
    }
}
