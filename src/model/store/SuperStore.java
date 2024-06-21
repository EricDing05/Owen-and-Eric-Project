package model.store;

import model.AbstractStore;
import model.scraper.SaveOnFoodsScraper;

public class SuperStore extends AbstractStore {

    // EFFECTS: Creates an instance of a store
    public SuperStore(String name) {
        super(name);
        initializeCategories();
        this.setGridPath("//div[@data-testid='product-grid']");
        this.setProductPath("//div[contains(@class, 'chakra-linkbox') and contains(@class, 'css-')]");
        scraper = new SaveOnFoodsScraper();
    }

    // EFFECTS: Generates/updates all products of this store
    public void generateProducts() {

    }

    // EFFECTS: returns the next page of a given URL
    public String getNextURL(String url, int i) {
        if (i == 1) {
            return url + "?page=2";
        } else {
            // If i > 1, we replace the current page number with i + 1
            return url.replaceAll("page=\\d+", "page=" + (i + 1));
        }
    }


    // i think super store just has an all page so we can use that. no need to add categories?
    // also note
    // EFFECTS: initializes all the categories and their URLs
    public void initializeCategories() {
        //the page with everything
        this.categoriesURLs.put("Food","https://www.realcanadiansuperstore.ca/food/c/27985");

        //fruits & veggies
//        this.categoriesURLs.put("Fruits", "https://www.realcanadiansuperstore.ca/food/fruits-vegetables/fresh-fruits/c/28194");
//        this.categoriesURLs.put("Vegetables","https://www.realcanadiansuperstore.ca/food/fruits-vegetables/fresh-vegetables/c/28195");
//        this.categoriesURLs.put("Packaged Salad & Dressing","https://www.realcanadiansuperstore.ca/food/fruits-vegetables/packaged-salad-dressing/c/28196");
//        this.categoriesURLs.put("Herbs","https://www.realcanadiansuperstore.ca/food/fruits-vegetables/herbs/c/28197");
//        this.categoriesURLs.put("Fresh Cut Fruits & Vegetables","https://www.realcanadiansuperstore.ca/food/fruits-vegetables/fresh-cut-fruits-vegetables/c/28198");
//        this.categoriesURLs.put("Dried Fruits & Nuts","https://www.realcanadiansuperstore.ca/food/fruits-vegetables/dried-fruits-nuts/c/28199");
//        this.categoriesURLs.put("Fresh Juice & Smoothies","https://www.realcanadiansuperstore.ca/food/fruits-vegetables/fresh-juice-smoothies/c/28200");
//        this.categoriesURLs.put("In-Store Salads","https://www.realcanadiansuperstore.ca/food/fruits-vegetables/in-store-salads/c/59222");
    }


    // https://www.realcanadiansuperstore.ca/food/c/27985
    // https://www.realcanadiansuperstore.ca/food/c/27985?page=2
    // https://www.realcanadiansuperstore.ca/food/c/27985?page=3
}
