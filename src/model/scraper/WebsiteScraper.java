package model.scraper;


import model.scraper.Exceptions.NoMoreProductsException;
import model.store.AbstractStore;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class WebsiteScraper {


    //EFFECTS: Scrapes all categories of a store
    public void scrapeWebsite(AbstractStore store) {
        for (String url : store.getCategoriesURLs().values()) {
            int j = 0;
            scrapeCategory(url, store, j); //
        }
    }

    //EFFECTS: Scrapes all pages of a given category
    public void scrapeCategory(String url, AbstractStore store, int j) {
        for (int i = j; i < 999; i++) {
            WebDriver driver = new SafariDriver();
            try {
                // temp removal    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000));
                String currentPageURL = store.getNextURL(url, i); //TODO make this method
                System.out.println(currentPageURL);
                scrapePage(currentPageURL, store, driver);
                driver.quit();
                store.save();
            } catch (StaleElementReferenceException se) {
                driver.quit();
                scrapeCategory(url, store, i);
            } catch (Exception e) {
                driver.quit();
                e.printStackTrace();
                return;
            }
        }
    }

    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(2000));
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(2500));
        WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(store.getGridPath())));

        List<WebElement> productElements = gridElement.findElements(By.xpath(store.getProductPath()));

        WebElement noResultsElement = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(store.getNoMoreProductsPath())));
        if (hasNoMoreProduct(store,noResultsElement)) {
            throw new NoMoreProductsException("No results found for the page: " + url);
        }

        for (WebElement e : productElements) {
            store.getScraper().createProduct(e, store);
        }
        System.out.println(store.getProducts().size());
    }

    public abstract void createProduct(WebElement e, AbstractStore store);

    public boolean hasNoMoreProduct(AbstractStore store, WebElement noResultsElement ) {
        return noResultsElement.getText().contains(store.getNoMoreProductsString());
    }

}


