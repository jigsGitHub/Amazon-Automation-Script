package uk.co.amazon.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.amazon.utilities.Utility;

public class PhonesAccessoriesPage extends Utility {
    private static final Logger log = LogManager.getLogger(PhonesAccessoriesPage.class.getName());

    public PhonesAccessoriesPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[contains(.,'Mobile Phones & Smartphones')]")
    WebElement mobilePhonesAndSmartPhonesLink;

    @CacheLookup
    @FindBy(xpath = "//div[@class='a-section s-range-input-container s-lower-bound aok-relative']/input")
    WebElement minSliderLocator;

    @CacheLookup
    @FindBy(xpath = "//div[@class='a-section s-range-input-container s-upper-bound']/input")
    WebElement maxSliderLocator;

    @CacheLookup
    @FindBy(xpath = "//input[@aria-label='Go - Submit price range']")
    WebElement priceRangeGoButton;

    WebElement mobileBrandCheckBox;
    WebElement cameraResolution;
    WebElement modelYear;

    public void clickOnMobilePhonesAndSmartPhonesLink() {
        mouseHoverToElement(mobilePhonesAndSmartPhonesLink);
        clickOnElement(mobilePhonesAndSmartPhonesLink);
        log.info("Click on Mobile Phones & Smartphones : " + mobilePhonesAndSmartPhonesLink.toString());
    }

    public void filterByMobileBrand(String brand) {
        mobileBrandCheckBox = driver.findElement(By.xpath("//input[@aria-labelledby='" + brand + "']"));
        mouseHoverToElement(mobileBrandCheckBox);
        clickOnElement(mobileBrandCheckBox);
        log.info("Filter Mobile brand : " + mobileBrandCheckBox.toString());
    }

    public void filterByCameraResolution(String resolution) {
        cameraResolution = driver.findElement(By.xpath("//li[@aria-label='" + resolution + "']"));
        mouseHoverToElement(cameraResolution);
        clickOnElement(cameraResolution);
        log.info("Filter Camera Resolution : " + cameraResolution.toString());
    }

    public void filterByModelYear(String year) {
        modelYear = driver.findElement(By.xpath("//li[@aria-label='" + year + "']"));
        mouseHoverToElement(modelYear);
        clickOnElement(modelYear);
        log.info("Filter Model Year : " + modelYear.toString());
    }

    public void selectPriceRange(int minPrice, int maxPrice) {
        mouseHoverToElement(minSliderLocator);
        dragPriceSlider((By) minSliderLocator, (By) maxSliderLocator, minPrice, maxPrice);
        log.info("Select Price Range : " + mobileBrandCheckBox.toString());
    }

    public void clickOnPriceRangeGoButton(){
        mouseHoverToElement(priceRangeGoButton);
        clickOnElement(priceRangeGoButton);
    }
}
