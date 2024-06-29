package model.store;

import model.AbstractStore;
import model.scraper.SuperStoreScraper;

public class SuperStore extends AbstractStore {

    // EFFECTS: Creates an instance of a store
    public SuperStore(String name) {
        super(name);
        initializeCategories();
        this.setGridPath("//div[@data-testid='product-grid']");
        this.setProductPath("//div[@class='css-0]");
        scraper = new SuperStoreScraper();
    }

    // EFFECTS: Generates/updates all products of this store
    public void generateProducts() {
        this.scraper.scrapeWebsite(this);
    }

    // EFFECTS: returns the next page of a given URL
    public String getNextURL(String url, int i) {
        return url + "?page=" + (i + 1); //this
    }

    // EFFECTS: initializes all the categories and their URLs
    public void initializeCategories() {
        //the page with everything
        this.categoriesURLs.put("Food","https://www.realcanadiansuperstore.ca/food/c/27985");
    }

}
