package model.store;

import model.persistance.Writer;
import model.scraper.WalmartScraper;

public class Walmart extends AbstractStore {

    // EFFECTS: Creates an instance of a store
    public Walmart(String name) {
        super(name);
        this.scraper = new WalmartScraper();
        initializeCategories();
        this.setGridPath("//div[@data-testid='product-grid']");
        this.setProductPath(".//div[contains(@data-item-id, '')]");
        this.writer = new Writer(".idea/data/Walmart.json");
    }

    // EFFECTS: Generates/updates all products of this store
    public void generateProducts() {
        this.scraper.scrapeWebsite(this);
    }

    // EFFECTS: returns the next page of a given URL
    public String getNextURL(String url, int i) {
        if (i == 0) {
            return url;
        } else {
            return url + "&page=" + (i + 1);
        }
    }

    // EFFECTS: initializes all the categories and their URLs
    public void initializeCategories() {

        this.categoriesURLs.put("Fresh produce","https://www.walmart.ca/en/browse/grocery/fruits-vegetables/10019_6000194327370?icid=cp_l2_page_grocery_shop_all_22967_EMNZA1CAH7");
        this.categoriesURLs.put("Fresh dairy products & eggs","https://www.walmart.ca/en/browse/grocery/dairy-eggs/10019_6000194327369?icid=landing/cp_page_grocery_shop_all_15500_TDP1IRI294");
        this.categoriesURLs.put("Fresh meat, seafood & alternatives","https://www.walmart.ca/en/browse/grocery/meat-seafood-alternatives/10019_6000194327357?icid=landing/cp_page_grocery_shop_all_16999_MPQB559PFG");
        this.categoriesURLs.put("Pantry food store & staples","https://www.walmart.ca/en/browse/grocery/pantry-food/10019_6000194326346?icid=cp_l2_page_grocery_shop_all_27118_MNMVYLFXJ3");
        this.categoriesURLs.put("Frozen food store","https://www.walmart.ca/en/browse/grocery/frozen-food/10019_6000194326337?icid=landing/cp_page_grocery_shop_all_21640_1EMO39NAUA");
        this.categoriesURLs.put("Bread & bakery","https://www.walmart.ca/en/browse/grocery/bread-bakery/10019_6000194327359?icid=cp_l2_page_grocery_shop_all_23096_PWP4HZCCH6");
        this.categoriesURLs.put("Snacks","https://www.walmart.ca/en/browse/grocery/snacks-candy/10019_6000194328523?icid=browse_l2_grocery_shop_all_22667_TK6UJPCDCG");
        this.categoriesURLs.put("Drinks & beverages","https://www.walmart.ca/en/browse/grocery/drinks/10019_6000194326336?icid=cp_l2_page_grocery_shop_all_28888_J1MSQRQOZT");
        this.categoriesURLs.put("Deli & fresh prepared meals","https://www.walmart.ca/en/cp/grocery/deli-fresh-prepared-meals/6000194327356?icid=cp_l1_page_grocery_more_grocery_deli_56861_32K7UD0LW0");
        this.categoriesURLs.put("Cheese","https://www.walmart.ca/en/cp/grocery/dairy-eggs/cheese/6000194327377?icid=cp_l1_page_grocery_more_grocery_cheese_56862_R81WSACJPN");
        this.categoriesURLs.put("International foods store","https://www.walmart.ca/en/browse/grocery/international-foods/10019_6000195495824?icid=cp_l2_page_grocery_shop_all_23697_3MLJOH6S6E");
        this.categoriesURLs.put("Tasty baked goods","https://www.walmart.ca/en/cp/grocery/bbq/6000203002173?icid=cp_l1_page_grocery_more_grocery_bbq_84011_NFVEHVQVFR");
        this.categoriesURLs.put("Sweet summer treats","https://www.walmart.ca/en/shop/grocery/summer-treats/7155970886311?icid=cp_l1_page_grocery_more_grocery_summer_candy_78840_ZZTVE7GVLW");
        this.categoriesURLs.put("Ice cream shop","https://www.walmart.ca/en/browse/grocery/frozen-food/ice-cream-treats/10019_6000194326337_6000194349402?icid=landing/cp_page_grocery_shop_all_17778_I8YF0M83QT");
        this.categoriesURLs.put("New Arrivals","https://www.walmart.ca/en/shop/new-arrivals/1364258455409?icid=cp_l1_page_grocery_more_grocery_new_arrivals_80296_PXS9XMFYAY");

        //might need to add dietary category, but might not have to bc they would be repeats.
    }



}
