//package tests;
//
//import model.store.AbstractStore;
//import model.Product;
//import model.scraper.WebsiteScraper;
//import model.store.SuperStore;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//
//public class SuperStoreTest {
//
//    protected List<Product> products;
//    protected WebsiteScraper scraper;
//    private AbstractStore superStore;
//
//    @BeforeEach
//
//    public void runBefore() {
//        superStore = new SuperStore("Super Store");
//    }
//
//    @Test
//    //this method is part of the constructor so it's already run
//    public void initializeCategoriesTest() {
//        assertEquals(1, superStore.getCategoriesURLs().size());
//        assertTrue(superStore.getCategoriesURLs().containsKey("Food"));
//    }
//
//    @Test
//    // there should be an exception made and thrown if the method is given https://www.nofrills.ca/food/c/27985 and an i not equal to 1, because that combo doesnt make sense, but it would break the method
//    public void getNextUrlTest() {
//        assertEquals("https://www.realcanadiansuperstore.ca/food/c/27985?page=2", superStore.getNextURL("https://www.realcanadiansuperstore.ca/food/c/27985", 1));
//        assertEquals("https://www.realcanadiansuperstore.ca/food/c/27985?page=3", superStore.getNextURL("https://www.realcanadiansuperstore.ca/food/c/27985?page=2", 2));
//    }
//
//    @Test
//
//    public void generateProductsTest() {
//        superStore.generateProducts();
//
//        //checking that it scrapes all the products off of each page. Can help pinpoint where a missing product is later if needed.
//        for (int i = 0; i < 200; i++) {
//            assertTrue(superStore.getProducts().size() >= i * 48);
//        }
//    }
//
//
//
//
//
//
//
//}
