package model.scraper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.store.AbstractStore;
import model.Product;
import org.openqa.selenium.WebElement;

public class ThriftyScraper extends WebsiteScraper {


    // EFFECTS: takes the JSON data from the website and parses it (currently just printing to console)
    public void createProduct(WebElement e, AbstractStore store) {
        String dataProduct = e.getAttribute("data-product");
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(dataProduct, JsonObject.class);
        String name = json.get("FullDisplayName").getAsString();
        Double price = json.get("RegularPrice").getAsDouble();
        String image = json.get("ProductImageUrl").getAsString();
        String storeName = "Thriftys";
        System.out.println(name);
        store.addProduct(new Product(name, price, image, "", storeName));
    }


}
