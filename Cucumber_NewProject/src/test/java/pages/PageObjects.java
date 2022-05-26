package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.ParentClass;

import java.util.List;

public class PageObjects extends ParentClass {

    public PageObjects() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "search")
    public WebElement searchFieldInput;

    @FindBy(css = "div.caption h4")
    public List<WebElement> searchedProducts;

    public void verifyTextinSearchedProducts(String text){
        for (WebElement product : searchedProducts) {
            Assert.assertTrue(product.getText().toLowerCase().contains(text.toLowerCase()));
        }
    }

    public void searchProduct(String text){
        sendKeysTo(searchFieldInput,text+ Keys.ENTER);


    }
    
}
