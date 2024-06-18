package model;

import java.util.*;

public abstract class AbstractStore {

    private String name;
    protected List<Product> products;


    public AbstractStore(String name) {
        this.name = name;
    }

    public void addProduct(Product p) {
        this.products.add(p);
    }

    public abstract void generateProducts();

}
