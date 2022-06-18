package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoryPage {

    public WebElement pageTitle()
    {
        WebElement title = Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]"));
        return title;
    }


}
