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

public class noFrillsScraper extends WebsiteScraper {



    @Override
    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(2000));
        WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-testid='product-grid']")));

        List<WebElement> productElements = gridElement.findElements(By.cssSelector("div[data-testid='product-grid'] > div.css-0\n"));
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
        // String name = p.findElement(By.xpath("//h3[@data-testid='product-title' and contains(@class, 'chakra-heading')]\n")).getText();

        String name = p.findElement(By.cssSelector("h3[data-testid='product-title']")).getText();
        WebElement priceElement = p.findElement(By.xpath(".//span[@data-testid='sale-price' or @data-testid='regular-price']//span[contains(@class, 'css-')]\n"));
        String priceText = priceElement.getText().replace("$", "").replace("about", "").trim();
        double price = Double.parseDouble(priceText);

        String imgUrl = p.findElement(By.cssSelector("div[data-testid='product-image'] img")).getAttribute("src");

        String description = "n/a"; //There's no description
        String storeName = store.getName();
        System.out.println(name);
        store.addProduct(new Product(name, price, imgUrl, description, storeName));
    }

}
