package StepDefinitions;

import Framework.Core.CoreObjects;
import Framework.Utilities.ConfigurationReader;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SauceStepDefs extends CoreObjects {


    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
        // driver.get(url);
        pages.loginPage().openURL(url);
    }

    @Given("user is on landing page")
    @Given("I go to login page")
    public void i_go_to_login_page() {
        driver.get("https://www.saucedemo.com/");
        driver.get(ConfigurationReader.get("url"));
        pages.loginPage().openLoginPage();
        LoginPage.openLandingPage();
    }

    @When("user login as {string}")
    @Given("I login as {string}")
    public void i_login_as(String username) {
        pages.loginPage().login(username);
    }

    @Given("I login")
    public void i_login() {
        pages.loginPage().login();
    }

    @When("user login to the website")
    public void user_login_to_the_website(DataTable dataTable) {
        pages.loginPage().login(dataTable);
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`

    @Then("verify login is successful")
    public void verify_login_is_successful() {
        // assertTrue(driver.getTitle().contentEquals("Swag Labs"));
        // assertEquals("Swag Labs", driver.getTitle());
        verify_title_is("Swag Labs");
    }

    @Then("verify title is {string}")
    public void verify_title_is(String title) {
        assertEquals(title, driver.getTitle());
    }

    @Then("verify title is {string} in {string} page")
    public void verify_title_is_in_page(String title, String page) {

        switch (page.toLowerCase()) {
            case "product":
                pages.productsPage().verifyTitle("Swag Labs");
                break;
            case "shopping":
                pages.shoppingCartPage().verifyTitle("...");
        }

    }

    @Then("verify page header is {string}")
    public void verify_page_header_is(String pageHeader) {
        pages.productsPage().verifyPageHeader("...");
        assertEquals(pageHeader, pages.productsPage().getPageHeader());
    }

    @Then("verify the {string} in login page")
    public void verify_the_in_login_page(String message) {
        pages.loginPage().verifyErrorMessage(message);
    }

    @Then("verify the {string} in {string} page")
    public void verify_the_in_page(String message, String page) {
        switch (page.toLowerCase()) {
            case "login":
                pages.loginPage().verifyErrorMessage(message);
                break;
        }
    }

    @And("user add following items to cart")
    public void userAddFollowingItemsToCart(List<String> items) {
        pages.productsPage().addItemsToCart(items);
    }

    @And("^user (add|removes) \"([^\"]*)\" (?:to|from) shopping cart$")
    public void shoppingCart(String transaction, String product) {

        switch (transaction) {
            case "add":
                pages.productsPage().addItemToCart(product);
                break;
            case "removes":
                pages.productsPage().removeItem(product);
                break;
        }
    }

//    @And("user add {string} to shopping cart")
//    public void userAddToShoppingCart(String productName) {
//        pages.productsPage().addItemToCart(productName);
//    }
//
//    @When("user removes {string} from shopping cart")
//    public void userRemovesFromShoppingCart(String productName) {
//
//    }

    @Then("verify shopping cart contains {int} item")
    public void verifyShoppingCartContainsItem(int expectedCount) {
        assertEquals(expectedCount, pages.productsPage().getShoppingCartItemCount());
    }






}
