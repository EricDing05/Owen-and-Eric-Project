package model;

import model.scraper.WebsiteScraper;

import java.util.*;

public abstract class AbstractStore {

    private String name;
    protected List<Product> products;
    protected WebsiteScraper scraper;
    private String gridPath;
    private String productPath;
    private String infoPath;


    public AbstractStore(String name) {
        this.name = name;
    }

    public abstract void generateProducts();

}
