package model;

import java.util.*;

public abstract class AbstractStore {

    private String name;
    private String gridPath;
    private String infoPath;
    private String productPath;
    protected List<Product> products;

    public AbstractStore(String name) {
        this.name = name;
    }

    public abstract void scrapeStore();


}
