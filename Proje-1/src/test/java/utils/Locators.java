package utils;

import org.openqa.selenium.By;

public interface Locators {

    String url = "https://brandstore.e-shopland.ch/";
    String user = " kursjava@gmail.com";
    String password = "kurs.java.123";

    // İmages
    By images = By.cssSelector("html img");

    //LoginPO
    By lLoginButton= By.xpath("//li[@id='menu-item-825']/a[1]/span[2]/span[1]");
    By lemailLogin = By.cssSelector("input#username");
    By lpasswordLogin = By.cssSelector("input#password");
    By lSubmitButton = By.cssSelector("div#customer_login p:nth-child(3) > button[type=\"submit\"]");
    By lVfyTextLogin = By.xpath("//strong[text()='kursjava'][1]");

    //Menu

    By allProductButton = By.xpath("(//i[contains(@class,'_mi _before')]/following-sibling::span)[2]");
    By allProductButton2 = By.cssSelector("main#main a.br_lgv_product_count_set.br_lgv_product_count.value_all");
    By allProductImage = By.xpath("//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']//img");
    By allProductList= By.cssSelector("div[class='ast-woocommerce-container'] ul li");

    // DropDown Menü

    By lDropDown = By.cssSelector("span#select2-product_cat-container > span");
    By selectMenü = By.cssSelector("span#select2-product_cat-container > span");
    By productInfo= By.xpath("div[class='astra-shop-summary-wrap']");
    By header= By.xpath("//h1[@class='woocommerce-products-header__title page-title']");


    // Sıralama Butonu

    By StarNum= By.cssSelector("div[class='ast-woocommerce-container'] ul li div[class='star-rating'] span ");


    // Favori Ürün
   By product2 = By.xpath("(//div[@data-original-product-id='375']//i)[2]");
    By favoriteProductButton = By.xpath("(//a[@data-original-product-id='375']//font)[2]");
    By lookFavoriteList = By.xpath("//div[@id='product-375']/div[2]/div[5]/div[1]/a[1]/font[1]/font[1]");
    By listProductName = By.cssSelector("tr#yith-wcwl-row-375 td.product-name > a");

}
