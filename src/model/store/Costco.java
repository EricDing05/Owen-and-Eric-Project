package model.store;

import model.AbstractStore;
import model.scraper.CostcoScraper;

public class Costco extends AbstractStore {


    public Costco(String name) {
        super(name);
        initializeCategories();
        this.setGridPath("//div[@automation-id='productList']");
        this.setProductPath("//div[contains(@class, 'product') and contains(@class, 'col-xs-12')]"); //this might not work. not tested
        scraper = new CostcoScraper();
    }

    public void generateProducts() {

    }

    //This shoulldd work for all categories.
    public String getNextURL(String url, int i) {
        if (i == 1) {
            // If i == 1, we need to generate the URL for the second page
            return url + "?currentPage=2&pageSize=24";
        } else {
            // If i > 1, we update the current page in the URL
            return url.replaceAll("currentPage=\\d+", "currentPage=" + (i + 1));
        }
    }


    public void initializeCategories() {
        this.categoriesURLs.put("Kirkland Signature", "https://www.costco.ca/kirkland-signature-products.html" );
        this.categoriesURLs.put("Pantry & Dry Goods","https://www.costco.ca/baking-packaged-food.html");
        this.categoriesURLs.put("Coffee & Tea","https://www.costco.ca/coffee-tea.html");
        this.categoriesURLs.put("Snacks, Candy & Nuts","https://www.costco.ca/snacks.html");
        this.categoriesURLs.put("Cookies & Desserts","https://www.costco.ca/desserts.html");

        this.categoriesURLs.put("Seafood","https://www.costco.ca/seafood.html");
        this.categoriesURLs.put("Meat","https://www.costco.ca/meat.html");
        this.categoriesURLs.put("Poultry","https://www.costco.ca/poultry.html");
        this.categoriesURLs.put("Deli & Cured Meats","https://www.costco.ca/cured-meats.html");
        this.categoriesURLs.put("Cheese","https://www.costco.ca/cheese.html");
        this.categoriesURLs.put("Bakery","https://www.costco.ca/bakery-desserts.html");
        this.categoriesURLs.put("Meals & Appetizers","https://www.costco.ca/meals-appetizers.html");
        this.categoriesURLs.put("Water & Beverages","https://www.costco.ca/water-beverages.html");
        this.categoriesURLs.put("Wine & Beer Kits","https://www.costco.ca/wine-beer-kits.html");
        this.categoriesURLs.put("Gift Baskets","https://www.costco.ca/gift-baskets.html");

        this.categoriesURLs.put("Organic","https://www.costco.ca/organic.html");
        this.categoriesURLs.put("Vegan Foods","https://www.costco.ca/vegan-foods.html");
        this.categoriesURLs.put("International Foods","https://www.costco.ca/international-foods.html");
        this.categoriesURLs.put("Emergency Food Kits","https://www.costco.ca/emergency-food-kits.html");
        this.categoriesURLs.put("Household Products","https://www.costco.ca/household.html"); //neccessary?
        this.categoriesURLs.put("Health & Beauty","https://www.costco.ca/health-beauty.html?costcoprogramtypes=costco-grocery&refine=||item_program_eligibility-2DayDelivery");
    }



}
