package model.scraper;

import model.AbstractStore;
import model.scraper.Exceptions.NoMoreProductsException;
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
            scrapeCategory(url,store,j); //
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

            } catch (StaleElementReferenceException se) {
                driver.quit();
                scrapeCategory(url, store, i); // add a limit
            } catch (NoMoreProductsException ex) { // no such element exception, stale element exception
                driver.quit();
                ex.printStackTrace();
            } catch (Exception e) {
                driver.quit();
                e.printStackTrace();
            }
        }
    }

    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(2000));
        WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(store.getGridPath())));

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
