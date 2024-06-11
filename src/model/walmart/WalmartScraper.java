package model.walmart;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import model.Product;
import model.Scraper;

import java.util.ArrayList;
import java.util.List;

public class WalmartScraper extends Scraper {


    // EFFECTS: turns all the products in the JSONArray into product objects. Returns the list of objects.
    public List<Product> parseArray(JsonObject o) {
        List<Product> finishedProducts = new ArrayList<>();

        // Navigate through the complicated JSONObject to get to the JSONArray of products
        JsonArray products = o.getAsJsonObject("props").getAsJsonObject("pageProps").getAsJsonObject("initialData").getAsJsonObject("searchResult").getAsJsonArray("itemStacks").get(0).getAsJsonObject().getAsJsonArray("items");

        // iterate through the JSONArray and extract information
        for (int i = 0; i < products.size(); i++) {
            JsonObject product = products.get(i).getAsJsonObject();
            String name = product.get("name").getAsString();
            System.out.println(name);
            double price = product.get("price").getAsDouble();
            String image = product.getAsJsonObject("imageInfo").get("thumbnailUrl").getAsString();
            finishedProducts.add(new Product(name,price,true,image));
        }
        return finishedProducts;
    }
}





