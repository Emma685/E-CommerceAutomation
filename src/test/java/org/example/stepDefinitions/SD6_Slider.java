package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;

public class SD6_Slider {

    HomePage homePage = new HomePage();

    @When("^guest user click on slider \"(.*)\"$")
    public void clickSlider(String sliderNum)
    {
        homePage.slider(sliderNum).click();
    }

    @Then("website go to Nokia page")
    public void nokiaAssurance() throws InterruptedException
    {
        Thread.sleep(3000);
        String expectedURL = "https://demo.nopcommerce.com/nokia-lumia-1020";
        String actualURL = Hooks.driver.getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedURL),"Error: Slider 1 didn't navigate to expected URL (Nokia)");
    }

    @Then("website go to iphone 6 page")
    public void iphoneAssurance() throws InterruptedException
    {
        Thread.sleep(3000);
        String expectedURL = "https://demo.nopcommerce.com/iphone-6";
        String actualURL = Hooks.driver.getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedURL),"Error: Slider 2 didn't navigate to expected URL (iphone 6)");
    }



}
