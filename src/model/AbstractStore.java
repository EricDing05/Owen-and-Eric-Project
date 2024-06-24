package model;

import model.scraper.WebsiteScraper;

import java.util.*;

public abstract class AbstractStore {

    private String name;
    protected List<Product> products;
    protected Map<String, String> categoriesURLs;
    protected WebsiteScraper scraper;
    private String gridPath;
    private String productPath;
    private String infoPath;

    public AbstractStore(String name) {
        this.name = name;
        categoriesURLs = new HashMap<>();
        products = new ArrayList<>();
    }


    public abstract void initializeCategories();

    public void addProduct(Product p) {
        if (!products.contains(p)) { //TODO make a overriden equals for this
            products.add(p);
        }
    }

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

    public Map<String, String> getCategoriesURLs() {
        return categoriesURLs;
    }

    public void setCategoriesURLs(Map<String, String> categoriesURLs) {
        this.categoriesURLs = categoriesURLs;
    }
    public abstract void generateProducts();
    public abstract String getNextURL(String url, int i);

}
