package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.WishlistPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SD8_AddToWishlist {

    HomePage homePage = new HomePage();
    WishlistPage wishlistPage = new WishlistPage();
    int wishlistItemCount;

    @Given("guest user click on heart to add to wishlist")
    public void addToWishlist()
    {
        // get the current Wishlist Item Count
        // it displays as a text between brackets (0)
        // so we need to get the number which is between brackets
        String str = homePage.wishlistItemCount().getText();
        int strLength = str.length();
        str = str.substring(1,strLength-1);
        wishlistItemCount = Integer.valueOf(str);

        // add certain item "HTC One M8 Android L 5.0 Lollipop" to wishlist
        homePage.wishlistHeart().click();
    }

    @Then("Success Message appears with Green Background")
    public void successMsgAssurance()
    {
        Assert.assertTrue(homePage.successBar().isDisplayed(),"Error: Success Bar did NOT appear");

        String expectedMsg = "The product has been added to your wishlist";
        String actualMsg = homePage.successBar().getText();

        String expectedColor = "rgba(75, 176, 122, 1)";
        String actualColor = homePage.successBar().getCssValue("background-color");

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(actualMsg.contains(expectedMsg),"Error: Message is NOT as expected.");
        soft.assertTrue(actualColor.contains(expectedColor),"Error: Message Background Color is NOT as expected.");
        soft.assertAll();
    }

    @And("Wishlist item count in Home Page increased by one")
    public void wishlistItemCountAssurance()
    {
        // expected count should be = wishlistItemCount +1
        String strCount = homePage.wishlistItemCount().getText();
        strCount = strCount.substring(1,strCount.length()-1);
        int actualCount = Integer.valueOf(strCount);

        Assert.assertTrue(actualCount == wishlistItemCount+1,"Error: Wishlist Item Count was not updated");
    }

    @When("guest user navigate to Wishlist Page")
    public void goToWishlistPage()
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.invisibilityOf(homePage.successBar()));
        homePage.wishlistLink().click();
    }

    @Then("guest user can see item quantity number is greater than zero")
    public void quantityAssurance()
    {
        String quantity = wishlistPage.quantity().getAttribute("value");
        int actualQuantity = Integer.valueOf(quantity);

        Assert.assertTrue(actualQuantity > 0,"Error: Quantity was NOT updated on Wishlist Page");
    }




}
