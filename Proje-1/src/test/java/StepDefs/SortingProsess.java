package StepDefs;

import Pages.SortingProsessPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;

import static utils.ParentClass.getCurrentTime;
import static utils.ParentClass.writeToExcel;

public class SortingProsess {

    SortingProsessPO sp = new SortingProsessPO();

    @Given("go to site_sort")
    public void goToSite_sort() {
        sp.gotoSite();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Siteye gidildi", getCurrentTime())));
    }

    @And("click to allproduct button_sort")
    public void clickToAllproductButton_sort() {
        sp.allProduct();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Tüm Ürünler Seçildi", getCurrentTime())));
    }

    @And("click to all button_sort")
    public void clickToAllButton_sort() {
        sp.allProduct_2();
    }

    @When("select to by average")
    public void selectToByAverage() {
        sp.selectToByAverage();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Ürünler Rating Sıralaması Yapıldı ", getCurrentTime())));
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Kontrol İşlemi Yapıldı", getCurrentTime())));
    }

    @Then("check that the order is correct")
    public void checkThatTheOrderIsCorrect() {
       sp.quit();
    }
}
