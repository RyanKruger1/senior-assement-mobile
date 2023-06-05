package tests.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultScreen {

    private static AppiumDriver _driver;

    public ResultScreen(AppiumDriver driver) {
        _driver = driver;
    }

    public String getTextAnswer() {
        WebElement resultText = _driver.findElement(By.id(Elements.ANSWER_LABEL_ID));
        return resultText.getText();
    }
}