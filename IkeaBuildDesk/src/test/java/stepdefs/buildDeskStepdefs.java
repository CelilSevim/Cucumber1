package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static pages.Locators.*;

public class buildDeskStepdefs {
    @Given("user on planner page")
    public void userOnPlannerPage() {
        //Configuration.browser="chrome";
        Configuration.timeout = 10000;
       // Configuration.holdBrowserOpen=true;
        open(url);
        WebDriverRunner.getWebDriver().manage().window().maximize();


    }

    @And("user clicks design own desk")
    public void a() {
        $(buildOwnDeskLink).scrollIntoView(true).click();

        $(iframeConfig).shouldBe(Condition.visible, Duration.ofSeconds(20));
        switchTo().frame("byod-application");
        $(configurationMenu).shouldBe(Condition.visible).click();
    }

    @When("user selects dimension as {string}")
    public void userSelectsDimensionAs(String dimension) {

        $(dimensionMenu).click();
        if (dimension.equalsIgnoreCase("large"))
            $(dimensionLarge).click();
        else
            $(dimensionSmall).click();

        //int a = dimension.equalsIgnoreCase("large") ? 3 : 5;

    }

    @And("user selects unit as {string}")
    public void userSelectsUnitAs(String unit) {
          $(unitMenu).click();
          if(unit.equalsIgnoreCase("units"))
              $(unitUnits).click();
    }

    @Then("price should be {double}")
    public void priceShouldBe(double price) {
        String p = String.valueOf(price);
        $(totalPrice).scrollTo().shouldHave(Condition.text(p));

    }
}
