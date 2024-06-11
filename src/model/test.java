package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class test {

    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();

        driver.get("https://www.walmart.ca/en/shop/weekly-flyer-features/6000196190101?catId=10019&icid=cp_l1_page_grocery_savings_weekly_flyer_56871_LY6XMFKK3F");

    }

}

