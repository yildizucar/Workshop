package StepDefinitions;

import Framework.Pojo.Cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SampleStepDefs {
    private static Cucumber cucumber;

    @Given("there are {int} cucumbers")
    public void there_are_cucumbers(int amount) {
        cucumber = new Cucumber(amount);
    }

    @When("I eat {int} cucumbers")
    public void i_eat_cucumbers(int amount) {
        cucumber.eat(amount);
    }

    @Then("I should have {int} cucumbers left")
    public void i_should_have_cucumbers(int left) {
        Assert.assertEquals(cucumber.getCount(), left);
    }
}