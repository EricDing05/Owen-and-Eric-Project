package model.store;

import model.AbstractStore;

public class NoFrills extends AbstractStore {


    public NoFrills(String name) {
        super(name);
        initializeCategories();
        this.setGridPath("//div[@data-testid='product-grid']");
        this.setProductPath("//div[contains(@class, 'chakra-linkbox') and contains(@class, 'css-')]");

    }

    public void generateProducts() {

    }
    public String getNextURL(String url, int i) {
        if (i == 1) {
            return url + "?page=2";
        } else {
            // If i > 1, we replace the current page number with i + 1
            return url.replaceAll("page=\\d+", "page=" + (i + 1));
        }

    }

    // has the same master food page as superstore
    public void initializeCategories() {
        // Fruit n Veggies

        this.categoriesURLs.put("Food", "https://www.nofrills.ca/food/c/27985");
//        this.categoriesURLs.put("Fresh Vegetables","https://www.nofrills.ca/food/fruits-vegetables/fresh-vegetables/c/28195?navid=flyout-L3-Fresh-Vegetables");
//        this.categoriesURLs.put("Fresh Fruits","https://www.nofrills.ca/food/fruits-vegetables/fresh-fruits/c/28194");
//        this.categoriesURLs.put("Packaged Salad & Dressing","https://www.nofrills.ca/food/fruits-vegetables/packaged-salad-dressing/c/28196");
//        this.categoriesURLs.put("Herbs","https://www.nofrills.ca/food/fruits-vegetables/herbs/c/28197");
//        this.categoriesURLs.put("Fresh Cut Fruits & Vegetables","https://www.nofrills.ca/food/fruits-vegetables/fresh-cut-fruits-vegetables/c/28198");
//        this.categoriesURLs.put("Dried Fruits & Nuts","https://www.nofrills.ca/food/fruits-vegetables/dried-fruits-nuts/c/28199");
//        this.categoriesURLs.put("Fresh Juice & Smoothies","https://www.nofrills.ca/food/fruits-vegetables/fresh-juice-smoothies/c/28200");
//        this.categoriesURLs.put("In-Store Salads","https://www.nofrills.ca/food/fruits-vegetables/in-store-salads/c/59222");
//
//        //Dairy n Eggs
//        this.categoriesURLs.put("Butter & Spreads","https://www.nofrills.ca/food/dairy-eggs/butter-spreads/c/28220");
//        this.categoriesURLs.put("Desserts & Doughs","https://www.nofrills.ca/food/dairy-eggs/desserts-doughs/c/28221");
//        this.categoriesURLs.put("Egg & Egg Substitutes","https://www.nofrills.ca/food/dairy-eggs/egg-egg-substitutes/c/28222");
//        this.categoriesURLs.put("Lactose Free","https://www.nofrills.ca/food/dairy-eggs/lactose-free/c/28223");
//        this.categoriesURLs.put("Milk & Cream","https://www.nofrills.ca/food/dairy-eggs/milk-cream/c/28224");
//        this.categoriesURLs.put("Cheese","https://www.nofrills.ca/food/dairy-eggs/c/28003?navid=flyout-L2-Dairy-and-Eggs");
//        this.categoriesURLs.put("Sour Cream & Dips","https://www.nofrills.ca/food/dairy-eggs/sour-cream-dips/c/28226");
//        this.categoriesURLs.put("Yogurt","https://www.nofrills.ca/food/dairy-eggs/yogurt/c/28227");
//        this.categoriesURLs.put("Non-Dairy Milk Alternatives","https://www.nofrills.ca/food/dairy-eggs/non-dairy-milk-alternatives/c/58904");
//        this.categoriesURLs.put("Natural and Organic","https://www.nofrills.ca/food/dairy-eggs/natural-and-organic/c/59463");

    }


}
