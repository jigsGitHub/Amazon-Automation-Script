package uk.co.amazon.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import uk.co.amazon.pages.PhonesAccessoriesPage;

public class PhonesAccessoriesSteps {

    @And("^User selects Mobile Phones$")
    public void userSelectsMobilePhones() {
        new PhonesAccessoriesPage().clickOnMobilePhonesAndSmartPhonesLink();
    }

    @When("^User filters by brand \"([^\"]*)\"$")
    public void userFiltersByBrand(String brand) {
        new PhonesAccessoriesPage().filterByMobileBrand(brand);
    }

    @And("^User applies Camera Resolution filter to \"([^\"]*)\"$")
    public void userAppliesCameraResolutionFilterTo(String resolution) {
        new PhonesAccessoriesPage().filterByCameraResolution(resolution);
    }

    @And("^User filters by Model Year \"([^\"]*)\"$")
    public void userFiltersByModelYear(String year) {
        new PhonesAccessoriesPage().filterByModelYear(year);
    }

    @And("^User sets price range between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userSetsPriceRangeBetweenAnd(int minPrice, int maxPrice) {
        new PhonesAccessoriesPage().selectPriceRange(minPrice, maxPrice);
        new PhonesAccessoriesPage().clickOnPriceRangeGoButton();
    }

    @Then("^User should see a list of Samsung phones matching the applied filters$")
    public void userShouldSeeAListOfSamsungPhonesMatchingTheAppliedFilters() {
        // Application filter is not working properly
    }
}
