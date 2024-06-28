package model.scraper;

import model.AbstractStore;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WalmartScraper extends WebsiteScraper {



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

