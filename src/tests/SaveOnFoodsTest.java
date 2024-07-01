package tests;

import model.store.AbstractStore;
import model.Product;
import model.scraper.WebsiteScraper;
import model.store.SaveOnFoods;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SaveOnFoodsTest {

    private AbstractStore saveOnFoods;

    protected List<Product> products;
    protected WebsiteScraper scraper;

    @BeforeEach

    public void runBefore() {
        saveOnFoods = new SaveOnFoods("SaveOnFoods");
    }

    @Test
    //this method is part of the constructor so it's already run
    public void initializeCategoriesTest() {
        assertEquals(82,saveOnFoods.getCategoriesURLs().size());
        assertTrue(saveOnFoods.getCategoriesURLs().containsKey("Fresh Fruit"));
        assertTrue(saveOnFoods.getCategoriesURLs().containsKey("Fresh Juice & Smoothies"));
        assertTrue(saveOnFoods.getCategoriesURLs().containsKey("Yogurt"));
        assertTrue(saveOnFoods.getCategoriesURLs().containsKey("Egg Alternatives"));
    }

    @Test
    //should fail cuz this method not fully implemented at this time
    public void getNextUrlTest() {
        //single word page title
        assertEquals("https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/deli-ready-made-meals/cheese-id-30748?f=Breadcrumb%3Agrocery%2Fdeli+%26+ready+made+meals%2Fcheese&page=2&skip=30",
                saveOnFoods.getNextURL("https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/deli-ready-made-meals/cheese-id-30748?f=Breadcrumb%3Agrocery%2Fdeli%20%26%20ready%20made%20meals%2Fcheese", 1));
        assertEquals("https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/deli-ready-made-meals/cheese-id-30748?f=Breadcrumb%3Agrocery%2Fdeli+%26+ready+made+meals%2Fcheese&page=3&skip=60",
                saveOnFoods.getNextURL("https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/deli-ready-made-meals/cheese-id-30748?f=Breadcrumb%3Agrocery%2Fdeli+%26+ready+made+meals%2Fcheese&page=2&skip=30", 2));

        //two word page title
        assertEquals("https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-meat-id-30982?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen+meat&page=2&skip=30",
                saveOnFoods.getNextURL("https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-meat-id-30982?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20meat", 1));


        // >= three word titles
        assertEquals("https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-appetizers-snacks-id-30950?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20appetizers%20%26%20snacks",
                saveOnFoods.getNextURL("https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-appetizers-snacks-id-30950?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen+appetizers+%26+snacks&page=2&skip=30", 1));

        assertEquals("https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-appetizers-snacks-id-30950?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen+appetizers+%26+snacks&page=3&skip=60",
                saveOnFoods.getNextURL("https://www.saveonfoods.com/sm/pickup/rsid/1982/categories/frozen/frozen-appetizers-snacks-id-30950?f=Breadcrumb%3Agrocery%2Ffrozen%2Ffrozen%20appetizers%20%26%20snacks", 2));
    }

    @Test

    public void generateProductsTest() {
        saveOnFoods.generateProducts();
       assertTrue(saveOnFoods.getProducts().size() > 300);
    }


}
