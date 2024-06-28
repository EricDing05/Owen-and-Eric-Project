//package model.scraper;
//
//import model.AbstractStore;
//import model.Product;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//public class noFrillsScraper extends WebsiteScraper {
//
//
//    //EFFECTS: given the html product element, makes a product and adds it to store
//    public void createProduct(WebElement p, AbstractStore store) {
//        String name = p.findElement(By.xpath("//h3[contains(@class, 'chakra-heading') and contains(@class, 'css-')]\n")).getText();
//        WebElement priceElement = p.findElement(By.xpath(".//span[@data-testid='sale-price' or @data-testid='regular-price']//span[contains(@class, 'css-')]\n"));
//        String priceText = priceElement.getText().replace("$", "").replace("about", "").trim();
//        double price = Double.parseDouble(priceText);
//
//        String imgUrl = p.findElement(By.xpath(".//img[@alt]")).getAttribute("srcset");
//        String description = "n/a"; //There's no description
//        String storeName = store.getName();
//        System.out.println(name);
//        store.addProduct(new Product(name, price, imgUrl, description, storeName));
//    }
//
//}
