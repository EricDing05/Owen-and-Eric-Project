package model.scraper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.AbstractStore;
import model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class ThriftyScraper extends WebsiteScraper {


    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        WebElement gridElement = driver.findElement(By.xpath("//*[@id=\"body_0_main_1_ProductSearch_GroceryBrowsing_TemplateResult_SearchResultListView_MansoryPanel\"]/div"));
        List<WebElement> productElements = gridElement.findElements(By.xpath("//div[@class='item-product js-product js-equalized js-addtolist-container js-ga']"));
        if (productElements.size() == 0) {
            throw new RuntimeException();
        }
        for (WebElement e : productElements) {
            String dataProduct = e.getAttribute("data-product");
            parseJson(dataProduct, store);
        }
    }


    // EFFECTS: takes the JSON data from the website and parses it (currently just printing to console)
    public void parseJson(String input, AbstractStore store) {
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(input, JsonObject.class);
        String name = json.get("FullDisplayName").getAsString();
        Double price = json.get("RegularPrice").getAsDouble();
        String image = json.get("ProductImageUrl").getAsString();
        String storeName = "Thriftys";
        store.addProduct(new Product(name, price, image, "", storeName));
    }


}
