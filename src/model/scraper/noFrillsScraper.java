package model.scraper;

import model.AbstractStore;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class noFrillsScraper extends WebsiteScraper {


    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(store.getGridPath())));
            List<WebElement> productHeads = gridElement.findElements(By.xpath(store.getProductPath()));
            for (WebElement productHead : productHeads) {
                createProduct(productHead, store);
            }
    }


    //EFFECTS: given the html product element, makes a product and adds it to store
    public void createProduct(WebElement p, AbstractStore store) {
        String altText = p.findElement(By.xpath(".//img[@alt]")).getAttribute("alt");
        String name = altText.split(",")[0];
        String priceText = p.findElement(By.xpath(".//span[@data-testid='sale-price']//span[@class='css-idkz9h']")).getText();
        double price = Double.parseDouble(priceText.replace("$", "").trim());
        String imgUrl = p.findElement(By.xpath(".//img[@alt]")).getAttribute("src");
        String description = "n/a"; //There's no description
        String storeName = store.getName();
        store.addProduct(new Product(name, price, imgUrl, description, storeName));
    }
}
