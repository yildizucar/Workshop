package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ProductsPage.class);

    private static final By pageHeader = By.cssSelector(".title");
    private static final By shoppincCardCount = By.xpath("//span[@class='shopping_cart_badge']");
    private static final By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");
    private static final By sortProductsDropdown = By.className("product_sort_container");
    private static final By productNames = By.cssSelector(".inventory_item_name");
    private static final By subMenus = By.cssSelector(".menu-item");
    private static final String product_template = "//div[text()='%s']/../../following-sibling::div/button";


    public void verifyPageHeader(String header) {
        assertEquals(header, getPageHeader());
    }

    public String getPageHeader() {
        // return driver.findElement(pageHeader).getText();
        // return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title']"))).getText();
        // return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".title"))).getText();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader)).getText();
    }

    public void addItemToCart(String productName) {

        // option 1
        // String product =  String.format("//div[text()='%s']/../../following-sibling::div/button", productName);
        // driver.findElement(By.xpath(product)).click();

        // option 2
        String product = String.format(product_template, productName);
        driver.findElement(By.xpath(product)).click();

        // option 3
        // String product = "//div[text()='" + productName + "']/../../following-sibling::div/button";
        // driver.findElement(By.xpath(product)).click();

        // option 4
        // driver.findElement(By.xpath("//div[text()='" + productName + "']/../../following-sibling::div/button")).click();
    }

    public void removeItem(String productName) {
        // if item is already added, it will be removed
        addItemToCart(productName);

        // or
        // String product = String.format(product_template, productName);
        // driver.findElement(By.xpath(product)).click();
    }

    public void addItemsToCart(List<String> items) {
        for (String each : items) {
            addItemToCart(each);
        }
        // or
        // items.forEach(this::addItemToCart);
    }

    public int getShoppingCartItemCount() {
        String count = driver.findElement(shoppincCardCount).getText();
        return Integer.parseInt(count);
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~ DAY 3 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public int getCountOfProducts() {
        // List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item_name"));
        // return items.size();
        return driver.findElements(productNames).size();
    }

//    public List<String> getProducts() {
//        List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item_name "));
//        List<String> productNames = new ArrayList<>();
//        for(WebElement each : items){
//            productNames.add(each.getText());
//        }
//        return productNames;
//    }

    // or (short way)

    public List<String> getProducts() {
        List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item_name "));
        return items.stream().map(WebElement::getText).collect(Collectors.toList());
    }

//    public void verifySortDropDownOptions(List<String> options) {
//        WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
//        Select select = new Select(dropdown);
//        List<WebElement> content = select.getOptions();
//        List<String> text = new ArrayList<>();
//        for(WebElement each: content){
//            text.add(each.getText());
//        }
//        assertEquals(options,text );
//    }

    // or (short way)

    public void verifySortDropdownOptions(List<String> content) {
        WebElement dropdown = driver.findElement(sortProductsDropdown);
        Select select = new Select(dropdown);
        List<WebElement> dropdownOptions = select.getOptions();
        List<String> options = dropdownOptions.stream().map(WebElement::getText).collect(Collectors.toList());
        assertEquals(options, content);
    }

    public List<String> getSortDropdownOptions() {
        WebElement dropdown = driver.findElement(sortProductsDropdown);
        Select select = new Select(dropdown);
        List<WebElement> dropdownOptions = select.getOptions();
        return dropdownOptions.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void sortProducts(String option) {
        // supported parameters: Price (high to low)|Price (low to high)|Name (A to Z)|Name (Z to A)
        Select select = new Select(driver.findElement(sortProductsDropdown));
        select.selectByVisibleText(option);
    }

    public List<String> getHamburgerMenu() {
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(subMenus)));
        List<WebElement> menu = driver.findElements(subMenus);
        List<String> subMenus = menu.stream().map(WebElement::getText).collect(Collectors.toList());
        return subMenus;
    }

    public void openHamburgerMenu() {
        clickElement(menuButton);
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~ DAY 4 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public String getHamburgerMenu2() {
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(subMenus)));
        List<WebElement> menu = driver.findElements(subMenus);
        List<String> subMenus = menu.stream().map(WebElement::getText).collect(Collectors.toList());

        String output = "";
        for(String each : subMenus){
         output += each + ", ";
        }
        output = output.substring(0, output.length()-2);
        return output;

        // or

        // return subMenus.stream()
        //        .map(String::valueOf)
        //        .collect(Collectors.joining(", "));
    }

    public void verifyProductsSortedBy(String option) {
        switch(option){
            case "name":
                List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name"));
                List<String> names = new LinkedList<>();
                for(WebElement each: itemNames){
                    names.add(each.getText());
                }
                assertTrue(isListSorted(names));
                break;
            case "price":
                List<WebElement> itemPrice = driver.findElements(By.className("inventory_item_price"));
                List<Double> prices = new LinkedList<>();
                for(WebElement each: itemPrice){            //$5.67
                    prices.add(Double.parseDouble(each.getText().replace("$", "")));
                }
                assertTrue(isSorted(prices));
                break;
        }

    }

    private static boolean isListSorted(List<String> list) {
        List<String> copy = new LinkedList<>(list);
        Collections.sort(copy);
        return list.equals(copy);
    }

    private static boolean isSorted(List<Double> list) {
        List<Double> copy = new LinkedList<>(list);
        Collections.sort(copy);
        return list.equals(copy);
    }
}
