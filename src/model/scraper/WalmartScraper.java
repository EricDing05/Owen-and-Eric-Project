package model.scraper;

import model.AbstractStore;
import model.Product;
import model.scraper.Exceptions.NoMoreProductsException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WalmartScraper extends WebsiteScraper {



    @Override
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(2000));
        WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(store.getGridPath())));

        List<WebElement> productElements = gridElement.findElements(By.xpath(store.getProductPath()));
        if (productElements.size() == 0) {
            throw new NoMoreProductsException();
        }
        for (WebElement e : productElements) {
            store.getScraper().createProduct(e, store);
        }
        System.out.println(store.getProducts().size());
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
        System.out.println(name);
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

