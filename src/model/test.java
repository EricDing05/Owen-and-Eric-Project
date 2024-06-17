package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;


public class test {

    public static void main(String[] args) {

        WebDriver driver = new SafariDriver();

        try {

            driver.get("https://www.realcanadiansuperstore.ca/");

            System.out.println(driver.getTitle());

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

            extractProductInfo(driver);


        } catch (Exception e) {
            driver.quit();
            e.printStackTrace();
        }


    }

    public static void extractProductInfo(WebDriver driver) {
        // Find the product elements using data-testid attributes
        List<WebElement> products = driver.findElements(By.className("css-0"));
        System.out.println(products.size());

    }

}

