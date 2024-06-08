package ordercraft.com.application.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration
public class TestsIntegrationDB {

    @Given("Register credentials user of the data base")
    public void registerCredentialsUserOfTheDataBase() {
    }

    @When("The data is userName = {string}, password = passwordTest and Role = {string}")
    public void theDataIsUserNamePasswordPasswordTestAndRole(String arg0, String arg1) {
    }

    @Then("The user save in the data base")
    public void theUserSaveInTheDataBase() {
    }
}
