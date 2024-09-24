package uk.co.amazon.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import uk.co.amazon.browserfactory.ManageBrowser;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility extends ManageBrowser {

    /**
     * This method will click on element
     */
    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     * This method will get text from element
     */

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    //*************************** Action Methods ***************************************//


    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


//************************** ScreenShot Methods *********************************************//

    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // After execution, you could see a folder "FailedTestsScreenshots" under screenshot folder
        String destination = System.getProperty("user.dir") + "/src/test/resources/screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }

    //*************************Drag & Drop*********************************************

    public void dragSlider(By by, int xOffset) {
        WebElement slider = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(xOffset,0).release().perform();
    }

    public void dragPriceSlider(By minSliderLocator, By maxSliderLocator, int minOffset, int maxOffset) {
        dragSlider(minSliderLocator,minOffset);
        dragSlider(maxSliderLocator,maxOffset);
    }

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }
}
