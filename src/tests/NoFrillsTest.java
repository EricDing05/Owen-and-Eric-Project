package tests;

import model.AbstractStore;
import model.Product;
import model.scraper.WebsiteScraper;
import model.store.NoFrills;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.Assert.*;


public class NoFrillsTest {

    protected List<Product> products;
    protected WebsiteScraper scraper;
    private AbstractStore nofrills;

    @BeforeEach

    public void runBefore() {
         nofrills = new NoFrills("NoFrills");
    }

    @Test
    //this method is part of the constructor so it's already run
    public void initializeCategoriesTest() {
        assertEquals(1,nofrills.getCategoriesURLs().size());
        assertTrue(nofrills.getCategoriesURLs().containsKey("Food"));
    }

    @Test
    // there should be an exception made and thrown if the method is given https://www.nofrills.ca/food/c/27985 and an i not equal to 1, because that combo doesnt make sense, but it would break the method
    public void getNextUrlTest() {
        assertEquals("https://www.nofrills.ca/food/c/27985?page=2", nofrills.getNextURL("https://www.nofrills.ca/food/c/27985", 1));
        assertEquals("https://www.nofrills.ca/food/c/27985?page=3", nofrills.getNextURL("https://www.nofrills.ca/food/c/27985?page=2", 2));
    }

    @Test

    public void generateProductsTest() {
        nofrills.generateProducts();

        //checking that it scrapes all the products off of each page. Can help pinpoint where a missing product is later if needed.
        for (int i = 0; i < 200; i++) {
            assertTrue(nofrills.getProducts().size() >= i * 48);
        }

        //
    }







}
