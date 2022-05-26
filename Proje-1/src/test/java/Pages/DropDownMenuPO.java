package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Driver;
import utils.Locators;
import utils.ParentClass;

import java.util.List;
import java.util.Random;

public class DropDownMenuPO extends ParentClass {

    public void selectDropDownRandom(){
        int sayi = (int)(Math.random()*10);

       WebElement e = driver.findElement(By.cssSelector("#product_cat"));
        Select select = new Select(e);

        select.selectByIndex(sayi);
    }
    public void selectedProductVerifyInfo(){
        List<WebElement> productInfo = driver.findElements(Locators.productInfo);
        WebElement e = driver.findElement(Locators.header);
        String text = e.getText();
        for (WebElement element : productInfo) {
            Assert.assertTrue(element.getText().contains(text));
        }


    }
    public void quit(){
        Driver.quitDriver();
    }

}
