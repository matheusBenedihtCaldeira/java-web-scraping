package org.rpa.webscraping.controller;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.rpa.webscraping.models.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebScraping {
    public static void main(String[] args) {
        extractData();
    }

    private static void extractData() {
        //Web driver config
        System.setProperty("webdriver.chrome.driver", "src/main/resources/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", null);
        WebDriver driver = new EdgeDriver(options = options);

        //access the page
        driver.get("https://www.kabum.com.br/");

        //Input for search
        WebElement input = driver.findElement(By.xpath("//input[@id=\"input-busca\"]"));
        input.sendKeys("placa de video 4060");
        input.submit();
        delay(2000);

        List<WebElement> productsDescriptions = driver.findElements(By.xpath("//span[@class=\"sc-d79c9c3f-0 nlmfp sc-cdc9b13f-16 eHyEuD nameCard\"]"));
        List<WebElement> productsPrice = driver.findElements(By.xpath("//span[@class=\"sc-620f2d27-2 bMHwXA priceCard\"]"));
        ArrayList<Product> products = new ArrayList<>();

        for(int i = 0; i < productsDescriptions.size(); i++){
            products.add(new Product(productsDescriptions.get(i).getText(), productsPrice.get(i).getText()));
        }
        for(Product product : products){
            System.out.println(product);
        }
        System.out.println("Produtos instanciado: " + products.size());
    }

    private static void delay(long delay) {
        try {
            new Thread().sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}