package model.scraper;

import model.store.AbstractStore;
import model.scraper.Exceptions.NoMoreProductsException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;

public abstract class WebsiteScraper {


    //EFFECTS: Scrapes all categories of a store
    public void scrapeWebsite(AbstractStore store) {
        for (String url : store.getCategoriesURLs().values()) {
            scrapeCategory(url,store);
        }
    }

    //EFFECTS: Scrapes all pages of a given category
    public void scrapeCategory(String url, AbstractStore store) {
        for (int i = 0; i < 9999; i++) {
            WebDriver driver = new SafariDriver();
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
                String currentPageURL = store.getNextURL(url, i); //TODO make this method
                System.out.println(currentPageURL);
                scrapePage(currentPageURL, store, driver);
                driver.quit();
                store.save();

            } catch (StaleElementReferenceException ex) {
                // continue searching in hopes of finding more products after the stale element
                driver.quit();
                ex.printStackTrace();
            } catch (Exception e) {
                // otherwise, stop searching as we have reached the end
                driver.quit();
                e.printStackTrace();
                return; //
            }
        }
    }

    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        WebElement gridElement = driver.findElement(By.xpath(store.getGridPath()));
        List<WebElement> productElements = gridElement.findElements(By.xpath(store.getProductPath()));
        if (productElements.size() == 0) {
            throw new NoMoreProductsException();
        }
        for (WebElement e : productElements) {
            store.getScraper().createProduct(e, store);
        }
        System.out.println(store.getProducts().size());
    }


    public abstract void createProduct(WebElement e, AbstractStore store);



}
