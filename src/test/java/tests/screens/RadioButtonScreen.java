package tests.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RadioButtonScreen {

    AppiumDriver _driver;
    private static WebDriverWait _wait;

    public RadioButtonScreen(AppiumDriver driver) {
        this._driver = driver;
        _wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickRadioButton(int value) {
        WebElement radioButton = _driver.findElement(By.id("com.bitbar.testdroid:id/radio" + value));
        radioButton.click();
    }

    public void enterName(String text) {
        WebElement textField = _driver.findElement(By.id("com.bitbar.testdroid:id/editText1"));
        textField.sendKeys(text);
    }

    public ResultScreen clickButton() {
        WebElement button = instantiateButton();
        button.click();
        _wait.until(ExpectedConditions.invisibilityOf(button));
        return new ResultScreen(_driver);
    }

    public boolean isAnswerButtonGrayedOut() {
        return instantiateButton().isEnabled();
    }

    public WebElement instantiateButton() {
        return _driver.findElement(By.id("com.bitbar.testdroid:id/button1"));
    }
}