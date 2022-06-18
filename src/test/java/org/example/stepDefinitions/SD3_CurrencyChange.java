package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SD3_CurrencyChange {

    HomePage homePage = new HomePage();

    @When("^guest user change currency to \"(.*)\"$")
    public void currencyChange(String currency)
    {
        Select currencyList = new Select(homePage.currencyList());
        currencyList.selectByVisibleText(currency);
    }


    @Then("All Product prices will change to be with Euro")
    public void priceAssurance()
    {
        String expected = "€";
        String actual = "";

        int size = homePage.priceTags().size();

        for(int i=0; i<size; i++)
        {
            actual = homePage.priceTags().get(i).getText();
            Assert.assertTrue(actual.contains(expected),"Error: Product "+i+" - No Euro Sign €");
        }
    }

}
