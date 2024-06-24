package model.scraper;

import model.AbstractStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class WalmartScraper extends WebsiteScraper {


    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        WebElement gridElement = driver.findElement(By.xpath(store.getGridPath()));
        List<WebElement> productElements = gridElement.findElements(By.xpath(store.getProductPath()));
        System.out.println(productElements.size());
        if (productElements.size() == 0) {
            throw new RuntimeException();
        }
        for (WebElement e : productElements) {

        }
    }

//TODO maybe abstract more

    //EFFECTS: Scrapes all the products off the website page
//    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
//        try {
//            driver.get(url);
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//            WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(store.getGridPath())));
//
//            List<WebElement> productTitles = gridElement.findElements(By.xpath(store.getProductPath()));
//
//            for (WebElement productTitle : productTitles) {
//                try {
//                    WebElement priceElement = productTitle.findElement(By.xpath(".//span[contains(text(),'current')]"));
//                    String priceText = priceElement.getText();
//                    System.out.println("Price: " + priceText);
//                } catch (Exception e) {
//                    System.out.println("Price element not found in this product tile.");
//                }
//            }
//
//        } catch (Exception ex) {
//            System.out.println("An error occurred: " + ex.getMessage());
//            ex.printStackTrace();
//        } finally {
//            driver.quit();
//        }
//    }
//



}

