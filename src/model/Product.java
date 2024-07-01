package model;


import org.json.JSONObject;

public class Product {

    private String name;
    private double price;
    private String imageUrl;
    private String description;
    private String storeName;

    //EFFECTS: Creates an instance of a Product
    public Product(String name, double price, String imageUrl, String description, String storeName) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
        this.storeName = storeName;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getStoreName() {
        return storeName;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("price", this.price);
        json.put("name", this.name);
        json.put("imageUrl", this.imageUrl);
        json.put("description", this.description);
        json.put("storeName", this.storeName);
        return json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (!getName().equals(product.getName())) return false;
        if (!getImageUrl().equals(product.getImageUrl())) return false;
        if (!getDescription().equals(product.getDescription())) return false;
        return getStoreName().equals(product.getStoreName());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName().hashCode();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getImageUrl().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getStoreName().hashCode();
        return result;
    }
}
