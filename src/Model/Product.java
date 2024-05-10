package Model;

import com.google.gson.Gson;

public class Product {

    private String name;
    private double price;
    private Type type;
    private boolean inStock;

    public Product(String name, double price, Type type, boolean inStock) {
        this.name = name;
        this.price = price;
        this.type = type;
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

    public void setType(Type type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }

    public Gson toGson() {
        return null;
    }

    public Product readGson() {
        return null;
    }






}
