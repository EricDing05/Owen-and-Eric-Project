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
            // connect to saveonfoods website
            driver.get(url);
            // wait 5 seconds to allow the website to fully load
            // TODO: create a better waiting system
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
            findElements(driver);
            driver.quit();
    }


    //EFFECTS: Finds the product element of the website page
    private void findElements(WebDriver driver) {
        // Use the xPath of the gridElement to locate and get it
        WebElement gridElement = driver.findElement(By.xpath("//*[@id=\"pageMain\"]/div[2]/div[1]/div/div[3]/div/section[1]/section[2]/div[3]"));
        // Within the gridElement, take get all the productElements
        List<WebElement> productElements = gridElement.findElements(By.xpath("//div[@class='ColListing--1fk1zey jGGReB']"));
        if (productElements.size() == 0) {
            throw new RuntimeException();
        }
        // Within productElements, find the prices and print them to the console
        this.printPrices(productElements);
    }

    // EFFECTS: takes a list of productElements and prints their prices
    public void printPrices(List<WebElement> productElements) {
        for (WebElement e : productElements) {
            String main = e.findElement(By.cssSelector("p.AriaProductTitleParagraph--1yc7f4f.jFsEKu")).getText();
            int i = main.indexOf(",");
            String description = main.substring(0, i);
            String price = main.substring(i + 2, main.length());
            System.out.println(price);
            System.out.println(description);

            String imgUrl = e.findElement(By.xpath(".//div[contains(@data-testid, 'productCardImage')]//img")).getAttribute("src");
            String description2 = e.findElement(By.xpath("(//p[contains(@class, 'AriaProductTitleParagraph')])[2]")).getText();
            System.out.println(description2);
            System.out.println(imgUrl);
        }
    }


}
