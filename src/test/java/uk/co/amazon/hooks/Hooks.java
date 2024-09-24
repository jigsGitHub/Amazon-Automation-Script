package uk.co.amazon.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import uk.co.amazon.propertyreader.PropertyReader;
import uk.co.amazon.utilities.Utility;


public class Hooks extends Utility {
    @Before
    public void setUp() {
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
