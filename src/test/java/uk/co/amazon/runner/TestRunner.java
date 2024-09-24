package uk.co.amazon.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "uk.co.amazon",
        features = "src/test/java/resources/features",
        tags = "@regression",
        plugin = {"pretty", "html:target/cucuber-report/cucumber.html"}
)
public class TestRunner {
}
