package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.PageObjects;
import utils.Driver;

public class SearchStepdefs {

    PageObjects pageObj = new PageObjects();

    @Given("user goes to homepage")
    public void userGoesToHomepage() {
        pageObj.gotoHomePage();
    }

    @When("user search for {string}")
    public void userSearchFor(String text) {
        // pageObj.sendKeysTo(pageObj.searchFieldInput,text+ Keys.ENTER);
        pageObj.searchProduct(text);
    }

    @Then("product's name should contain {string}")
    public void productSNameShouldContain(String text) {
        System.out.println("");
        pageObj.verifyTextinSearchedProducts(text);
    }
}
