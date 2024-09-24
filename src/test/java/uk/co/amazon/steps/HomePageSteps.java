package uk.co.amazon.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import uk.co.amazon.pages.AmazonHomePage;

import java.util.Arrays;

public class HomePageSteps {
    String actualURLText;
    String expectedURLText = "https://www.amazon.co.uk/";

    @Given("^User navigates to Amazon UK website$")
    public void userNavigatesToAmazonUKWebsite() {
        actualURLText = new AmazonHomePage().getURL();
        System.out.println("Actual Text: " + actualURLText);
        System.out.println("Expected URL Text: " + expectedURLText);
        Assert.assertEquals("Amazon Home page is not displayed", expectedURLText,actualURLText);
    }

    @When("^User navigates to Electronics and Computers$")
    public void userNavigatesToElectronicsAndComputers() {
        new AmazonHomePage().clickOnAllLink();
        new AmazonHomePage().clickOnElectronicAndComputersLink();
    }

    @And("^User selects Phones and Accessories$")
    public void userSelectsPhonesAndAccessories() {
        new AmazonHomePage().clickOnPhonesAndAccessoriesLink();
    }

}
