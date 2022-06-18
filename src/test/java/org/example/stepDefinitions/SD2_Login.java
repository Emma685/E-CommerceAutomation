package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;


public class SD2_Login {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("User Navigate to Login Page")
    public void navigateToLogin()
    {
        homePage.loginLink().click();
    }

    @When("^user enter valid Email \"(.*)\"$")
    public void validEmail(String email)
    {
        loginPage.email().sendKeys(email);
    }

    @And("^user enter valid Password \"(.*)\"$")
    public void validPass(String pass)
    {
        loginPage.password().sendKeys(pass);
    }

    @And("user click on Login Button")
    public void login()
    {
        loginPage.loginBtn().click();
    }

    @Then("User Login Successfully")
    public void validLoginAssurance() throws InterruptedException
    {
        Thread.sleep(3000);
        String expected = "https://demo.nopcommerce.com/";
        String actual = Hooks.driver.getCurrentUrl();

        SoftAssert soft = new SoftAssert();

        soft.assertTrue(actual.contains(expected),"Error: Wrong URL");

        WebElement myAccount = homePage.myAccountLink();

        if(myAccount != null)
        {
            soft.assertTrue(myAccount.isDisplayed(), "Error: My Account Tab NOT displayed");
        }
        else
        {
            System.out.println("Error: My Account WebElement is Null");
        }

        soft.assertAll();
    }



    @When("^user enter invalid Email \"(.*)\"$")
    public void invalidEmail(String email)
    {
        loginPage.email().sendKeys(email);
    }

    @And("^user enter invalid Password \"(.*)\"$")
    public void invalidPass(String pass)
    {
        loginPage.password().sendKeys(pass);
    }

    @Then("User CanNot Login and Fail Message is displayed")
    public void invalidLoginAssurance() throws InterruptedException
    {
        Thread.sleep(3000);
        String expectedMsg = "Login was unsuccessful";
        String actualMsg = loginPage.loginFailMsg().getText();

        SoftAssert soft = new SoftAssert();

        soft.assertTrue(actualMsg.contains(expectedMsg),"Error: Expected Message NOT displayed");

        String expectedColor = "#e4434b";
        String actualColor = Color.fromString(loginPage.loginFailMsg().getCssValue("color")).asHex();

        soft.assertTrue(actualColor.contains(expectedColor),"Different Actual Color");

        soft.assertAll();


    }

}
