package model.scraper;

import model.AbstractStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class noFrillsScraper extends WebsiteScraper {


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
            String dataProduct = e.getAttribute("data-product");
        }
    }

    //EFFECTS: Scrapes all the products off the website page
//    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
//
//        try {
//            driver.get(url);
//
//            // these lines makes sure the page gets loaded before it scrapes, preventing "No Such Element Exception"
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//            WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(store.getGridPath())));
//            // Super store vegetables
//
//            List<WebElement> productTiles = gridElement.findElements(By.xpath(store.getProductPath()));
//
//            // should wrap this for loop inside another loop that loops through the page index based off the number of pages we can find
//            for (WebElement productTile : productTiles) {
//                try {
//                    // Find the span element with data-testid="sale-price" or data-testid="regular-price" within the product tile
//                    WebElement priceElement = productTile.findElement(By.xpath(".//span[@data-testid='sale-price' or @data-testid='regular-price']/span"));
//                    String priceText = priceElement.getText();
//                    System.out.println("Price: " + priceText);
//                } catch (Exception e) {
//                    System.out.println("Price element not found in this product tile.");
//                }
//
//                // Add a delay of 2 seconds (2000 milliseconds)
//                try {
//                    Thread.sleep(2000); // should make this random to avoid detection
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        } catch (Exception ex) {
//            System.out.println("An error occurred: " + ex.getMessage());
//            ex.printStackTrace();
//        } finally {
//            // Close the browser
//            driver.quit();
//        }
//    }
}
