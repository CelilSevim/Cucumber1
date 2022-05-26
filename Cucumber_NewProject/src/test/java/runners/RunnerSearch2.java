package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.Browser;
import utils.Driver;

@CucumberOptions(
        features = {"src/test/java/features/search.feature"},
        glue = {"stepdefs"},
        dryRun = false

)
public class RunnerSearch2 extends AbstractTestNGCucumberTests {


}
