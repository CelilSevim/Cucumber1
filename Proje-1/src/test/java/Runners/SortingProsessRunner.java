package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Features/SortingProcess.feature"},
        glue = {"StepDefs","utils"}
)
public class SortingProsessRunner extends AbstractTestNGCucumberTests {
}
