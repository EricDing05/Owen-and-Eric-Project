package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;


public class test {

    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();

        // driver.get("https://www.walmart.ca/en/ip/strawberries/871284"); // single item test
        // WebElement priceElement = driver.findElement(By.cssSelector("span[itemprop='price']")); // goes with that ^
        driver.get("https://www.walmart.ca/en/browse/grocery/fruits-vegetables/fresh-fruits/10019_6000194327370_6000194327411?icid=cp_l2_page_grocery_fresh_fruits_22956_QV0B69TN6Z"); // multiple items on a page
        //WebElement priceElement = driver.findElement(By.cssSelector("div[data-automation-id='product-price'] .mr1.mr2-xl.b.black.lh-copy.f5.f4-l"));

        //this gets all the product prices on a given walmart grocery item page.
        List<WebElement> priceElements = driver.findElements(By.cssSelector("div[data-automation-id='product-price'] .mr1.mr2-xl.b.black.lh-copy.f5.f4-l"));

        //just prints the price (can edit so prints out name and stuff)
        for (WebElement priceElement : priceElements) {
            String price = priceElement.getText();
            System.out.println("Price: " + price);
        }



        // Close the browser
        driver.quit();

    }

}

