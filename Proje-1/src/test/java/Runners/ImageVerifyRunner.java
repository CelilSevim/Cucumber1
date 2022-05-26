package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Features/Imageverification.feature"},
        glue = {"StepDefs","utils"}


)

public class ImageVerifyRunner extends AbstractTestNGCucumberTests {
}
