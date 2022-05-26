package Pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Driver;
import utils.Locators;
import utils.ParentClass;

public class LoginPO extends ParentClass {

    public void gotoSite(){
        gotoSite(Locators.url);
    }

    public void clickToLoginButton(){
        click(Locators.lLoginButton);
    }

    public void enterEmail(){
        sendKeys(Locators.lemailLogin,Locators.user);
    }
    public void enterPassword(){
        sendKeys(Locators.lpasswordLogin,Locators.password);
    }
    public void clickToSubButton(){
        click(Locators.lSubmitButton);
    }
    public void verifyMeinKonto(){
        String text = driver.findElement(Locators.lVfyTextLogin).getText();
        Assert.assertTrue(text.contains("kursjava"));
    }
    public void quit(){
        Driver.quitDriver();
    }

}
