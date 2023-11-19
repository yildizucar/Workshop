package TestNG_Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static TestNG_Sample.Demo.driver;

public class ProductPage {

    By sortDropDown = By.xpath("(//select[@id='sorter'])[1]");
    By pageHeader = By.id("page-title-heading");

    public void verifyPageHeader(String expectedPageHeader) {
        String header = driver.findElement(pageHeader).getText();
        Assert.assertEquals(header, expectedPageHeader);
    }

    public void sortItemsBy(String text) {
        Select select = new Select(driver.findElement(sortDropDown));
        select.selectByVisibleText(text);
    }

    public void verifyItemsSortedByPrice() {
        List<WebElement> priceElements = driver.findElements(By.xpath("//span[contains(@id, 'product-price')]/span"));
        List<Double> prices = new LinkedList<>();

        for (WebElement each : priceElements) {
            prices.add(Double.parseDouble(each.getText().replace("$", "")));
        }

        Assert.assertTrue(isSorted(prices));
    }

    public void verifyItemsSortedByName() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> itemNames = driver.findElements(By.cssSelector(".product-item-link"));
        List<String> names = new LinkedList<>();

        for (WebElement each : itemNames) {
            names.add(each.getText());
        }
        Assert.assertTrue(isListSorted(names));
    }

    private static boolean isListSorted(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return list.equals(copy);
    }

    private static boolean isSorted(List<Double> list) {
        List<Double> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return list.equals(copy);
    }
}
