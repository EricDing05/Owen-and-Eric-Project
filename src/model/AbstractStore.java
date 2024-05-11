package model;

import java.util.*;

public abstract class AbstractStore {

    private String name;
    protected List<Product> products;
    protected Scraper scraper;

    public AbstractStore(String name) {
        this.name = name;
    }

    public void addProduct(Product p) {
        this.products.add(p);
    }

    public abstract void generateProducts();

}
