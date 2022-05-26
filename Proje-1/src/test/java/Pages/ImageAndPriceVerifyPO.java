package Pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Driver;
import utils.Locators;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.List;

public class ImageAndPriceVerifyPO extends ParentClass {

    public void gotoHomePage(){
        gotoSite(Locators.url);
    }

    public void clickToAllproductBut(){
        click(Locators.allProductButton);
    }
    public void clickToall(){
        click(Locators.allProductButton2);
    }
    public void productImageVerify(){
        List<WebElement> allProductImage=new ArrayList<>();
        List<String> src = new ArrayList<>();
        allProductImage= driver.findElements(Locators.allProductImage);
        for (WebElement element : allProductImage) {
            src.add(element.getAttribute("src"));
        }
        Assert.assertEquals(src.size(),allProductImage.size());
    }
    public void productPriceInformation(){
        List<WebElement> ınf= new ArrayList<>();
        List<String> price = new ArrayList<>();
        ınf= driver.findElements(Locators.allProductList);
        for (WebElement element : ınf) {
            price.add(element.getText().replaceAll("[^0-9]", ""));
        }
        Assert.assertEquals(price.size(),ınf.size());
    }
    public void quit(){
        Driver.quitDriver();
    }
}
