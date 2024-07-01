package model.store;

import model.persistance.Writer;
import model.scraper.SaveOnFoodsScraper;


public class SaveOnFoods extends AbstractStore  {

    // EFFECTS: Creates an instance of a store
    public SaveOnFoods(String name) {
        super(name);
        initializeCategories();
        // these commented out paths also work. leave them here in case we need them
        this.setGridPath("//section[@aria-labelledby='productGrid__title']"); //"//*[@id=\"pageMain\"]/div[2]/div[1]/div/div[3]/div/section[1]/section[2]/div[3]"
        this.setProductPath("//article[starts-with(@class, 'ProductCardWrapper--')]"); // "//div[@class='ColListing--1fk1zey jGGReB']"
        scraper = new SaveOnFoodsScraper();
        writer = new Writer(".idea/data/SaveOnFoods.json");
    }

    // EFFECTS: Generates/updates all products of this store
    public void generateProducts() {
        this.scraper.scrapeWebsite(this);
    }

    // EFFECTS: returns the next page of a given URL
    public String getNextURL(String url, int i) { //this only works for a page that has a siingle word title //TODO
        if (i == 1) {
            // If i == 1, we need to append &page=2&skip=30 and handle URL encoding
            return url + "&page=2&skip=30";
        } else {
            // If i > 1, we replace the current page number and skip value
            int nextPage = i + 1;
            int nextSkip = i * 30;
            return url.replaceAll("page=\\d+", "page=" + nextPage)
                    .replaceAll("skip=\\d+", "skip=" + nextSkip);
        }
    }



