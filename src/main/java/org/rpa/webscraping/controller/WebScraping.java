package org.rpa.webscraping.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Collections;

public class WebScraping {
    public static void main(String[] args) {
        extractData();
    }

    private static void extractData() {
        //web driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", null);

        WebDriver driver = new EdgeDriver(options = options);
        driver.get("https://www.kabum.com.br/");
    }
}
