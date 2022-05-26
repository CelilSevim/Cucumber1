package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.Browser;
import utils.Driver;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepdefs"},
        tags = "@ProductSearch",
        dryRun = false

)
public class RunnerSearch extends AbstractTestNGCucumberTests {
    @BeforeTest
    @Parameters("browser")
    public void beforeTest(String browser) {
        if(browser.equalsIgnoreCase("firefox")){
            Driver.browserNames.set(Browser.FIREFOX);
        }else
            Driver.browserNames.set(Browser.CHROME);


    }

    @AfterTest
    public static void afterSuite() {
        Driver.quitDriver();
    }


}
