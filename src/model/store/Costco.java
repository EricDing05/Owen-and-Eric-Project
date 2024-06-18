package model.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Costco {

    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();

        try {
            driver.get("https://www.costco.ca/meat.html");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@automation-id='productList']")));
            // Super store vegetables

            List<WebElement> productTitles = gridElement.findElements(By.xpath("//div[contains(@automation-id, 'itemPriceOutput')]"));

            // should wrap this for loop inside another loop that loops through the page index based off the number of pages we can find
            for (WebElement productTitle : productTitles) {
                try {
                    String priceText = productTitle.getText().trim();
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


