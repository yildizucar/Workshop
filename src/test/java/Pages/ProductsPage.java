package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductsPage extends BasePage {

    private static final By pageHeader = By.cssSelector(".title");
    private static final By shoppincCardCount = By.xpath("//span[@class='shopping_cart_badge']");
    private static final String product_template = "//div[text()='%s']/../../following-sibling::div/button";


    public void verifyPageHeader(String header) {
        assertEquals(header, getPageHeader());
    }

    public String getPageHeader() {
        // return driver.findElement(By.xpath("")).getText();
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

    public void removeItem(String product) {
        // if item is already added, it will be removed
        addItemToCart(product);

        // or
        // String product = String.format(product_template, productName);
        // driver.findElement(By.xpath(product)).click();
    }

    public void addItemsToCart(List<String> items) {
        for (String each : items) {
            addItemToCart(each);
        }
        //items.forEach(this::addItemToCart);
    }

    public int getShoppingCartItemCount() {
        String count = driver.findElement(shoppincCardCount).getText();
        return Integer.parseInt(count);
    }
}


