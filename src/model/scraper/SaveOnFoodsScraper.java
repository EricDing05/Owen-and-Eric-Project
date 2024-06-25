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

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
            // connect to saveonfoods website
            driver.get(url);
            // wait 5 seconds to allow the website to fully load
            // TODO: create a better waiting system
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
            findElements(driver, store);
            driver.quit();
    }


    //EFFECTS: Finds the product element of the website page
    private void findElements(WebDriver driver, AbstractStore store) {
        // Use the xPath of the gridElement to locate and get it
        WebElement gridElement = driver.findElement(By.xpath("//*[@id=\"pageMain\"]/div[2]/div[1]/div/div[3]/div/section[1]/section[2]/div[3]"));
        // Within the gridElement, take get all the productElements
        List<WebElement> productElements = gridElement.findElements(By.xpath("//div[@class='ColListing--1fk1zey jGGReB']"));
        if (productElements.size() == 0) {
            throw new RuntimeException();
        }
        // Within productElements, find the prices and print them to the console
        this.printPrices(productElements, store);
    }

    // EFFECTS: takes a list of productElements and prints their prices
    public void printPrices(List<WebElement> productElements, AbstractStore store) {
        for (WebElement e : productElements) {
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


}
