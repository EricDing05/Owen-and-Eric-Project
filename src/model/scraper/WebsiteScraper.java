package model.scraper;

import model.AbstractStore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

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
                driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
                String currentPageURL = store.getNextURL(url,i); //TODO make this method
                System.out.println(currentPageURL);
                scrapePage(currentPageURL, store, driver);

                driver.quit();
            } catch (Exception e) {
                driver.quit();
                e.printStackTrace();
                return;
            }
        }
    }

    //EFFECTS: scrapes all the products of a given page
    public abstract void scrapePage(String url, AbstractStore store, WebDriver driver);

}
