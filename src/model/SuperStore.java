package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SuperStore {
    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();

        try {
            driver.get("https://www.realcanadiansuperstore.ca/food/fruits-vegetables/fresh-vegetables/c/28195?navid=flyout-L3-Fresh-Vegetables");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='product-grid']")));
            // Super store vegetables

            List<WebElement> productTiles = gridElement.findElements(By.xpath(".//div[@data-testid='price-product-tile']"));

            // should wrap this for loop inside another loop that loops through the page index based off the number of pages we can find
            for (WebElement productTile : productTiles) {
                try {
                    // Find the span element with data-testid="sale-price" or data-testid="regular-price" within the product tile
                    WebElement priceElement = productTile.findElement(By.xpath(".//span[@data-testid='sale-price' or @data-testid='regular-price']"));
                    String priceText = priceElement.getText();
                    System.out.println("Price: " + priceText);
                } catch (Exception e) {
                    System.out.println("Price element not found in this product tile.");
                }

                // Add a delay of 2 seconds (2000 milliseconds)
                try {
                    Thread.sleep(2000); // should make this random to avoid detection
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
