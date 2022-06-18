package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage {

    public List<WebElement> productTitles()
    {
        List<WebElement> products = Hooks.driver.findElements(By.cssSelector("div[class=\"product-item\"]"));
        return products;
    }


}
