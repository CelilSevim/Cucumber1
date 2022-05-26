package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Driver;
import utils.Locators;
import utils.ParentClass;

import java.util.List;

public class FavoriteProductPO extends ParentClass {
    String namePro;
    String text;

    public void gotoSite(){
        gotoSite(Locators.url);
    }
    public void allProduct(){
        click(Locators.allProductButton);
    }
    public void allProduct_2(){
        click(Locators.allProductButton2);
    }

    public void randomProduct() throws InterruptedException {
       Thread.sleep(3000);
        WebElement e = driver.findElement(By.cssSelector("main#main li:nth-child(1) > div.astra-shop-summary-wrap > a.ast-loop-product__link > h2"));
        Thread.sleep(4000);
        click(e);
        Thread.sleep(4000);

        WebElement e1 = driver.findElement(By.cssSelector("main#main div.summary.entry-summary > div.yith-wcwl-add-to-wishlist.wishlist-fragment.on-first-load > div > a > span"));
        Thread.sleep(2000);
        click(e1);
        Thread.sleep(7000);
        WebElement e2 = driver.findElement(By.cssSelector("main#main div.yith-wcwl-add-to-wishlist.exists.wishlist-fragment.on-first-load > div > a"));
        Thread.sleep(3000);
        click(e2);

    }

    public void addFavoriteList() {
    }

    public void verify() {
        WebElement e3 = driver.findElement(By.cssSelector("form#yith-wcwl-form td.product-name > a"));
        String name = e3.getText();
        Assert.assertTrue(name.contains("DNK Buddha Bracelet (Second Hand)"));

    }

    public void quit() {
        Driver.quitDriver();
    }
}
