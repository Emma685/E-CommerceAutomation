package org.example.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.HomePage;
import org.example.pages.RegisterPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;


public class SD1_Register {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Given("Guest User Navigate to Register Page")
    public void navigateToRegister()
    {
        homePage.registerLink().click();
    }

    @And("^User choose Gender \"(.*)\"$")
    public void chooseGender(String gndr)
    {
        registerPage.gender(gndr).click();
    }

    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void enterName(String first,String last)
    {
        registerPage.firstName().sendKeys(first);
        registerPage.lastName().sendKeys(last);
    }

    @And("^user enter Date of Birth \"(.*)\"-\"(.*)\"-\"(.*)\"$")
    public void enterBD(String day, String month, String year)
    {
        Select bdDay = new Select(registerPage.bdDay());
        bdDay.selectByValue(day);

        Select bdMonth = new Select(registerPage.bdMonth());
        bdMonth.selectByVisibleText(month);

        Select bdYear = new Select(registerPage.bdYear());
        bdYear.selectByValue(year);
    }

    @And("^user enter Email \"(.*)\"$")
    public void enterEmail(String email) throws InterruptedException {
        registerPage.email().sendKeys(email);
        Thread.sleep(3000);
    }

    @And("^user enter password \"(.*)\"$")
    public void enterPass(String pass)
    {
        registerPage.password().sendKeys(pass);
    }

    @And("^User Confirm password \"(.*)\"$")
    public void confirmPass(String pass)
    {
        registerPage.confirmPassword().sendKeys(pass);
    }

    @And("user click on Register Button")
    public void register()
    {
        registerPage.registerBtn().click();
    }

    @Then("Success Message is displayed")
    public void resultAssurance() throws InterruptedException {
        Thread.sleep(3000);

        String expectedMsg = "Your registration completed";
        String actualMsg = registerPage.regMsg().getText();
        SoftAssert soft = new SoftAssert();

        if(actualMsg != null)
        {
            soft.assertTrue(actualMsg.contains(expectedMsg), "Error: Registration Message not as expected");
        }
        else{ System.out.println("Error: Actual Message is Null");}

        String expectedColor = "rgba(76, 177, 124, 1)";
        String actualColor = registerPage.regMsg().getCssValue("color");

        soft.assertTrue(actualColor.contains(expectedColor), "Error: Color not as expected");

        soft.assertAll();
    }


}
