package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage {

    public WebElement skuField()
    {
        WebElement sku = Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"]"));
        return sku;
    }

}
