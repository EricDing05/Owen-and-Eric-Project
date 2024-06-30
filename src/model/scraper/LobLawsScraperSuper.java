package model.scraper;


import model.Product;
import model.store.AbstractStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class LobLawsScraperSuper extends WebsiteScraper {

    @Override
    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(1500));
        List<WebElement> productElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.css-f5i5wc")));

        for (WebElement e : productElements) {
            try {
                store.getScraper().createProduct(e, store);
            } catch (NoSuchElementException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(store.getProducts().size());
    }


    //EFFECTS: given the html product element, makes a product and adds it to store
    public void createProduct(WebElement p, AbstractStore store) {

        String name = p.findElement(By.cssSelector("h3[data-testid='product-title']")).getText();
        WebElement priceElement = p.findElement(By.xpath(".//span[@data-testid='sale-price' or @data-testid='regular-price']//span[contains(@class, 'css-')]\n"));
        String priceText = priceElement.getText().replace("$", "").replace("about", "").trim();
        double price = formatPrice(priceText);

        String imgUrl = p.findElement(By.cssSelector("div[data-testid='product-image'] img")).getAttribute("src");

        String description = "n/a"; //There's no description
        String storeName = store.getName();
        System.out.println(name);
        store.addProduct(new Product(name, price, imgUrl, description, storeName));
    }

    public static double formatPrice(String priceText) {
        priceText = priceText.replace("$", "").replace("about", "").trim();
        if (priceText.contains("FOR")) {
            String[] parts = priceText.split("FOR");
            if (parts.length == 2) {
                int quantity = Integer.parseInt(parts[0].trim());
                double totalPrice = Double.parseDouble(parts[1].trim());
                return totalPrice / quantity;
            }
        }
        if (priceText.contains("MIN")) {
            priceText = priceText.split("MIN")[0].trim();
        }
        return Double.parseDouble(priceText);
    }
}
