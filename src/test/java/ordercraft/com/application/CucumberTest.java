package ordercraft.com.application;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "src/test/java/ordercraft/com/application/steps"
)
public class CucumberTest {
}
