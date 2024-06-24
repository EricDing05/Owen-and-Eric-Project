package model.scraper;

import model.AbstractStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class SaveOnFoodsScraper extends WebsiteScraper {


    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
            driver.get(url);
            // TODO: create a better waiting system
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
            findElements(driver);
            driver.quit();
    }


    //EFFECTS: Finds the product element of the website page
    private void findElements(WebDriver driver) {
        WebElement gridElement = driver.findElement(By.xpath("//*[@id=\"pageMain\"]/div[2]/div[1]/div/div[3]/div/section[1]/section[2]/div[3]"));
        List<WebElement> productElements = gridElement.findElements(By.xpath("//div[@class='ColListing--1fk1zey jGGReB']"));
        this.printPrices(productElements);
    }

    // EFFECTS: takes a list of productElements and prints their prices
    public void printPrices(List<WebElement> productElements) {
        for (WebElement e : productElements) {
            String price = e.findElement(By.cssSelector("p.AriaProductTitleParagraph--1yc7f4f.jFsEKu")).getText();
            System.out.println(price);
        }
    }


}
