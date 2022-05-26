package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Features/DropDownMenu.feature"},
        glue = {"StepDefs","utils"}
)
public class DrpDownRunner extends AbstractTestNGCucumberTests {
}
