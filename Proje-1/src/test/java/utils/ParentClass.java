package utils;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParentClass {
    public static WebDriver driver;
    protected WebDriverWait wait;

    public ParentClass() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void gotoSite(String Url) {

        driver.get(Url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public void gotoHomepage(String homapageUrl) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(homapageUrl);
    }

    public void click(WebElement element) {
        //waitUntilClickable(element);// eleman clikable olana kadar bekle
        //scrollToElement(element); // eleman kadar scroll yap
        element.click();// click yap
    }
    public void click(By element) {

        driver.findElement(element).click();
    }

    public void sendKeys(WebElement element, String value) {
        waitUntilVisible(element);// elelman görünüt olana kadar bekle
        scrollToElement(element);// elemana kadar scroll yap
        element.clear();// eleman clear yap
        element.sendKeys(value);// value yi gönder
    }
    public void sendKeys(By element, String value) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);

    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public List<WebElement> listAllElement(List<WebElement> elementList) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }

    public WebElement waitFor(WebElement element, Conditions condition) {
        if (condition == Conditions.clickable) {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitFor(By locator, Conditions condition) {
        if (condition == Conditions.exist) {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public void verifyElementContainsText(WebElement element, String text) {

        wait.until(ExpectedConditions.textToBePresentInElement(element, text));

        System.out.println(element.getText());
        System.out.println(text);

        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void writeToExcel(String path, String sheetName, List<String> data) {

        File f = new File(path);


        if (!f.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook(); // RAMde yeni bir xlsx calisma sayfasi olusturuldu
            XSSFSheet sheet = workbook.createSheet(sheetName);  // excel icinde sayfa olusturuldu

            Row row = sheet.createRow(0);   // satirlar olusturuluyor
            for (int i = 0; i < data.size(); i++) {
                Cell cell = row.createCell(i);  // hücreler olusturuluyor
                cell.setCellValue(data.get(i));
            }

            FileOutputStream out = null;
            try {
                out = new FileOutputStream(path);
                workbook.write(out);
                workbook.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            FileInputStream input = null;
            Workbook workbook = null;
            Sheet sheet = null;

            try {
                input = new FileInputStream(path);
                workbook = WorkbookFactory.create(input);

                sheet = workbook.getSheet(sheetName);
                if (sheet == null)
                    sheet = workbook.createSheet(sheetName);
            }catch (IOException e){
                e.printStackTrace();
            }

            int numOfRows = sheet.getPhysicalNumberOfRows();

            Row row = sheet.createRow(numOfRows);
            for (int i = 0; i < data.size(); i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(data.get(i));
            }

            FileOutputStream output = null;
            try {
                input.close();
                output = new FileOutputStream(path);
                workbook.write(output);
                workbook.close();
                output.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }
    public static String getCurrentTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }
    @After
    public void scenarioStatus(Scenario scenario){
        if(scenario.isFailed()){

            writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx","sayfa1", new ArrayList<>(Arrays.asList(scenario.getName(),"Başarısız",getCurrentTime())));
        }
        else {
            writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx","sayfa1", new ArrayList<>(Arrays.asList(scenario.getName(),"BAŞARILI",getCurrentTime())));
        }

         writeToExcel("src/test/java/ExcelLog/ExcelLog.xlsx","sayfa1", new ArrayList<>(Arrays.asList(scenario.getName(),"BİTTİ",getCurrentTime())));


    }




}
