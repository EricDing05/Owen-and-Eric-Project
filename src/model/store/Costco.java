package model.store;

import model.persistance.Writer;
import model.scraper.CostcoScraper;

public class Costco extends AbstractStore {

    // EFFECTS: Creates an instance of a store
    public Costco(String name) {
        super(name);
        initializeCategories();
        this.setGridPath("//div[@automation-id='productList']");
        this.setProductPath("//div[contains(@class, 'product-tile-set')]"); //this might not work. not tested
        scraper = new CostcoScraper();
        this.writer = new Writer("/Users/ericding/IdeaProjects/App/.idea/data/Costco.json");
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
            return url + "?currentPage=" + (i + 1) + "&pageSize=24";
        }
    }

    // EFFECTS: initializes all the categories and their URLs
    public void initializeCategories() {
        this.categoriesURLs.put("Kirkland Signature", "https://www.costco.ca/kirkland-signature-products.html" );
//        this.categoriesURLs.put("Pantry & Dry Goods","https://www.costco.ca/baking-packaged-food.html");
//        this.categoriesURLs.put("Coffee & Tea","https://www.costco.ca/coffee-tea.html");
//        this.categoriesURLs.put("Snacks, Candy & Nuts","https://www.costco.ca/snacks.html");
//        this.categoriesURLs.put("Cookies & Desserts","https://www.costco.ca/desserts.html");
//
//        this.categoriesURLs.put("Seafood","https://www.costco.ca/seafood.html");
//        this.categoriesURLs.put("Meat","https://www.costco.ca/meat.html");
//        this.categoriesURLs.put("Poultry","https://www.costco.ca/poultry.html");
//        this.categoriesURLs.put("Deli & Cured Meats","https://www.costco.ca/cured-meats.html");
//        this.categoriesURLs.put("Cheese","https://www.costco.ca/cheese.html");
//
//        this.categoriesURLs.put("Bakery","https://www.costco.ca/bakery-desserts.html");
//        this.categoriesURLs.put("Meals & Appetizers","https://www.costco.ca/meals-appetizers.html");
//        this.categoriesURLs.put("Water & Beverages","https://www.costco.ca/water-beverages.html");
//        this.categoriesURLs.put("Wine & Beer Kits","https://www.costco.ca/wine-beer-kits.html");
//        this.categoriesURLs.put("Gift Baskets","https://www.costco.ca/gift-baskets.html");
//
//        this.categoriesURLs.put("Organic","https://www.costco.ca/organic.html");
//        this.categoriesURLs.put("Vegan Foods","https://www.costco.ca/vegan-foods.html");
//        this.categoriesURLs.put("International Foods","https://www.costco.ca/international-foods.html");
//        this.categoriesURLs.put("Emergency Food Kits","https://www.costco.ca/emergency-food-kits.html");
//        this.categoriesURLs.put("Household Products","https://www.costco.ca/household.html"); //neccessary?
//        this.categoriesURLs.put("Health & Beauty","https://www.costco.ca/health-beauty.html?costcoprogramtypes=costco-grocery&refine=||item_program_eligibility-2DayDelivery");
    }




}
