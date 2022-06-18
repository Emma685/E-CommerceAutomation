package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SD7_FollowUs {

    HomePage homePage = new HomePage();
    List<WebElement> socialNetworks = homePage.networkLinks();

    @When("gust user click on Facebook Link")
    public void clickFacebook()
    {
        socialNetworks.get(0).click();
    }

    @Then("website open a new tab with Facebook page")
    public void facebookAssurance() throws InterruptedException
    {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        // Assure Social link is Clickable and opened a new tab
        Assert.assertTrue(tabs.size()>1,"Error: 1st Social Link didn't open a new tab");

        Hooks.driver.switchTo().window(tabs.get(1));
        String expectedURL = "https://www.facebook.com/nopCommerce";
        String actualURL = Hooks.driver.getCurrentUrl();

        // Assure correct relevant Social Link is Opened
        Assert.assertTrue(actualURL.contains(expectedURL),"Error: 1st Social Link didn't open Facebook");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
    }

    @When("gust user click on Twitter Link")
    public void clickTwitter()
    {
        socialNetworks.get(1).click();
    }

    @Then("website open a new tab with Twitter page")
    public void TwitterAssurance() throws InterruptedException
    {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        // Assure Social link is Clickable and opened a new tab
        Assert.assertTrue(tabs.size()>1,"Error: 2nd Social Link didn't open a new tab");

        Hooks.driver.switchTo().window(tabs.get(1));
        String expectedURL = "https://twitter.com/nopCommerce";
        String actualURL = Hooks.driver.getCurrentUrl();

        // Assure correct relevant Social Link is Opened
        Assert.assertTrue(actualURL.contains(expectedURL),"Error: 2nd Social Link didn't open Twitter");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
    }

    @When("gust user click on RSS Link")
    public void clickRSS()
    {
        socialNetworks.get(2).click();
    }

    @Then("website open a new tab with RSS page")
    public void rssAssurance() throws InterruptedException
    {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        // Assure Social link is Clickable and opened a new tab
        Assert.assertTrue(tabs.size()>1,"Error: 3rd Social Link didn't open a new tab");

        Hooks.driver.switchTo().window(tabs.get(1));
        String expectedURL = "https://demo.nopcommerce.com/new-online-store-is-open";
        String actualURL = Hooks.driver.getCurrentUrl();

        // Assure correct relevant Social Link is Opened
        Assert.assertTrue(actualURL.contains(expectedURL),"Error: 3rd Social Link didn't open RSS");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
    }

    @When("gust user click on YouTube Link")
    public void clickYouTube()
    {
        socialNetworks.get(3).click();
    }

    @Then("website open a new tab with YouTube page")
    public void youtubeAssurance() throws InterruptedException
    {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        // Assure Social link is Clickable and opened a new tab
        Assert.assertTrue(tabs.size()>1,"Error: 4th Social Link didn't open a new tab");

        Hooks.driver.switchTo().window(tabs.get(1));
        String expectedURL = "https://www.youtube.com/user/nopCommerce";
        String actualURL = Hooks.driver.getCurrentUrl();

        // Assure correct relevant Social Link is Opened
        Assert.assertTrue(actualURL.contains(expectedURL),"Error: 4th Social Link didn't open YouTube");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
    }


}
