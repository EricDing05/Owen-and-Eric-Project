package model;

import model.store.WebsiteScraper;

import java.util.*;

public abstract class AbstractStore {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public WebsiteScraper getScraper() {
        return scraper;
    }

    public void setScraper(WebsiteScraper scraper) {
        this.scraper = scraper;
    }

    public String getGridPath() {
        return gridPath;
    }

    public void setGridPath(String gridPath) {
        this.gridPath = gridPath;
    }

    public String getProductPath() {
        return productPath;
    }

    public void setProductPath(String productPath) {
        this.productPath = productPath;
    }

    public String getInfoPath() {
        return infoPath;
    }

    public void setInfoPath(String infoPath) {
        this.infoPath = infoPath;
    }

    private String name;
    protected List<Product> products;
    protected List<String> categories;
    protected WebsiteScraper scraper;
    private String gridPath;
    private String productPath;
    private String infoPath;



    public AbstractStore(String name) {
        this.name = name;
    }

    public abstract void generateProducts();

}
