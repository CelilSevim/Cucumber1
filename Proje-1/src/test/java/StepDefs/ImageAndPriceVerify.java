package StepDefs;

import Pages.ImageAndPriceVerifyPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Locators;

import java.util.ArrayList;
import java.util.Arrays;

import static utils.ParentClass.*;

public class ImageAndPriceVerify {

    ImageAndPriceVerifyPO ıp = new ImageAndPriceVerifyPO();

    @Given("go to site")
    public void goToSite() {
       ıp.gotoHomePage();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Siteye gidildi", getCurrentTime())));
    }

    @And("click to allproduct button")
    public void clickToAllproductButton() {
       ıp.clickToAllproductBut();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Tüm Ürünler Seçildi", getCurrentTime())));
    }

    @And("click to all button")
    public void clickToAllButton() {
        ıp.clickToall();
    }

    @When("get information of products")
    public void getInformationOfProducts() {
        ıp.productImageVerify();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Resimler Doğrulanıyor", getCurrentTime())));
    }

    @Then("verify the requested information")
    public void verifyTheRequestedInformation() throws InterruptedException {
        ıp.productPriceInformation();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Fiyat Bilgisinin Varlığı Doğrulanıyor", getCurrentTime())));
        Thread.sleep(3000);
        ıp.quit();
    }
}
