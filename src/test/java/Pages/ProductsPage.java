package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    public int getCountOfPruducts() {
//        List<WebElement> product = driver.findElements(By.cssSelector("inventory_item"));
//        return product.size();
        return driver.findElements(By.cssSelector(".inventory_item")).size(); //.inventory_item_name bu zpathde kullanabilir 6 tane gosteriyor
    }

    public void verifySortDropDownOptions(List<String> options) {
        // dropdown konusunu handle yapan class - DropDown menulerini hangi sekillerde kac degisik yoldan secebilirsin
        //select class ile -visible .option.

        WebElement dropdown = driver.findElement(By.xpath("//select[@class ='product_sort_container'] "));
        Select select = new Select(dropdown);
        List<WebElement> content = select.getOptions();  //iki seyi karsilastirmam lazim . DropDowndakileri bulmam lazim  ve bunu Feature Fileden gelen  Stingden olusan listim ile karsilastirmam lazim
        List<String> text = new ArrayList<>();            // 2 Ayni dataType karsilastirmam lazim. Bana Featuredan List string gelmis.Su an elimizde WebElementleden olusan bir liste var
        for (WebElement each : content) {               //Burada da ListOf Stringe cevirmem gerekli
            text.add(each.getText());                    //applicarindaki nametto z falan yazan yerdeki isimleri alamam gererkli,Bunlari alip Featiredeki liste ile karsilastirabileyim

        }                                               //WebElelmntelrden olusan bir list var bunlarin gettext lerini almam lazim
        assertEquals(options, text);                    //Text listini, contentden Textleri alip text dizisine atmam lazim
    }                                                    //soru contenteki web elemnetlerdeki textleri alip nasil text e ekleyebilirim
                                                   //Amac =text listine  her bir Webelementin getText ile textini  aliyor ve 84 deki textimize ekliyri
}


