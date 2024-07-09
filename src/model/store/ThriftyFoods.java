package model.store;

import model.persistance.JsonReader;
import model.persistance.JsonWriter;
import model.scraper.ThriftyScraper;

public class ThriftyFoods extends AbstractStore  {


    // EFFECTS: Creates an instance of a store
    public ThriftyFoods(String name) {
        super(name);
        initializeCategories();
        this.scraper = new ThriftyScraper();
        this.setGridPath("//*[@id=\"body_0_main_1_ProductSearch_GroceryBrowsing_TemplateResult_SearchResultListView_MansoryPanel\"]/div");
        this.setProductPath("//div[@class='item-product js-product js-equalized js-addtolist-container js-ga']");
        jsonWriter = new JsonWriter(".idea/data/ThriftyFoods.json");
        this.jsonReader = new JsonReader(".idea/data/ThriftyFoods.json");
        products = readProducts();
        this.setNoMoreProductsPath("//a[contains(@class, 'icon--arrow-skinny-right') and contains(@title, 'Next Page')]"); //TODO
        this.setNoMoreProductsString(""); //TODO
    }

    // EFFECTS: Generates/updates all products of this store
    public void generateProducts() {
        this.scraper.scrapeWebsite(this);
    }

    // EFFECTS: returns the next page of a given URL
    public String getNextURL(String url, int i) {
            return url + "?page=" + (i + 1) + "&pageSize=80";
    }

    // EFFECTS: initializes all the categories and their URLs
    public void initializeCategories() {
        this.categoriesURLs.put("BAKERY (COMMERCIAL)","https://www.thriftyfoods.com/shop-online/bakery-commercial");
        this.categoriesURLs.put("BAKERY (INSTORE)","https://www.thriftyfoods.com/shop-online/bakery-instore");
        this.categoriesURLs.put("BULK FOODS","https://www.thriftyfoods.com/shop-online/bulk-foods");
        // this.categoriesURLs.put("DELI","https://www.thriftyfoods.com/shop-online/deli");
        this.categoriesURLs.put("FLORAL","https://www.thriftyfoods.com/shop-online/floral");

        this.categoriesURLs.put("FROZEN","https://www.thriftyfoods.com/shop-online/frozen");
        this.categoriesURLs.put("GENERAL MERCHANDISE","https://www.thriftyfoods.com/shop-online/general-merchandise");
        this.categoriesURLs.put("GROCERY","https://www.thriftyfoods.com/shop-online/grocery");
        this.categoriesURLs.put("MEAT","https://www.thriftyfoods.com/shop-online/meat");
        this.categoriesURLs.put("PRODUCE","https://www.thriftyfoods.com/shop-online/produce");

        this.categoriesURLs.put("REFRIGERATED GROCERY","https://www.thriftyfoods.com/shop-online/refrigerated-grocery");
        this.categoriesURLs.put("SEAFOOD","https://www.thriftyfoods.com/shop-online/seafood");
        this.categoriesURLs.put("SUSHI","https://www.thriftyfoods.com/shop-online/sushi");
        this.categoriesURLs.put("TAKE IT TO GO","https://www.thriftyfoods.com/shop-online/take-it-to-go");
        this.categoriesURLs.put("VITAMINS & MORE","https://www.thriftyfoods.com/shop-online/vitamins-and-more");
    }


    //https://www.thriftyfoods.com/shop-online/bakery-commercial
    //https://www.thriftyfoods.com/shop-online/bakery-commercial?page=2&pageSize=20
    //https://www.thriftyfoods.com/shop-online/bakery-commercial?page=3&pageSize=20

}
