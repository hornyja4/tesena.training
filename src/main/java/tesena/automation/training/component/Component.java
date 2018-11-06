package tesena.automation.training.component;

import org.openqa.selenium.*;
import tesena.automation.training.driver.DriverManager;

import java.util.List;

public class Component implements WebElement {
    private String xpath;
    private DriverManager driverManager;

    public Component(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void click() {
        findElement().click();
    }

    private WebElement findElement() {
        return driverManager.getDriver().findElement(By.xpath(xpath));
    }

    @Override
    public void submit() {
        findElement().submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        findElement().sendKeys(charSequences);
    }

    @Override
    public void clear() {
        findElement().clear();
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }
}
