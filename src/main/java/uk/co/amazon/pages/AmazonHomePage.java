package uk.co.amazon.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uk.co.amazon.utilities.Utility;

public class AmazonHomePage extends Utility {
    private static final Logger log = LogManager.getLogger(AmazonHomePage.class.getName());

    public AmazonHomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[@aria-label='Open Menu']")
    WebElement iconAllLink;

    @CacheLookup
    @FindBy(xpath = "//a[@class='hmenu-item']/div[contains(.,'Electronics & Computers')]")
    WebElement electronicsAndComputersLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(.,'Phones & Accessories')]")
    WebElement phonesAndAccessoriesLink;


    public String getURL(){
        return driver.getCurrentUrl();
    }

    public void clickOnAllLink() {
        clickOnElement(iconAllLink);
        log.info("Click on All Link : " + iconAllLink.toString());
    }

    public void clickOnElectronicAndComputersLink() {
        mouseHoverToElement(electronicsAndComputersLink);
        clickOnElement(electronicsAndComputersLink);
        log.info("Click on Electronic & Computers Link : " + electronicsAndComputersLink.toString());
    }

    public void clickOnPhonesAndAccessoriesLink() {
        mouseHoverToElement(phonesAndAccessoriesLink);
        clickOnElement(phonesAndAccessoriesLink);
        log.info("Click on Phones & Accessories : " + phonesAndAccessoriesLink.toString());
    }
}
