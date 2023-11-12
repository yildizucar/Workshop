package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCartPage extends BasePage {

    private static final By addedItems = By.cssSelector(".inventory_item_name");

    public List<String> getItemsFromShoppingCart() {
        List<WebElement> items = driver.findElements(addedItems);
        return items.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
