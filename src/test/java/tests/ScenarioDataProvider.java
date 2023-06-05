package tests;

import org.testng.annotations.DataProvider;

public class ScenarioDataProvider {

    @DataProvider(name = "scenarios")
    public Object[][] scenarios(){
        return new Object[][] {
                {0, "Wrong Answer!"},
                {1, "You are right!"},
                {2, "Wrong Answer!"},
        };
    }
}
