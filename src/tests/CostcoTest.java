package tests;

import model.store.AbstractStore;
import model.Product;
import model.scraper.WebsiteScraper;
import model.store.Costco;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.Assert.*;


public class CostcoTest {

    protected List<Product> products;
    protected WebsiteScraper scraper;
    private AbstractStore costco;

    @BeforeEach

    public void runBefore() {
        costco = new Costco("Costco");
    }

    @Test
    //this method is part of the constructor so it's already run
    //also it's basically a setter so doenst have to be thouroughly tested
    public void initializeCategoriesTest() {
        assertEquals(21, costco.getCategoriesURLs().size());
        assertTrue(costco.getCategoriesURLs().containsKey("Organic"));
        assertTrue(costco.getCategoriesURLs().containsKey("Bakery"));
        assertTrue(costco.getCategoriesURLs().containsKey("Vegan Foods"));
    }

    @Test
    void testConstructor() {
        assertEquals("Costco", costco.getName());
        assertNotNull(costco.getScraper());
        assertFalse(costco.getCategoriesURLs().isEmpty());
    }

    @Test
    void testGetNextURL() {
        // One-word category URL
        String urlSeafood = "https://www.costco.ca/seafood.html";
        assertEquals(urlSeafood + "?currentPage=2&pageSize=24", costco.getNextURL(urlSeafood, 1));
        assertEquals(urlSeafood + "?currentPage=3&pageSize=24", costco.getNextURL(urlSeafood, 2));

        // Two-word category URL
        String urlCoffeeTea = "https://www.costco.ca/coffee-tea.html";
        assertEquals(urlCoffeeTea + "?currentPage=2&pageSize=24", costco.getNextURL(urlCoffeeTea, 1));
        assertEquals(urlCoffeeTea + "?currentPage=3&pageSize=24", costco.getNextURL(urlCoffeeTea, 2));

        // More than two-word category URL
        String urlPantryDryGoods = "https://www.costco.ca/baking-packaged-food.html";
        assertEquals(urlPantryDryGoods + "?currentPage=2&pageSize=24", costco.getNextURL(urlPantryDryGoods, 1));
        assertEquals(urlPantryDryGoods + "?currentPage=3&pageSize=24", costco.getNextURL(urlPantryDryGoods, 2));

    }

    @Test

    public void generateProductsTest() {
        costco.generateProducts();
        //checking that it scrapes all the products off of each page. Can help pinpoint where a missing product is later if needed.
        for (int i = 0; i < 99999; i++) {
            assertTrue(costco.getProducts().size() >= i);
        }
    }

}


