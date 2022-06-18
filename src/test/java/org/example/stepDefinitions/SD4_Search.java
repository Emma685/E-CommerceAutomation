package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.ProductPage;
import org.example.pages.SearchPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SD4_Search {

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();

    @When("^guest user type product \"(.*)\" in searh box$")
    public void enterKeyword (String keyword)
    {
        homePage.searchBox().sendKeys(keyword);
    }

    @And("guest user click on Search Button")
    public void clickSearch()
    {
        homePage.searchBtn().click();
    }

    @Then("Website goes to Search Page")
    public void toSearchPageAssurance() throws InterruptedException
    {
        Thread.sleep(3000);
        String expectedURL = "https://demo.nopcommerce.com/search";
        String actualURL = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL),"Error: Didn't go to search page");
    }

    @And("^List of relevant \"(.*)\" products appears$")
    public void relevantProductsAssurance(String keyword)
    {
        List<WebElement> productsList = searchPage.productTitles();
        int size = productsList.size();

        for(int i=0; i<size; i++)
        {
            String actualTitle = productsList.get(i).getText();
            Assert.assertTrue(actualTitle.contains(keyword),"Error: Product "+i+" - Doesn't contain"+keyword);
        }
    }

    @When("^guest user type product \"(.*)\" in search box$")
    public void enterSKU (String sku)
    {
        homePage.searchBox().sendKeys(sku);
    }

    @And("guest user click on te product in search result")
    public void clickProduct()
    {
        List<WebElement> product = searchPage.productTitles();
        Assert.assertTrue(product.size()==1,"Error: Several Products with the same SKU ");
        product.get(0).click();
    }

    @Then("^product page appear with the same \"(.*)\" in product details$")
    public void skuAssurance(String sku) throws InterruptedException
    {
        Thread.sleep(3000);
        String actualSKU = productPage.skuField().getText();
        Assert.assertTrue(actualSKU.contains(sku),"Error: SKU wasn't found in Product's Details");
    }
}
