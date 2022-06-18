package org.example.pages;

import org.example.stepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HomePage {

    public WebElement registerLink()
    {
        WebElement regLink = Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
        return regLink;
    }


    public WebElement loginLink()
    {
        WebElement loginLink = Hooks.driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
        return loginLink;
    }


    public WebElement wishlistLink()
    {
        WebElement wishlistLink = Hooks.driver.findElement(By.cssSelector("a[class=\"ico-wishlist\"]"));
        return wishlistLink;
    }


    public WebElement myAccountLink()
    {
        WebElement myAccount = Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));
        return myAccount;
    }


    public WebElement currencyList()
    {
        WebElement list = Hooks.driver.findElement(By.id("customerCurrency"));
        return list;
    }


    public List<WebElement> priceTags()
    {
        List<WebElement> prices = Hooks.driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"));
        return prices;
    }


    public WebElement searchBox()
    {
        WebElement box = Hooks.driver.findElement(By.id("small-searchterms"));
        return box;
    }


    public WebElement searchBtn()
    {
        WebElement btn = Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
        return btn;
    }


    public List<WebElement> categories()
    {
        List<WebElement> categories =
                Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));

        return categories;
    }


    public List<WebElement> subCategories(WebElement category)
    {
        List<WebElement> subCategories = category.findElements(By.tagName("li"));
        return subCategories;
    }

    public String getCategoryURL(WebElement category)
    {
        String url = category.findElement(By.tagName("a")).getAttribute("href");
        return url;
    }


    public WebElement slider(String sliderNum)
    {
        WebElement slider =
                Hooks.driver.findElement(By.cssSelector("#nivo-slider > a:nth-child("+sliderNum+")"));
        return slider;
    }


    public List<WebElement> networkLinks()
    {
        List<WebElement> networks = Hooks.driver.findElements(By.xpath("//ul[@class=\"networks\"]/li"));
        return networks;
    }


    public WebElement wishlistHeart()
    {
        // This is specific to the item "HTC One M8 Android L 5.0 Lollipop" in home page
        WebElement heart =
                Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]"));
        return heart;
    }


    public WebElement successBar()
    {
        WebElement bar = Hooks.driver.findElement(By.cssSelector("div[id=\"bar-notification\"] div"));
        return bar;
    }


    public WebElement wishlistItemCount()
    {
        WebElement count = Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-qty\"]"));
        return count;
    }





}



