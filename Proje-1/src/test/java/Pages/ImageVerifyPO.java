package Pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Driver;
import utils.Locators;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.List;

public class ImageVerifyPO extends ParentClass {

    public void gotoHomePage(){
        gotoSite(Locators.url);
    }
    public void verifyImage(){
        List<WebElement> images = ParentClass.driver.findElements(Locators.images);

        List<String> src = new ArrayList<>();

        for (WebElement image : images) {
            src.add(image.getAttribute("src"));
        }

        Assert.assertEquals(images.size(), src.size());
    }
    public void quit(){
        Driver.quitDriver();
    }
}
