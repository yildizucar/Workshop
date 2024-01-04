package Pages;

import Framework.Pojo.Customer;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCartPage extends BasePage {

    private final By addedItems = By.cssSelector(".inventory_item_name");
    private final By checkout = By.id("checkout");
    private final By finish = By.id("finish");
    private final By continueButton = By.id("continue");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeField = By.id("postal-code");


    public List<String> getItemsFromShoppingCart() {
        List<WebElement> items = driver.findElements(addedItems);
        return items.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickOnCheckoutButton() {
     // driver.findElement(checkout).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
    }

    public void clickOnContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void clickOnFinishButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finish)).click();
    }

    public void clickOnButton(String button) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(button.toLowerCase()))).click();
    }

    public void fillCustomerInformation(DataTable dataTable) {
        Map<String, String> info = dataTable.asMap();
        String firstName = info.get("firstName");
        String lastName = info.get("lastName");
        String zipCode = info.get("zipCode");

        if (firstName.contentEquals("random")) {
            firstName = faker.name().firstName();
        }
        if (lastName.contentEquals("random")) {
            lastName = faker.name().lastName();
        }
        if (zipCode.contentEquals("random")) {
            zipCode = faker.address().zipCode();
        }

        fillCustomerInformation(firstName, lastName, zipCode);
        // driver.findElement(firstNameField).sendKeys(firstName);
        // driver.findElement(lastNameField).sendKeys(lastName);
        // driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void fillCustomerInformation(String firstName, String lastName, String zipCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void fillCustomerInformation(Customer customer) {
        fillCustomerInformation(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getZipCode()
        );
    }
}
