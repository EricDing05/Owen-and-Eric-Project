package model.scraper;

import model.AbstractStore;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class noFrillsScraper extends WebsiteScraper {



        public void scrapePage(String url, AbstractStore store, WebDriver driver)  {

                    driver.get(url);
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

                    // Wait until the page has finished loading
                    WebElement htmlElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("html")));
                    if (htmlElement == null) {
                        //throw new Exception("Page did not load correctly.");
                    }

                    // Wait for the grid element to be visible
                    WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(store.getGridPath())));
                    if (gridElement == null) {
                       // throw new Exception("Grid element not found.");
                    }

                    // Find product elements within the grid
                    List<WebElement> productHeads = gridElement.findElements(By.xpath(store.getProductPath()));
                    if (productHeads == null || productHeads.isEmpty()) {
                        //throw new Exception("No product elements found.");
                    }

                    for (WebElement productHead : productHeads) {
                        createProduct(productHead, store);
                    }
        }

    //EFFECTS: given the html product element, makes a product and adds it to store
    public void createProduct(WebElement p, AbstractStore store) {
        String name = p.findElement(By.xpath("//h3[contains(@class, 'chakra-heading') and contains(@class, 'css-')]\n")).getText();
        WebElement priceElement = p.findElement(By.xpath(".//span[@data-testid='sale-price' or @data-testid='regular-price']//span[contains(@class, 'css-')]\n"));
        String priceText = priceElement.getText().replace("$", "").replace("about", "").trim();
        double price = Double.parseDouble(priceText);

        String imgUrl = p.findElement(By.xpath(".//img[@alt]")).getAttribute("srcset");
        String description = "n/a"; //There's no description
        String storeName = store.getName();
        System.out.println(name);
        store.addProduct(new Product(name, price, imgUrl, description, storeName));
    }

    //TODO update price path, parameterize them,
}
