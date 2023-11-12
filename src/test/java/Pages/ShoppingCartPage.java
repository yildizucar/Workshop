package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPage extends BasePage {

    public List<String> getItemsInFromShoppingCart() {
        List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item_name"));
        List<String> names =items.stream().map(WebElement::getText).collect(Collectors.toList());
        return names;
    }
}
