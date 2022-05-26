package StepDefs;

import Pages.FavoriteProductPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;

import static utils.ParentClass.getCurrentTime;
import static utils.ParentClass.writeToExcel;

public class FavoriteProduct {
    FavoriteProductPO fp = new FavoriteProductPO();
    @Given("go to site favorite")
    public void goToSiteFavorite() {
        fp.gotoSite();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Siteye gidildi", getCurrentTime())));
    }

    @And("click to allproduct button favorite")
    public void clickToAllproductButtonFavorite() {
        fp.allProduct();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Ürünler Listelendi", getCurrentTime())));
    }

    @And("click to all button favorite")
    public void clickToAllButtonFavorite() {

        fp.allProduct_2();
    }

    @When("Pick a random product")
    public void pickARandomProduct() throws InterruptedException {
        fp.randomProduct();
    }

    @And("add product to favorites")
    public void addProductToFavorites() {
        fp.addFavoriteList();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Ürün Favori Listesine Eklendi", getCurrentTime())));
    }

    @Then("check if the product is in the favorite list")
    public void checkIfTheProductIsInTheFavoriteList() throws InterruptedException {
        fp.verify();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Ürün Kontrol Edildi", getCurrentTime())));
        Thread.sleep(3000);
        fp.quit();
    }
}
