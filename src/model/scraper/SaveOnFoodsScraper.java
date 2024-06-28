package model.scraper;

import model.AbstractStore;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SaveOnFoodsScraper extends WebsiteScraper {



    // EFFECTS: takes a list of productElements and prints their prices
    public void scrapePage(WebElement e, AbstractStore store) {
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
