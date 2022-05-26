package StepDefs;


import Pages.ImageVerifyPO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Locators;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static utils.ParentClass.getCurrentTime;
import static utils.ParentClass.writeToExcel;

public class ImageVerify {
    ImageVerifyPO po = new ImageVerifyPO();


    @Given("Go to the site")
    public void goToTheSite() {

        po.gotoHomePage();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Siteye gidildi", getCurrentTime())));
    }


    @Then("Verify Images on the site")
    public void verifyImagesOnTheSite() throws InterruptedException {
        po.verifyImage();
        writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx", "sayfa1", new ArrayList<>(Arrays.asList("", "Resimler Doğrulanıyor", getCurrentTime())));
        Thread.sleep(2000);
        po.quit();
    }



}
