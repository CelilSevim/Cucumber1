package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Driver;
import utils.Locators;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SortingProsessPO extends ParentClass {

    public void gotoSite(){
        gotoSite(Locators.url);
    }
    public void allProduct(){
        click(Locators.allProductButton);
    }
    public void allProduct_2(){
        click(Locators.allProductButton2);
    }
    public void selectToByAverage(){
        WebElement element = driver.findElement(By.cssSelector("main#main select"));
        Select select = new Select(element);
        select.selectByValue("rating");

        List<WebElement> list = driver.findElements(Locators.StarNum);
        List<Integer> numList = new ArrayList<>();

        for (WebElement webElement : list) {
           String num= webElement.getAttribute("style").replaceAll("[^0-9]", "");
            System.out.println(num);
            int a = Integer.parseInt(num);
            numList.add(a);
        }
        for (int i = 0; i < list.size() ; i++) {
            Assert.assertTrue(numList.get(0)>=numList.get(i));
        }
    }
    public void quit(){
        Driver.quitDriver();
    }

}
