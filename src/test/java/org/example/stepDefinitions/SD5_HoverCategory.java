package org.example.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.CategoryPage;
import org.example.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

public class SD5_HoverCategory {

    HomePage homePage = new HomePage();
    CategoryPage categoryPage = new CategoryPage();
    Actions action = new Actions(Hooks.driver);
    Random randomIndex = new Random();
    String title;   // to include the Chosen category or sub-category name

    String expectedURL;
    // as the code is now dynamic so some of the categories have space or special characters
    // which is replaced by dash(-) in the actual URL, so instead of using .toLowerCase().trim()
    // I decided to get the expected URL from the WebElement directly.
    // as .trim() is not working and doesn't trim the title - I kept the steps for it as a comment
    // in the code, if you would like to try it.
    // and in comparing with page Title we don't need to use .toLowerCase().trim()


    @When("guest user hover on a category and click on Sub-category")
    public void hoverCategory()
    {
        List<WebElement> categories = homePage.categories();
        int categoryCount = categories.size();

        // to generate random int between 0 and categoryCount-1
        int categoryIndex = randomIndex.nextInt(categoryCount);

        // to hover on Random Category chosen by the categoryIndex
        action.moveToElement(categories.get(categoryIndex)).perform();

        title = categories.get(categoryIndex).getText();
        System.out.println("Chosen Category: " + title);

        expectedURL = homePage.getCategoryURL(categories.get(categoryIndex));
        System.out.println(expectedURL);


        // get a list of Sub-Categories if available
        List<WebElement> subCategories = homePage.subCategories(categories.get(categoryIndex));

        if(subCategories.isEmpty())
        {
            // click on main Category If there is no Sub-Categories
            categories.get(categoryIndex).click();
        }
        else
        {
            int subCategoryCount = subCategories.size();

            // to generate Random int between 0 and subCategoryCount-1
            int subIndex = randomIndex.nextInt(subCategoryCount);

            title = subCategories.get(subIndex).getText();
            System.out.println("Chosen Sub-Category: " + title);

            expectedURL = homePage.getCategoryURL(subCategories.get(subIndex));
            System.out.println(expectedURL);

            // to click on Random Sub-Category Chosen by the subIndex
            action.click(subCategories.get(subIndex)).perform();

        }

    }


    @Then("website goes to the chosen sub-category page")
    public void goToPageAssurance() throws InterruptedException
    {
        Thread.sleep(3000);
        SoftAssert soft = new SoftAssert();
        String actualURL = Hooks.driver.getCurrentUrl();
        String actualTitle = categoryPage.pageTitle().getText();

        //String str = title.toLowerCase().trim();
        //System.out.println(str);
        // In soft assert for URL I was using str instead of expectedURL

        soft.assertTrue(actualURL.contains(expectedURL),"Error: URL doesn't have Category/Sub-Category Name");
        soft.assertTrue(actualTitle.contains(title),"Error: Page Title doesn't match Category/Sub-Category Name");
        soft.assertAll();

    }




}
