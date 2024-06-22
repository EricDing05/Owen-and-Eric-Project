package tests;

import model.store.Walmart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class WalmartTest {
    private Walmart walmart;

    @BeforeEach
    void setUp() {
        walmart = new Walmart("Walmart");
    }

    @Test
    void testConstructor() {
        assertEquals("Walmart", walmart.getName());
        assertFalse(walmart.getCategoriesURLs().isEmpty());
    }

    @Test
    void testGetNextURL() {
        // One-word category URL
        String urlSnacks = "https://www.walmart.ca/en/browse/grocery/snacks-candy/10019_6000194328523";
        assertEquals(urlSnacks + "&page=2", walmart.getNextURL(urlSnacks, 1));
        assertEquals(urlSnacks + "&page=3", walmart.getNextURL(urlSnacks, 2));

        // Two-word category URL
        String urlBreadBakery = "https://www.walmart.ca/en/browse/grocery/bread-bakery/10019_6000194327359";
        assertEquals(urlBreadBakery + "&page=2", walmart.getNextURL(urlBreadBakery, 1));
        assertEquals(urlBreadBakery + "&page=3", walmart.getNextURL(urlBreadBakery, 2));

        // More than two-word category URL
        String urlFreshMeatSeafood = "https://www.walmart.ca/en/browse/grocery/meat-seafood-alternatives/10019_6000194327357";
        assertEquals(urlFreshMeatSeafood + "&page=2", walmart.getNextURL(urlFreshMeatSeafood, 1));
        assertEquals(urlFreshMeatSeafood + "&page=3", walmart.getNextURL(urlFreshMeatSeafood, 2));

    }

    @Test
    void testInitializeCategories() {
        assertEquals("https://www.walmart.ca/en/browse/grocery/fruits-vegetables/10019_6000194327370?icid=cp_l2_page_grocery_shop_all_22967_EMNZA1CAH7",
                walmart.getCategoriesURLs().get("Fresh produce"));
        assertEquals("https://www.walmart.ca/en/browse/grocery/dairy-eggs/10019_6000194327369?icid=landing/cp_page_grocery_shop_all_15500_TDP1IRI294",
                walmart.getCategoriesURLs().get("Fresh dairy products & eggs"));
        assertEquals("https://www.walmart.ca/en/browse/grocery/meat-seafood-alternatives/10019_6000194327357?icid=landing/cp_page_grocery_shop_all_16999_MPQB559PFG",
                walmart.getCategoriesURLs().get("Fresh meat, seafood & alternatives"));
        assertEquals("https://www.walmart.ca/en/browse/grocery/pantry-food/10019_6000194326346?icid=cp_l2_page_grocery_shop_all_27118_MNMVYLFXJ3",
                walmart.getCategoriesURLs().get("Pantry food store & staples"));
        assertEquals("https://www.walmart.ca/en/browse/grocery/frozen-food/10019_6000194326337?icid=landing/cp_page_grocery_shop_all_21640_1EMO39NAUA",
                walmart.getCategoriesURLs().get("Frozen food store"));
        assertEquals("https://www.walmart.ca/en/browse/grocery/bread-bakery/10019_6000194327359?icid=cp_l2_page_grocery_shop_all_23096_PWP4HZCCH6",
                walmart.getCategoriesURLs().get("Bread & bakery"));
        assertEquals("https://www.walmart.ca/en/browse/grocery/snacks-candy/10019_6000194328523?icid=browse_l2_grocery_shop_all_22667_TK6UJPCDCG",
                walmart.getCategoriesURLs().get("Snacks"));
        assertEquals("https://www.walmart.ca/en/browse/grocery/drinks/10019_6000194326336?icid=cp_l2_page_grocery_shop_all_28888_J1MSQRQOZT",
                walmart.getCategoriesURLs().get("Drinks & beverages"));
        assertEquals("https://www.walmart.ca/en/cp/grocery/deli-fresh-prepared-meals/6000194327356?icid=cp_l1_page_grocery_more_grocery_deli_56861_32K7UD0LW0",
                walmart.getCategoriesURLs().get("Deli & fresh prepared meals"));
        assertEquals("https://www.walmart.ca/en/cp/grocery/dairy-eggs/cheese/6000194327377?icid=cp_l1_page_grocery_more_grocery_cheese_56862_R81WSACJPN",
                walmart.getCategoriesURLs().get("Cheese"));
        assertEquals("https://www.walmart.ca/en/browse/grocery/international-foods/10019_6000195495824?icid=cp_l2_page_grocery_shop_all_23697_3MLJOH6S6E",
                walmart.getCategoriesURLs().get("International foods store"));
        assertEquals("https://www.walmart.ca/en/cp/grocery/bbq/6000203002173?icid=cp_l1_page_grocery_more_grocery_bbq_84011_NFVEHVQVFR",
                walmart.getCategoriesURLs().get("Tasty baked goods"));
        assertEquals("https://www.walmart.ca/en/shop/grocery/summer-treats/7155970886311?icid=cp_l1_page_grocery_more_grocery_summer_candy_78840_ZZTVE7GVLW",
                walmart.getCategoriesURLs().get("Sweet summer treats"));
        assertEquals("https://www.walmart.ca/en/browse/grocery/frozen-food/ice-cream-treats/10019_6000194326337_6000194349402?icid=landing/cp_page_grocery_shop_all_17778_I8YF0M83QT",
                walmart.getCategoriesURLs().get("Ice cream shop"));
        assertEquals("https://www.walmart.ca/en/shop/new-arrivals/1364258455409?icid=cp_l1_page_grocery_more_grocery_new_arrivals_80296_PXS9XMFYAY",
                walmart.getCategoriesURLs().get("New Arrivals"));
    }
}
