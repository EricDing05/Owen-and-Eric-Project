package tests;

import model.store.ThriftyFoods;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ThriftyFoodsTest {
    private ThriftyFoods thriftyFoods;

    @BeforeEach
    void setUp() {
        thriftyFoods = new ThriftyFoods("Thrifty Foods");
    }

    @Test
    void testConstructor() {
        assertEquals("Thrifty Foods", thriftyFoods.getName());
        assertFalse(thriftyFoods.getCategoriesURLs().isEmpty());
    }

    @Test
    void testGetNextURL() {
        // One-word category URL
        String urlProduce = "https://www.thriftyfoods.com/shop-online/produce";
        assertEquals(urlProduce + "?page=1&pageSize=200", thriftyFoods.getNextURL(urlProduce, 0));
        assertEquals(urlProduce + "?page=2&pageSize=200", thriftyFoods.getNextURL(urlProduce, 1));

        // Two-word category URL
        String urlBulkFoods = "https://www.thriftyfoods.com/shop-online/bulk-foods";
        assertEquals(urlBulkFoods + "?page=1&pageSize=200", thriftyFoods.getNextURL(urlBulkFoods, 0));
        assertEquals(urlBulkFoods + "?page=2&pageSize=200", thriftyFoods.getNextURL(urlBulkFoods, 1));

        // More than two-word category URL
        String urlRefrigeratedGrocery = "https://www.thriftyfoods.com/shop-online/refrigerated-grocery";
        assertEquals(urlRefrigeratedGrocery + "?page=1&pageSize=200", thriftyFoods.getNextURL(urlRefrigeratedGrocery, 0));
        assertEquals(urlRefrigeratedGrocery + "?page=2&pageSize=200", thriftyFoods.getNextURL(urlRefrigeratedGrocery, 1));

        String urlGeneralMerchandise = "https://www.thriftyfoods.com/shop-online/general-merchandise";
        assertEquals(urlGeneralMerchandise + "?page=1&pageSize=200", thriftyFoods.getNextURL(urlGeneralMerchandise, 0));
        assertEquals(urlGeneralMerchandise + "?page=2&pageSize=200", thriftyFoods.getNextURL(urlGeneralMerchandise, 1));
    }

    @Test
    void testInitializeCategories() {
        assertEquals("https://www.thriftyfoods.com/shop-online/bakery-commercial",
                thriftyFoods.getCategoriesURLs().get("BAKERY (COMMERCIAL)"));
        assertEquals("https://www.thriftyfoods.com/shop-online/meat",
                thriftyFoods.getCategoriesURLs().get("MEAT"));
        // Additional assertions for different types of categories
        assertEquals("https://www.thriftyfoods.com/shop-online/produce",
                thriftyFoods.getCategoriesURLs().get("PRODUCE"));
        assertEquals("https://www.thriftyfoods.com/shop-online/bulk-foods",
                thriftyFoods.getCategoriesURLs().get("BULK FOODS"));
        assertEquals("https://www.thriftyfoods.com/shop-online/refrigerated-grocery",
                thriftyFoods.getCategoriesURLs().get("REFRIGERATED GROCERY"));
        assertEquals("https://www.thriftyfoods.com/shop-online/general-merchandise",
                thriftyFoods.getCategoriesURLs().get("GENERAL MERCHANDISE"));

        assertEquals(15, thriftyFoods.getCategoriesURLs().size());
    }
}
