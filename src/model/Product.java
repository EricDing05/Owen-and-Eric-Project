package model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private String name;
    private double price;
    private boolean inStock;

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


    public List<Product> makeProducts(String ja) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootArray = mapper.readTree(ja);
            List<Product> products = new ArrayList<>();
            for (JsonNode node : rootArray) {
                String name = node.get("name").asText();
                System.out.println(name);
                double price = node.get("price").asDouble();
                boolean isOutOfStock = node.get("isOutOfStock").isBoolean(); //fix
                products.add(new Product(name, price, !inStock));
            }
            return products;
        } catch (Exception e) {
            //
        }
        return null;

    }
}
