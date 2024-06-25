package model.scraper;

import model.AbstractStore;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class WalmartScraper extends WebsiteScraper {


    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        WebElement gridElement = driver.findElement(By.xpath(store.getGridPath()));
        List<WebElement> productElements = gridElement.findElements(By.xpath(store.getProductPath()));
        System.out.println(productElements.size());
        if (productElements.size() == 0) {
            throw new RuntimeException();
        }
        for (WebElement e : productElements) {
            createProduct(e, store);
        }
    }


    //EFFECTS: given the html product element, makes a product and adds it to store
    public void createProduct(WebElement p, AbstractStore store) {
        // Get the product name
        String name = p.findElement(By.xpath(".//a[@link-identifier and @href]/following-sibling::span")).getText();
        String imgUrl = p.findElement(By.xpath(".//img[@data-testid='productTileImage']")).getAttribute("src");

        String priceText = p.findElement(By.xpath(".//span[contains(text(), 'current price')]/../following-sibling::div")).getText();
        double price = convertPriceToDouble(priceText);

        String description = "n/a"; //There's no description
        String storeName = store.getName();
        store.addProduct(new Product(name, price, imgUrl, description, storeName));
    }

    public double convertPriceToDouble(String priceText) {
        priceText = priceText.replace("$", "").replace("¢", "").trim();
        double price = 0.0;

        if (priceText.contains("¢")) {
            price = Double.parseDouble(priceText) / 100;
        } else {
            price = Double.parseDouble(priceText);
        }

        return price;
    }



}

