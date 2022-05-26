package pages;

import org.openqa.selenium.By;

public class Locators {
    public static final String url ="https://www.ikea.com/us/en/planners/";
    public static final By buildOwnDeskLink = By.xpath("//h2[text()='Design your own desk']");
    public static final By iframeConfig = By.cssSelector("iframe.planner-iframe");
    public static final By configurationMenu = By.cssSelector("div#configuration-menu");
    public static final By dimensionMenu=By.xpath("(//div[@class='menu-button'])[1]");
    public static final By dimensionLarge = By.xpath("//i[@title='Large']//parent::li");  //  //li[./i[@title='Large']]
    public static final By dimensionSmall = By.xpath("//li[./i[@title='Small']]");
    public static final By unitMenu=By.xpath("(//div[@class='menu-button'])[2]");
    public static final By unitUnits=By.xpath("//li[./i[@title='Units']]");
    public static final By totalPrice=By.cssSelector("div.TotalPrice__simple span.IKEA__price-amount");
    
}
