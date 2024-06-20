package model.store;

import model.AbstractStore;
import model.scraper.ThriftyScraper;

public class ThriftyFoods extends AbstractStore  {


    //list categories and urls
    public ThriftyFoods(String name) {
        super(name);
        initializeCategories();
        this.setGridPath("//div[contains(@class, 'grid ')]");
        this.setProductPath("//div[@class='item-product']");
        scraper = new ThriftyScraper();
    }

    public void generateProducts() {

    }


    public String getNextURL(String url, int i) {
        if (i == 1) {
            return url + "?page=2&pageSize=20";
        } else {
            // If i > 1, we replace the current page number with i + 1
            return url.replaceAll("page=\\d+", "page=" + (i + 1));
        }
    }

    public void initializeCategories() {
        this.categoriesURLs.put("BAKERY (COMMERCIAL)","https://www.thriftyfoods.com/shop-online/bakery-commercial");
        this.categoriesURLs.put("BAKERY (INSTORE)","https://www.thriftyfoods.com/shop-online/bakery-instore");
        this.categoriesURLs.put("BULK FOODS","https://www.thriftyfoods.com/shop-online/bulk-foods");
        this.categoriesURLs.put("DELI","https://www.thriftyfoods.com/shop-online/deli");
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
