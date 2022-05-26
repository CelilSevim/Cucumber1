package StepDefs;

import Pages.thyPO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.ParentClass;

public class thy  {
        thyPO th = new thyPO();
    @Given("goto thy")
    public void gotoThy() {
        th.thy();

    }

    @When("aaaa")
    public void aaaa() {
    }

    @Then("bbb")
    public void bbb() {
    }
}
