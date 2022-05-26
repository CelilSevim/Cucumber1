package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.ParentClass;

public class thyPO extends ParentClass {


    public void  thy (){

        gotoSite("https://www.turkishairlines.com/tr-tr/");

        WebElement e = driver.findElement(By.cssSelector("input#portInputTo"));
        click(e);




    }
}
