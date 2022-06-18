package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WishlistPage {

    public WebElement quantity ()
    {
        WebElement qty = Hooks.driver.findElement(By.cssSelector("input[class=\"qty-input\"]"));
        return qty;
    }


}
