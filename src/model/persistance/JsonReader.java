package model.persistance;

import model.Product;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public List<Product> read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseProducts(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses game from JSON object and returns it
    private List<Product> parseProducts(JSONObject jsonObject) {
        ArrayList products = new ArrayList();
        JSONArray jsonArray = jsonObject.getJSONArray("products");
        for (Object json : jsonArray) {
            products.add(parseProduct((JSONObject) json));
        }
        return products;
    }

    // EFFECTS: parses product from JSONObject and returns it
    private Product parseProduct(JSONObject json) {
        Double price = json.getDouble("price");
        String name = json.getString("name");
        String imageUrl = json.getString("imageUrl");
        String description = json.getString("description");
        String storeName = json.getString("storeName");
        Product p = new Product(name, price, imageUrl, description, storeName);
        return p;
    }


}
