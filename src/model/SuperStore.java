package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class SuperStore {

    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.realcanadiansuperstore.ca/food/fruits-vegetables/fresh-vegetables/c/28195?navid=flyout-L3-Fresh-Vegetables");

//        WebElement priceContainer = driver.findElement(By.xpath("//p[@class='chakra-text css-o93gbd' and @data-testid='mop-regular-price']"));
//        WebElement priceElement = priceContainer.findElement(By.tagName("span"));
//        String priceText = priceElement.getText();
//        System.out.println("Price: " + priceText);


        //Super store vegetables
        WebElement gridElement = driver.findElement(By.xpath("//div[@data-testid='product-grid']"));

        List<WebElement> productTiles = gridElement.findElements(By.xpath(".//div[@data-testid='price-product-tile']"));

        //should wrap this for loop inside another loop that loops throuhg the page index based off the number of pages we can find
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
        // Close the browser
        driver.quit();
    }

}
