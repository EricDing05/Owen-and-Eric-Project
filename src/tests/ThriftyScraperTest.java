package tests;

import model.Product;
import model.scraper.ThriftyScraper;
import model.store.ThriftyFoods;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThriftyScraperTest {
    private ThriftyScraper thriftyScraper;
    private ThriftyFoods thriftyFoods;

    @BeforeEach
    void setUp() {
        thriftyScraper = new ThriftyScraper();
        thriftyFoods = new ThriftyFoods("MockStore");
    }

    private String readHtmlFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    private Path createTempHtmlFile(String htmlContent) throws IOException {
        Path tempFile = Files.createTempFile("temp-thrifty-", ".html");
        Files.write(tempFile, htmlContent.getBytes());
        return tempFile;
    }

    @Test
    void testScrapePageSuccess() throws IOException {
        String url = "http://example.com";
        String htmlContent = readHtmlFile("src/model/bakery-commercial-Thrifty's");

        Path tempFile = createTempHtmlFile(htmlContent);
        WebDriver driver = new HtmlUnitDriver();
        ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        driver.get(tempFile.toUri().toString());

        thriftyScraper.scrapePage(url, thriftyFoods, driver);

        List<Product> products = thriftyFoods.getProducts();
        assertFalse(products.isEmpty());
        // Add assertions to verify the products
        assertTrue(products.stream().anyMatch(product -> product.getName().equals("ExpectedProductName1")));
    }

    @Test
    void testScrapePageNoProducts() throws IOException {
        String url = "http://example.com";
        String htmlContent = "<html><body>" +
                             "<div id='body_0_main_1_ProductSearch_GroceryBrowsing_TemplateResult_SearchResultListView_MansoryPanel'></div>" +
                             "</body></html>";

        Path tempFile = createTempHtmlFile(htmlContent);
        WebDriver driver = new HtmlUnitDriver();
        ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        driver.get(tempFile.toUri().toString());

        assertThrows(RuntimeException.class, () -> thriftyScraper.scrapePage(url, thriftyFoods, driver));
    }
}
