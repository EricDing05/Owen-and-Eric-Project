package model.scraper;

import model.AbstractStore;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class SaveOnFoodsScraper extends WebsiteScraper {


    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        WebElement gridElement = driver.findElement(By.xpath(store.getGridPath()));
        List<WebElement> productElements = gridElement.findElements(By.xpath(store.getProductPath()));
        if (productElements.size() == 0) {
            throw new RuntimeException();
        }
        for (WebElement e : productElements) {
            printPrices(e, store);
        }
        System.out.println(store.getProducts().size());
    }

    // EFFECTS: takes a list of productElements and prints their prices
    public void printPrices(WebElement e, AbstractStore store) {
            String main = e.findElement(By.cssSelector("p.AriaProductTitleParagraph--1yc7f4f.jFsEKu")).getText();
            int i = main.lastIndexOf(',');
            String name = main.substring(0, i);
            String priceString = main.substring(i + 3, main.length());
            Double price = Double.parseDouble(priceString);
            String imgUrl = e.findElement(By.xpath(".//div[contains(@data-testid, 'productCardImage')]//img")).getAttribute("src");
            String description2 = e.findElement(By.xpath("(//p[contains(@class, 'AriaProductTitleParagraph')])[2]")).getText();
            store.addProduct(new Product(name, price, imgUrl, description2, "Save-on-Foods"));

    }


}