    // EFFECTS: initializes all the categories and their URLs
    public void initializeCategories() { //1982 is for the generic store. change this number to change location
        //fruit n veggies
        this.categoriesURLs.put("Fresh Fruit","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/fruits-vegetables/fresh-fruit-id-30682?f=Breadcrumb%3Agrocery%2Ffruits%20%26%20vegetables%2Ffresh%20fruit");
        this.categoriesURLs.put("Fresh Juice & Smoothies","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/fruits-vegetables/fresh-juice-smoothies-id-30723?f=Breadcrumb%3Agrocery%2Ffruits%20%26%20vegetables%2Ffresh%20juice%20%26%20smoothies");
        this.categoriesURLs.put("Fresh Noodle, Tofu & Soy Products","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/fruits-vegetables/fresh-noodle-tofu-soy-products-id-30724?f=Breadcrumb%3Agrocery%2Ffruits%20%26%20vegetables%2Ffresh%20noodle,%20tofu%20%26%20soy%20products");
        this.categoriesURLs.put("Fresh Vegetables","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/fruits-vegetables/fresh-vegetables-id-30694?f=Breadcrumb%3Agrocery%2Ffruits%20%26%20vegetables%2Ffresh%20vegetables");
        this.categoriesURLs.put("Salad Kits & Greens, Essentials","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/fruits-vegetables/salad-kits-greens-essentials-id-30717?f=Breadcrumb%3Agrocery%2Ffruits%20%26%20vegetables%2Fsalad%20kits%20%26%20greens,%20essentials");
        this.categoriesURLs.put("Trays, Baskets, Platters","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/fruits-vegetables/trays-baskets-platters-id-30713?f=Breadcrumb%3Agrocery%2Ffruits%20%26%20vegetables%2Ftrays,%20baskets,%20platters");
        this.categoriesURLs.put("Dried Snack Fruit & Nuts","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/fruits-vegetables/dried-snack-fruit-nuts-id-30725?f=Breadcrumb%3Agrocery%2Ffruits%20%26%20vegetables%2Fdried%20snack%20fruit%20%26%20nuts");
        this.categoriesURLs.put("Dressing & Dips","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/fruits-vegetables/dressing-dips-id-30722?f=Breadcrumb%3Agrocery%2Ffruits%20%26%20vegetables%2Fdressing%20%26%20dips");

        //bakery
        this.categoriesURLs.put("Bagels & English Muffins","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/bakery/bagels-english-muffins-id-30847?f=Breadcrumb%3Agrocery%2Fbakery%2Fbagels%20%26%20english%20muffins");
        this.categoriesURLs.put("Breads","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/bakery/breads-id-30850?f=Breadcrumb%3Agrocery%2Fbakery%2Fbreads");
        this.categoriesURLs.put("Cakes","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/bakery/cakes-id-30888?f=Breadcrumb%3Agrocery%2Fbakery%2Fcakes");
        this.categoriesURLs.put("Dessert & Pastries","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/bakery/dessert-pastries-id-30879?f=Breadcrumb%3Agrocery%2Fbakery%2Fdessert%20%26%20pastries");
        this.categoriesURLs.put("Frozen Bakery","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/bakery/frozen-bakery-id-30901?f=Breadcrumb%3Agrocery%2Fbakery%2Ffrozen%20bakery");
        this.categoriesURLs.put("Pies & Tarts","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/bakery/pies-tarts-id-30894?f=Breadcrumb%3Agrocery%2Fbakery%2Fpies%20%26%20tarts");
        this.categoriesURLs.put("Pitas, Flatbread & Wraps","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/bakery/pitas-flatbread-wraps-id-30899?f=Breadcrumb%3Agrocery%2Fbakery%2Fpitas,%20flatbread%20%26%20wraps");
        this.categoriesURLs.put("Pizza Crust & Crumbs","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/bakery/pizza-crust-crumbs-id-30887?f=Breadcrumb%3Agrocery%2Fbakery%2Fpizza%20crust%20%26%20crumbs");
        this.categoriesURLs.put("Rolls & Buns","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/bakery/rolls-buns-id-30873?f=Breadcrumb%3Agrocery%2Fbakery%2Frolls%20%26%20buns");
        this.categoriesURLs.put("Roti & Naan Breads","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/bakery/roti-naan-breads-id-30900?f=Breadcrumb%3Agrocery%2Fbakery%2Froti%20%26%20naan%20breads");

        //Dairy & eggs
        this.categoriesURLs.put("Butter & Margarine","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/dairy-eggs/butter-margarine-id-30907?f=Breadcrumb%3Agrocery%2Fdairy%20%26%20eggs%2Fbutter%20%26%20margarine");
        this.categoriesURLs.put("Cheese","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/dairy-eggs/cheese-id-30910?f=Breadcrumb%3Agrocery%2Fdairy%20%26%20eggs%2Fcheese");
        this.categoriesURLs.put("Chilled Juice & Drinks","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/dairy-eggs/chilled-juice-drinks-id-30920?f=Breadcrumb%3Agrocery%2Fdairy%20%26%20eggs%2Fchilled%20juice%20%26%20drinks");
        this.categoriesURLs.put("Dough Products","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/dairy-eggs/dough-products-id-30929?f=Breadcrumb%3Agrocery%2Fdairy%20%26%20eggs%2Fdough%20products");
        this.categoriesURLs.put("Eggs & Substitutes","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/dairy-eggs/eggs-substitutes-id-30919?f=Breadcrumb%3Agrocery%2Fdairy%20%26%20eggs%2Feggs%20%26%20substitutes");
        this.categoriesURLs.put("Milk & Creams","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/dairy-eggs/milk-creams-id-30930?f=Breadcrumb%3Agrocery%2Fdairy%20%26%20eggs%2Fmilk%20%26%20creams");
        this.categoriesURLs.put("Milk Substitutes","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/dairy-eggs/milk-substitutes-id-30939?f=Breadcrumb%3Agrocery%2Fdairy%20%26%20eggs%2Fmilk%20substitutes");
        this.categoriesURLs.put("Pudding & Desserts","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/dairy-eggs/pudding-desserts-id-30943?f=Breadcrumb%3Agrocery%2Fdairy%20%26%20eggs%2Fpudding%20%26%20desserts");
        this.categoriesURLs.put("Sour Cream & Dips","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/dairy-eggs/sour-cream-dips-id-30944?f=Breadcrumb%3Agrocery%2Fdairy%20%26%20eggs%2Fsour%20cream%20%26%20dips");
        this.categoriesURLs.put("Yogurt","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/dairy-eggs/yogurt-id-30945?f=Breadcrumb%3Agrocery%2Fdairy%20%26%20eggs%2Fyogurt");

        // deli n ready made deals
        this.categoriesURLs.put("Cheese","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/deli-ready-made-meals/cheese-id-30748?f=Breadcrumb%3Agrocery%2Fdeli%20%26%20ready%20made%20meals%2Fcheese");
        this.categoriesURLs.put("Dips, Spreads & Olives","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/deli-ready-made-meals/dips-spreads-olives-id-30772?f=Breadcrumb%3Agrocery%2Fdeli%20%26%20ready%20made%20meals%2Fdips,%20spreads%20%26%20olives");
        this.categoriesURLs.put("Meat","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/deli-ready-made-meals/meat-id-30727?f=Breadcrumb%3Agrocery%2Fdeli%20%26%20ready%20made%20meals%2Fmeat");
        this.categoriesURLs.put("Party Platters","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/deli-ready-made-meals/party-platters-id-30790?f=Breadcrumb%3Agrocery%2Fdeli%20%26%20ready%20made%20meals%2Fparty%20platters");
        this.categoriesURLs.put("Quick Ready Meals & Sides","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/deli-ready-made-meals/quick-ready-meals-sides-id-30776?f=Breadcrumb%3Agrocery%2Fdeli%20%26%20ready%20made%20meals%2Fquick%20ready%20meals%20%26%20sides");

        //Floral n garden
        this.categoriesURLs.put("Bouquets","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/floral-and-garden/bouquets-id-31331?f=Breadcrumb%3Agrocery%2Ffloral%20and%20garden%2Fbouquets");
        this.categoriesURLs.put("Ferns & Outdoor Floral","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/floral-and-garden/ferns-outdoor-floral-id-31333?f=Breadcrumb%3Agrocery%2Ffloral%20and%20garden%2Fferns%20%26%20outdoor%20floral");
        this.categoriesURLs.put("Potted Plants","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/floral-and-garden/potted-plants-id-31330?f=Breadcrumb%3Agrocery%2Ffloral%20and%20garden%2Fpotted%20plants");
        this.categoriesURLs.put("Roses","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/floral-and-garden/roses-id-31332?f=Breadcrumb%3Agrocery%2Ffloral%20and%20garden%2Froses");

        //Frozen
        this.categoriesURLs.put("Frozen Appetizers & Snacks","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-appetizers-snacks-id-30950?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20appetizers%20%26%20snacks");
        this.categoriesURLs.put("Frozen Bakery","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-bakery-id-30956?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20bakery");
        this.categoriesURLs.put("Frozen Beverages & Ice","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-beverages-ice-id-30960?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20beverages%20%26%20ice");
        this.categoriesURLs.put("Frozen Breakfast","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-breakfast-id-30967?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20breakfast");
        this.categoriesURLs.put("Frozen Fruit","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-fruit-id-30971?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20fruit");
        this.categoriesURLs.put("Frozen Meals & Sides","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-meals-sides-id-30976?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20meals%20%26%20sides");
        this.categoriesURLs.put("Frozen Meat","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-meat-id-30982?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20meat");
        this.categoriesURLs.put("Frozen Pizza","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-pizza-id-30993?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20pizza");
        this.categoriesURLs.put("Frozen Seafood","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-seafood-id-30999?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20seafood");
        this.categoriesURLs.put("Frozen Vegetables","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-vegetables-id-31002?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20vegetables");
        this.categoriesURLs.put("Ice Cream & Desserts","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/ice-cream-desserts-id-31008?f=Breadcrumb%3Agrocery%2Ffrozen%2Fice%20cream%20%26%20desserts");

        //international foods
        this.categoriesURLs.put("Asian","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/international-foods/asian-id-31406?f=Breadcrumb%3Agrocery%2Finternational%20foods%2Fasian");
        this.categoriesURLs.put("European","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/international-foods/european-id-31439?f=Breadcrumb%3Agrocery%2Finternational%20foods%2Feuropean");
        this.categoriesURLs.put("Indian & Middle Eastern","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/international-foods/indian-middle-eastern-id-31415?f=Breadcrumb%3Agrocery%2Finternational%20foods%2Findian%20%26%20middle%20eastern");
        this.categoriesURLs.put("Latin & Mexican","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/international-foods/latin-mexican-id-31432?f=Breadcrumb%3Agrocery%2Finternational%20foods%2Flatin%20%26%20mexican");
        this.categoriesURLs.put("Mediterranean","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/international-foods/mediterranean-id-31445?f=Breadcrumb%3Agrocery%2Finternational%20foods%2Fmediterranean");

        //meat and sea food
        this.categoriesURLs.put("Bacon","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/bacon-id-30817?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Fbacon");
        this.categoriesURLs.put("Beef & Veal","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/beef-veal-id-30792?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Fbeef%20%26%20veal");
        this.categoriesURLs.put("Chicken & Turkey","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/chicken-turkey-id-30798?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Fchicken%20%26%20turkey");
        this.categoriesURLs.put("Fish","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/fish-id-30827?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Ffish");
        this.categoriesURLs.put("Frozen Meat","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/frozen-meat-id-30830?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Ffrozen%20meat");
        this.categoriesURLs.put("Frozen Seafood","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/frozen-seafood-id-30842?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Ffrozen%20seafood");
        this.categoriesURLs.put("Game & Specialty Meats","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/game-specialty-meats-id-30816?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Fgame%20%26%20specialty%20meats");
        this.categoriesURLs.put("Hot Dogs & Sausages","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/hot-dogs-sausages-id-30818?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Fhot%20dogs%20%26%20sausages");
        this.categoriesURLs.put("Lamb","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/lamb-id-30815?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Flamb");
        this.categoriesURLs.put("Meat Alternatives","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/meat-alternatives-id-30821?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Fmeat%20alternatives");
        this.categoriesURLs.put("Pork & Ham","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/pork-ham-id-30807?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Fpork%20%26%20ham");
        this.categoriesURLs.put("Shrimp & Shell Fish","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/shrimp-shell-fish-id-30828?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Fshrimp%20%26%20shell%20fish");
        this.categoriesURLs.put("Smoked & Cured Fish","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/smoked-cured-fish-id-30829?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Fsmoked%20%26%20cured%20fish");

        //pantry item
        this.categoriesURLs.put("Baking Goods","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/baking-goods-id-30373?f=Breadcrumb%3Agrocery%2Fpantry%2Fbaking%20goods");
        this.categoriesURLs.put("Breakfast","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/breakfast-id-30481?f=Breadcrumb%3Agrocery%2Fpantry%2Fbreakfast");
        this.categoriesURLs.put("Canned & Packaged","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/canned-packaged-id-30527?f=Breadcrumb%3Agrocery%2Fpantry%2Fcanned%20%26%20packaged");
        this.categoriesURLs.put("Condiments & Toppings","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/condiments-toppings-id-30596?f=Breadcrumb%3Agrocery%2Fpantry%2Fcondiments%20%26%20toppings");
        this.categoriesURLs.put("Herbs, Spices & Seasonings","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/herbs-spices-seasonings-id-30635?f=Breadcrumb%3Agrocery%2Fpantry%2Fherbs,%20spices%20%26%20seasonings");
        this.categoriesURLs.put("Marinates & Sauces","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/marinates-sauces-id-30614?f=Breadcrumb%3Agrocery%2Fpantry%2Fmarinates%20%26%20sauces");
        this.categoriesURLs.put("Oils & Vinegars","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/oils-vinegars-id-30625?f=Breadcrumb%3Agrocery%2Fpantry%2Foils%20%26%20vinegars");
        this.categoriesURLs.put("Pasta, Sauces & Grains","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/pasta-sauces-grains-id-30652?f=Breadcrumb%3Agrocery%2Fpantry%2Fpasta,%20sauces%20%26%20grains");
        this.categoriesURLs.put("Beverages","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/beverages-id-30385?f=Breadcrumb%3Agrocery%2Fpantry%2Fbeverages");
        this.categoriesURLs.put("Bulk","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/bulk-id-31287?f=Breadcrumb%3Agrocery%2Fpantry%2Fbulk");
        this.categoriesURLs.put("Candy","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/candy-id-30504?f=Breadcrumb%3Agrocery%2Fpantry%2Fcandy");
        this.categoriesURLs.put("Snacks","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/snacks-id-30511?f=Breadcrumb%3Agrocery%2Fpantry%2Fsnacks");

        //plant based non-dairy
        this.categoriesURLs.put("Meat Alternatives","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/plant-based-non-dairy/meat-alternatives-id-34100?f=Breadcrumb%3Agrocery%2Fplant%20based%20%26%20non%20dairy%2Fmeat%20alternatives");
        this.categoriesURLs.put("Non Dairy Beverages","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/plant-based-non-dairy/non-dairy-beverages-id-35100?f=Breadcrumb%3Agrocery%2Fplant%20based%20%26%20non%20dairy%2Fnon%20dairy%20beverages");
        this.categoriesURLs.put("Non Dairy Cheese","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/plant-based-non-dairy/non-dairy-cheese-id-36100?f=Breadcrumb%3Agrocery%2Fplant%20based%20%26%20non%20dairy%2Fnon%20dairy%20cheese");
        this.categoriesURLs.put("Non Dairy Creamers","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/plant-based-non-dairy/non-dairy-creamers-id-37100?f=Breadcrumb%3Agrocery%2Fplant%20based%20%26%20non%20dairy%2Fnon%20dairy%20creamers");
        this.categoriesURLs.put("Non Dairy Frozen Dessert","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/plant-based-non-dairy/non-dairy-frozen-dessert-id-38100?f=Breadcrumb%3Agrocery%2Fplant%20based%20%26%20non%20dairy%2Fnon%20dairy%20frozen%20dessert");
        this.categoriesURLs.put("Non Dairy Spreads & Condiments","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/plant-based-non-dairy/non-dairy-spreads-condiments-id-39100?f=Breadcrumb%3Agrocery%2Fplant%20based%20%26%20non%20dairy%2Fnon%20dairy%20spreads%20%26%20condiments");
        this.categoriesURLs.put("Non Dairy Yogurt","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/plant-based-non-dairy/non-dairy-yogurt-id-39101?f=Breadcrumb%3Agrocery%2Fplant%20based%20%26%20non%20dairy%2Fnon%20dairy%20yogurt");
        this.categoriesURLs.put("Tofu","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/plant-based-non-dairy/tofu-id-39102?f=Breadcrumb%3Agrocery%2Fplant%20based%20%26%20non%20dairy%2Ftofu");
        this.categoriesURLs.put("Egg Alternatives","https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/plant-based-non-dairy/egg-alternatives-id-33100?f=Breadcrumb%3Agrocery%2Fplant%20based%20%26%20non%20dairy%2Fegg%20alternatives");
    }


    // https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/snacks-id-30511?f=Breadcrumb%3Agrocery%2Fpantry%2Fsnacks
    // https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/pantry/snacks-id-30511?f=Breadcrumb%3Agrocery%2Fpantry%2Fsnacks&page=2&skip=30
    // pg 3:

    // https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/frozen-meat-id-30830?f=Breadcrumb%3Agrocery%2Fmeat%20%26%20seafood%2Ffrozen%20meat
    // https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/meat-seafood/frozen-meat-id-30830?f=Breadcrumb%3Agrocery%2Fmeat+%26+seafood%2Ffrozen+meat&page=2&skip=30
    //


}
