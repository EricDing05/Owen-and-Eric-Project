package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.List;

public class ThriftyScraper {


    public void scrape() {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.thriftyfoods.com/shop-online/grocery?page=1&pageSize=200");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        WebElement gridElement = driver.findElement(By.xpath("//*[@id=\"body_0_main_1_ProductSearch_GroceryBrowsing_TemplateResult_SearchResultListView_MansoryPanel\"]/div"));
        List<WebElement> productElements = gridElement.findElements(By.xpath("//div[@class='product-tile push--bottom grid__item slim palm--one-half portable--two-quarters desk--one-quarter']"));

    }
}
