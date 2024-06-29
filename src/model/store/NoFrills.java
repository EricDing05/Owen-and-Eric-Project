package model.store;

import model.AbstractStore;
import model.scraper.noFrillsScraper;

public class NoFrills extends AbstractStore {

    // EFFECTS: Creates an instance of a store
    public NoFrills(String name) {
        super(name);
        initializeCategories();
        this.setGridPath("//div[@data-testid='product-grid']");
        this.setProductPath("//div[contains(@class, 'chakra-linkbox')]");
        this.scraper = new noFrillsScraper();
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
        this.categoriesURLs.put("Food", "https://www.nofrills.ca/food/c/27985");
    }


}
