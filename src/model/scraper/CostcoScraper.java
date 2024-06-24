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

public class CostcoScraper extends WebsiteScraper {


    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {

        try {
            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(store.getGridPath())));
            List<WebElement> productHeads = gridElement.findElements(By.xpath(store.getProductPath()));

            for (WebElement productHead : productHeads) {
                createProduct(productHead, store);
            }
        } catch (Exception e){

        }

    }


    //EFFECTS: given the html product element, makes a product and adds it to a store
    public void createProduct(WebElement p, AbstractStore store) {
        //getting all the neccessary product fields
        String name = p.findElement(By.xpath(".//span[starts-with(@id, 'product_desc_') and contains(@class, 'description')]//a")).getText();
        String priceText = p.findElement(By.xpath(".//div[starts-with(@automation-id, 'itemPriceOutput_') and contains(@class, 'price')]")).getText();
        double price = Double.parseDouble(priceText.replace("$", "").trim());
        //the getAttribute is cuz the link is inside the hmtl tag
        String imgUrl = p.findElement(By.xpath(".//a[contains(@class, 'product-image-url')]")).getAttribute("href");
        String storeName = store.getName();

        // this complication is only needed b/c of the way costco stores its product description other stores should just be like above ^
        String description = "";
        List<WebElement> descriptionElements = p.findElements(By.xpath(".//ul[@class='product-features hidden-xs hidden-sm']//li"));
        if (!descriptionElements.isEmpty()) {
            StringBuilder descriptionBuilder = new StringBuilder();
            for (WebElement element : descriptionElements) {
                descriptionBuilder.append(element.getText()).append(", "); //could just append space or new line
            }
        }

        //make product and add it to store
        store.addProduct(new Product(name,price,imgUrl,description,storeName));

    }


}


