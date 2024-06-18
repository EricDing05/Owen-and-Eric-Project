package model.scraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SuperStoreScraper extends WebsiteScraper {


    public void scrapePage(String url, String gridPath, String productPath, String infoPath,WebDriver driver) {
        try {
            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(gridPath)));

            List<WebElement> productTitles = gridElement.findElements(By.xpath(productPath));

            for (WebElement productTitle : productTitles) {
                try {
                    WebElement priceElement = productTitle.findElement(By.xpath(".//span[contains(text(),'current')]"));
                    String priceText = priceElement.getText();
                    System.out.println("Price: " + priceText);
                } catch (Exception e) {
                    System.out.println("Price element not found in this product tile.");
                }
            }

        } catch (Exception ex) {
            System.out.println("An error occurred: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    public String getNextURL(String url, int i) {
        return ""; //TODO
    }

}
