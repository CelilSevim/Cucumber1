package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"src/test/java/Features/THY.feature"},
            glue = {"StepDefs"}
)
public class thyRunner extends AbstractTestNGCucumberTests {

}
