package StepDefs;

import Pages.DropDownMenuPO;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.ParentClass.getCurrentTime;
import static utils.ParentClass.writeToExcel;

public class DropDownMenu {

    DropDownMenuPO dd = new DropDownMenuPO();

    @When("make a random selection from the menu")
    public void makeARandomSelectionFromTheMenu() {
        dd.selectDropDownRandom();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Rastgele Bir Menü Seçildi", getCurrentTime())));
    }


    @Then("check if the products match the criteria you selected")
    public void checkIfTheProductsMatchTheCriteriaYouSelected() throws InterruptedException {
        dd.selectedProductVerifyInfo();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Seçilen Menüdeki Ürünler Kontrol Ediliyor", getCurrentTime())));
        Thread.sleep(4000);
        dd.quit();
    }
}
