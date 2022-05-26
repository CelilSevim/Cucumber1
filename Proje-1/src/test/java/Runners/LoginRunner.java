package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Features/Login.feature"},
        glue = {"StepDefs","utils"}
)
public class LoginRunner extends AbstractTestNGCucumberTests {
}
