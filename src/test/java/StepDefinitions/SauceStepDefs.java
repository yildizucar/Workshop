package StepDefinitions;

import Framework.Core.CoreObjects;
import Framework.Pojo.Customer;
import Framework.Pojo.User;
import Framework.Utilities.CommonMethods;
import Framework.Utilities.ConfigurationReader;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SauceStepDefs extends CoreObjects {
    Customer customer;

    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {   // login page parametreli
        // driver.get(url);
        pages.loginPage().openURL(url);
    }

    @Given("user is on landing page")
    @Given("I go to login page")
    public void i_go_to_login_page() {           // login page parametresiz  yaptik
        driver.get("https://www.saucedemo.com/");
        driver.get(ConfigurationReader.get("url"));
        pages.loginPage().openLoginPage();
        LoginPage.openLandingPage();
    }

    @When("user login as {string}")
    @Given("I login as {string}")
    public void i_login_as(String username) {
        pages.loginPage().openLoginPage();
        pages.loginPage().login(username);
    }

    @Given("I login")
    public void i_login() {
        pages.loginPage().openLoginPage();
        pages.loginPage().login();
    }

    @When("user login to the website")
    public void user_login_to_the_website(DataTable dataTable) {
        pages.loginPage().openLoginPage();
        pages.loginPage().login(dataTable);
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Then("verify login is successful")
    public void verify_login_is_successful() {
        // assertTrue(driver.getTitle().contentEquals("Swag Labs"));
        // assertEquals("Swag Labs", driver.getTitle());  once actual value , sonra excpected value
        // verify_title_is("Swag Labs");  ==> bu su demek 69 ine aslinda bir method.Sadece bunu yazarak  kullananbilrim. YANI step def, baska bir step def cagirabiliyoruz
        pages.verifyTitle("Swag Labs");
    }

    @Then("verify title is {string}")
    public void verify_title_is(String title) {
        assertEquals(title, driver.getTitle());
    }

    @Then("verify title is {string} in {string} page")
    public void verify_title_is_in_page(String title, String page) {

        switch (page.toLowerCase()) {
            case "product":
                pages.productsPage().verifyTitle(title);
                break;
            case "shopping":
                pages.shoppingCartPage().verifyTitle(title);
        }
    }

    @Then("verify page header is {string}")
    public void verify_page_header_is(String pageHeader) {
        assertEquals(pageHeader, pages.getPageHeader());//bizim firma bu sekilde kabul ediyor
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
    public void userAddFollowingItemsToCart(List<String> items) throws InterruptedException {
        pages.productsPage().addItemsToCart(items);
    }

    @And("^user (add|removes) \"([^\"]*)\" (?:to|from) shopping cart$")
    public void shoppingCart(String transaction, String product) throws InterruptedException {

        switch (transaction) {
            case "add":
                pages.productsPage().addItemToCart(product);
                break;
            case "removes":
                pages.productsPage().removeItem(product);
                break;
        }
    }

    @Then("verify shopping cart contains {int} item")
    public void verifyShoppingCartContainsItem(int expectedCount) {
        assertEquals(expectedCount, pages.productsPage().getShoppingCartItemCount());
    }




//     @Then("verify {int} product are listed on Products Page")
//     public void verifyProductAreListedOnProductsPage(int count ) {       // parametreye count dedik . Urunlein sayisi gelecek cunku
//         assertEquals(count ,pages.productsPage().getCountOfPruducts());  // verify dedigi icin once iki degeri karsilastirma var  actual ve expectedt
//                                                                          //Expected furuden gelen deger (6) ama count olarak parametre yaxdik

//     }
//     @And("verify that sort dropdown has this options")
//     public void verifyThatSortDropdownHasThisOptions(List<String>options ) { // 12-15 arasi data table var .stepdef create yapilinca 1. oncelik parametrelere isim vermek lazim -->(List<String>options )
//      pages.productsPage().verifySortDropDownOptions(options);              //assert ile yapilabilir yukardaki gibi farkli bir yontem deneyelim dedik2
//                                                                           //burada benim methodum -verifySortDropDownOptions- Dropdown da yazili olanlara bakacak ve Options parametresi ile karsilastiracak
//     //assertEquals(count ,pages.productsPage().getCountOfPruducts());    // buna benzerde yapabiliriz dedi aslinda ama farkli bir yol denedik

//    //Bazi firmalar 134 line bazilari 132 line gibi isteyebiliyor
//     }


    // ~~~~~~~~~~~~~~~~~~ DAY 3 ~~~~~~~~~~~~~~~~~~~~~~

    @Then("verify {int} product are listed on Products Page")
    public void verifyProductAreListedOnProductsPage(int count) {
        assertEquals(pages.productsPage().getCountOfProducts(), count);
        // or
        assertEquals(pages.productsPage().getProducts().size(), count);
    }

    @Then("^verify that sort dropdown has this options$")
    public void verifySortDropdownHasThisOptions(List<String> content) {
        pages.productsPage().verifySortDropdownOptions(content);
        // or
        assertEquals(content, pages.productsPage().getSortDropdownOptions());
    }

    @And("verify hamburger menu contains")
    public void verifyHamburgerMenuContains(List<String> expectedMenu) {
        pages.productsPage().openHamburgerMenu();
        assertEquals(expectedMenu, pages.productsPage().getHamburgerMenu());
    }

    @When("user sort the items by {string}")
    public void userSortTheItemsBy(String option) {
        pages.productsPage().sortProducts(option);  // ferureda ne yaziyorsa ona gore sort yapacak bir method lazim
    }


    // ~~~~~~~~~~~~~~~~~~ DAY 4 ~~~~~~~~~~~~~~~~~~~~~~

    @And("verify hamburger menu contains following submenus")
    public void verifyHamburgerMenuContainsFollowingSubmenus(String submenus) {
        assertEquals(submenus, pages.productsPage().getHamburgerMenu2());
    }

    @And("verify that items are sorted by {string}")
    public void verifyThatItemsAreSortedBy(String option) {
        pages.productsPage().verifyProductsSortedBy(option);
    }

    @And("wait for {int} seconds \\(for demo)")
    public void waitForSecondsForDemo(int second) {
        pages.waitFor(second);
    }

    @And("user navigates to the shopping cart")
    public void userNavigatesToTheShoppingCart() {
        pages.productsPage().navigateToShoppingCart();
    }

    @Then("verify that the added items are present in the cart")
    public void verifyThatTheAddedItemsArePresentInTheCart(List<String> expected) throws IOException {
        CommonMethods.takeScreenshot("listedItems");
        assertEquals(expected, pages.shoppingCartPage().getItemsFromShoppingCart());
    }

    
    @And("clicks on {string} button 2")
    public void clicksOnButton2(String button) {
        switch (button.toLowerCase()) {
            case "checkout":
                pages.shoppingCartPage().clickOnCheckoutButton();
                break;
            case "continue":
                pages.shoppingCartPage().clickOnContinueButton();
                break;
            case "finish":
                pages.shoppingCartPage().clickOnFinishButton();
                break;
        }
    }

    // or

    @And("clicks on {string} button")
    public void clicksOnButton(String buttonName) {
        pages.shoppingCartPage().clickOnButton(buttonName);
    }
    //bu alttaki  shoppingcartpage de hepsi click ve locator ayni hepsi ID var  bu ylla cozulebilir 220-227 ile
    //public void clickOnButton(String button) {
    //        wait.until(ExpectedConditions.elementToBeClickable(By.id(button.toLowerCase()))).click();//burada paramatirze yaptik
    //    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @And("user enters checkout information")
    public void userEntersCheckoutInformation(DataTable data) {
        pages.shoppingCartPage().fillCustomerInformation(data);
    }

    @Then("verify user sees the {string} message")
    public void verifyUserSeesTheMessage(String text) {
        assertTrue(pages.confirmationPage().getConfirmationMessage().contentEquals(text));
    }


    // ~~~~~~~~~~~~~~~~~~ DAY 5 ~~~~~~~~~~~~~~~~~~~~~~

    @Given("user login to page")
    public void userLoginToPage(DataTable dataTable) {
        User user = new User(dataTable);
        pages.loginPage().openLoginPage();
        pages.loginPage().login(user.getUsername(), user.getPassword());
    }

    @And("user enters checkout information \\(pojo)")
    public void userEntersCheckoutInformationPojo(DataTable dataTable) {
        customer = new Customer(dataTable);
     // pages.shoppingCartPage().fillCustomerInformation(customer.getFirstName(), customer.getLastName(), customer.getZipCode());
        pages.shoppingCartPage().fillCustomerInformation(customer);
    }

    @And("verify customer information displayed in X page")
    public void verifyCustomerInformationDisplayedInXPage() {

        // assertEquals(customer.getFirstName(), driver.findElement(By.id("")).getText());

    }

}
