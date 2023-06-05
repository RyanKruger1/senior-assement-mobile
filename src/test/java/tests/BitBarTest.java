package tests;

import com.google.gson.JsonObject;
import core.AppiumDriverClient;
import core.AppiumTestListener;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.screens.RadioButtonScreen;
import tests.screens.ResultScreen;

@Listeners(AppiumTestListener.class)
public class BitBarTest extends AppiumDriverClient {

    private RadioButtonScreen radioButtonScreen;
    private ResultScreen resultScreen;

    @BeforeMethod
    public void pageSetup() {
        radioButtonScreen = new RadioButtonScreen(driver);
        testData = reader.readConfigData();
    }

    @Test(dataProviderClass = ScenarioDataProvider.class, dataProvider = "scenarios")
    public void selectAnswerAndValidateOutput(int id, String outputMessage) {
        radioButtonScreen.enterName(testData.get("name").getAsString());
        radioButtonScreen.clickRadioButton(id);
        resultScreen = radioButtonScreen.clickButton();
        Assert.assertEquals(resultScreen.getTextAnswer(), outputMessage);
    }

    @Test(dataProviderClass = ScenarioDataProvider.class, dataProvider = "scenarios")
    public void clickRadioButtonsWithNoName(int id, String outputMessage) {
        radioButtonScreen.clickRadioButton(id);
        Assert.assertFalse(radioButtonScreen.isAnswerButtonGrayedOut());
    }
}