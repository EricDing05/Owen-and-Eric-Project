package model.scraper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import model.AbstractStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class CostcoScraper extends WebsiteScraper {


    //EFFECTS: Scrapes all the products off the website page
    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        WebElement gridElement = driver.findElement(By.xpath(store.getGridPath()));
        List<WebElement> productElements = gridElement.findElements(By.xpath(store.getProductPath()));
        System.out.println(productElements.size());
        if (productElements.size() == 0) {
            throw new RuntimeException();
        }
        for (WebElement e : productElements) {
            String s = e.findElement(By.xpath("//script[contains(text(), 'var adobeProductData')]")).getAttribute("innerHTML");
            parseJson(s);
        }
    }

    // EFFECTS: takes the JSON data from the website and parses it (currently just printing to console)
    private void parseJson(String input) {
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(input, JsonObject.class);
        String name = json.get("name").getAsString();
        Double price = json.get("priceTotal").getAsDouble();
        System.out.println(name + price);
    }

//    //EFFECTS: Scrapes all the products off the website page
//    public void scrapePage(String url, AbstractStore store, WebDriver driver) {
//        try {
//            driver.get(url);
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//            WebElement gridElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(store.getGridPath())));
//
//            List<WebElement> productTitles = gridElement.findElements(By.xpath(store.getProductPath()));
//
//            for (WebElement productTitle : productTitles) {
//                try {
//                    WebElement priceElement = productTitle.findElement(By.xpath(store.getInfoPath()));
//                    String priceText = priceElement.getText();
//                    System.out.println("Price: " + priceText);
//                } catch (Exception e) {
//                    System.out.println("Price element not found in this product tile.");
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println("An error occurred: " + ex.getMessage());
//            ex.printStackTrace();
//        } finally {
//            driver.quit();
//        }
//    }


}


