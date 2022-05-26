package StepDefs;

import Pages.LoginPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;

import static utils.ParentClass.getCurrentTime;
import static utils.ParentClass.writeToExcel;

public class Logindefs {

    LoginPO lp = new LoginPO();

    @Given("Go to site")
    public void goToSite() {
        lp.gotoSite();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Siteye gidildi", getCurrentTime())));
    }

    @And("click to login button")
    public void clickToLoginButton() {
        lp.clickToLoginButton();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "login butonuna tıklandı", getCurrentTime())));

    }

    @When("enter usurnsme")
    public void enterUsurnsme() {
        lp.enterEmail();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "email girildi", getCurrentTime())));
    }

    @And("enter password")
    public void enterPassword() {
        lp.enterPassword();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "password girildi", getCurrentTime())));
    }

    @And("click to submit button")
    public void clickToSubmitButton() {
        lp.clickToSubButton();
    }

    @Then("Verify that Mein Konto appears")
    public void verifyThatMeinKontoAppears() throws InterruptedException {
        lp.verifyMeinKonto();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "işlem doğrulandı", getCurrentTime())));
        Thread.sleep(2000);
        lp.quit();
    }
}
