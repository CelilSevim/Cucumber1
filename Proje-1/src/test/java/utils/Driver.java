package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Collections;

import static utils.Browser.CHROME;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    public static ThreadLocal<Browser> browsers = new ThreadLocal<>();


    public static WebDriver getDriver() {
        return getDriver(CHROME);
    }

    public static WebDriver getDriver(Browser browser) {

        if (browsers.get() == null) {
            browsers.set(browser);
        }

        if (drivers.get() == null) {
            switch (browser) {
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                case IE:
                    WebDriverManager.iedriver().setup();
                    drivers.set(new InternetExplorerDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("useAutomationExtension", false);
                    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                    drivers.set(new ChromeDriver(options));


                    drivers.get().manage().deleteAllCookies();
                    break;
            }
        }
        return drivers.get();
    }

    public static void quitDriver() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.set(null);
        }
    }

    public static Browser getBrowser() {
        return browsers.get();
    }

    public static void setBrowser(Browser browser) {
        browsers.set(browser);
    }

}
