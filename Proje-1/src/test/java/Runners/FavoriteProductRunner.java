package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Features/FavoriteProduct.feature"},
        glue = {"StepDefs","utils"}
)
public class FavoriteProductRunner extends AbstractTestNGCucumberTests {
}
