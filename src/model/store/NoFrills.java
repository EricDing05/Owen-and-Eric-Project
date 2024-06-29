package model.store;

import model.scraper.noFrillsScraper;

public class NoFrills extends LobLawsSuper {

    // EFFECTS: Creates an instance of a store
    public NoFrills(String name) {
        super(name);
        initializeCategories();
        this.setGridPath("//div[@data-testid='product-grid']");
        this.setProductPath("//div[contains(@class, 'chakra-linkbox')]");
        this.scraper = new noFrillsScraper();
    }



    // EFFECTS: initializes all the categories and their URLs
    public void initializeCategories() {
        this.categoriesURLs.put("Food", "https://www.nofrills.ca/food/c/27985");
    }


}
