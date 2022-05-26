package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParentClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public ParentClass() {

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    public void gotoHomePage(){
        driver.get("https://opencart.abstracta.us/");
    }


    public void clickTo(By locater) {
        wait.until(ExpectedConditions.elementToBeClickable(locater)).click();
    }

    public void clickTo(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeysTo(By locater, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
        element.clear();
        element.sendKeys(text);
    }

    public void sendKeysTo(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }

    public WebElement waitFor(WebElement element, WaitConditions condition) {
        switch (condition) {
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(element));

            default:
                return wait.until(ExpectedConditions.visibilityOf(element));
        }

    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }


}
