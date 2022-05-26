package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Features/ImageandPriceVerify.feature"},
        glue = {"StepDefs","utils"}
)
public class ImageAndPriceRunner extends AbstractTestNGCucumberTests {
}
