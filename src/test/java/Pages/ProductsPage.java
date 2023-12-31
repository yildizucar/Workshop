package Pages;

import Framework.Constants.ClickType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ProductsPage.class);

    private static final By shoppincCardCount = By.xpath("//span[@class='shopping_cart_badge']");
    private static final By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");
    private static final By sortProductsDropdown = By.className("product_sort_container");
    private static final By productNames = By.cssSelector(".inventory_item_name");
    private static final By subMenus = By.cssSelector(".menu-item");  //aslinda burada class="bm-item menu-item" NOT :.Class kullan ama burada item menu arasinda bosluk var oyuzden bi kismi aldik
    private static final String addToCartButtonTemplate = "//div[text()='%s']/../../following-sibling::div/button";


    public void addItemToCart(String productName) {

        // option 1
        // String product =  String.format("//div[text()='%s']/../../following-sibling::div/button", productName);
        // driver.findElement(By.xpath(product)).click();

        // option 2
        // String product = String.format(addToCartButtonTemplate, productName);
        //driver.findElement(By.xpath(product)).click();
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath(product))).click();

        // option 3
        // String product = "//div[text()='" + productName + "']/../../following-sibling::div/button";
        // driver.findElement(By.xpath(product)).click();

        // option 4
        // driver.findElement(By.xpath("//div[text()='" + productName + "']/../../following-sibling::div/button")).click();

        // option 5
        String product = String.format(addToCartButtonTemplate, productName);
        WebElement addToCartButton = driver.findElement(By.xpath(product));
        click(addToCartButton, ClickType.JSEXECUTOR);
        // clickWithJS(addToCartButton);

        log.info("{} is added to shopping cart", productName);

    }

    public void removeItem(String productName) {
        String product = String.format(addToCartButtonTemplate, productName);
        driver.findElement(By.xpath(product)).click();
    }

    public void addItemsToCart(List<String> items) {
        for (String each : items) {
            addItemToCart(each);     // islemi bu yapiyor  public void addItemToCart(String productName).Kactane item olursa olsun
        }
        // or
        // items.forEach(this::addItemToCart);  // kisa yolu buda
    }

    public int getShoppingCartItemCount() {
        String count = driver.findElement(shoppincCardCount).getText(); // get text ile aldigim stringi  Integer.parseInt(count) ile integera cevirdim
        return Integer.parseInt(count);
    }

// <<<<<<< yildiz
//     public int getCountOfPruducts() {
// //        List<WebElement> product = driver.findElements(By.cssSelector("inventory_item"));
// //        return product.size();
//         return driver.findElements(By.cssSelector(".inventory_item")).size(); //.inventory_item_name bu zpathde kullanabilir 6 tane gosteriyor
//     }

//     public void verifySortDropDownOptions(List<String> options) {
//         // dropdown konusunu handle yapan class - DropDown menulerini hangi sekillerde kac degisik yoldan secebilirsin
//         //select class ile -visible .option.

//         WebElement dropdown = driver.findElement(By.xpath("//select[@class ='product_sort_container'] "));
//         Select select = new Select(dropdown);
//         List<WebElement> content = select.getOptions();  //iki seyi karsilastirmam lazim . DropDowndakileri bulmam lazim  ve bunu Feature Fileden gelen  Stingden olusan listim ile karsilastirmam lazim
//         List<String> text = new ArrayList<>();            // 2 Ayni dataType karsilastirmam lazim. Bana Featuredan List string gelmis.Su an elimizde WebElementleden olusan bir liste var
//         for (WebElement each : content) {               //Burada da ListOf Stringe cevirmem gerekli
//             text.add(each.getText());                    //applicarindaki nametto z falan yazan yerdeki isimleri alamam gererkli,Bunlari alip Featiredeki liste ile karsilastirabileyim

//         }                                               //WebElelmntelrden olusan bir list var bunlarin gettext lerini almam lazim
//         assertEquals(options, text);                    //Text listini, contentden Textleri alip text dizisine atmam lazim
//     }                                                    //soru contenteki web elemnetlerdeki textleri alip nasil text e ekleyebilirim
//                                                    //Amac =text listine  her bir Webelementin getText ile textini  aliyor ve 84 deki textimize ekliyri
// }
// =======
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

    public void verifySortDropDownOptions(List<String> options) {
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select = new Select(dropdown);
        List<WebElement> content = select.getOptions();
        List<String> text = new ArrayList<>();
        for (WebElement each : content) {
            text.add(each.getText());
        }
        assertEquals(options, text);
    }

          /** or (short way)*/

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
        log.info("Items sorted by: {}", option);
    }

//    public List<String> getHamburgerMenu() {
//        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(subMenus)));
//        List<WebElement> menu = driver.findElements(subMenus); /// BURADAKI ELEMNETELRI GET TEXT ILE ALIYOR
//        List<String> subMenus = menu.stream().map(WebElement::getText).collect(Collectors.toList());   //YUKARDA ALDIGI TEXTLERI subMenus ile yeni bir liste yapiyor
//        return subMenus;
//    }

    /** OR   ALTTAKI GIBIDE YAZABILIRIZ =SELECT CLASS YOK. TABLODAKI HEADRLERI KONTROL ETMEK ISTIYORSUN MESELA ALLTAKI GIBI YAZAILABILRI */


//    public List<String> getHamburgerMenu() {
//        List<WebElement> menu = driver.findElements(subMenus);
//        return menu.stream().map(WebElement::getText).collect(Collectors.toList());
//
//    }


    public List<String> getHamburgerMenu() {
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(subMenus)));
        List<WebElement> menu = driver.findElements(subMenus);
        return getTextFromElements(menu);
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
        for (String each : subMenus) {
            output += each + ", ";
        }
        output = output.substring(0, output.length() - 2);
        return output;

        // or

        // return subMenus.stream()
        //        .map(String::valueOf)
        //        .collect(Collectors.joining(", "));
    }

    public void verifyProductsSortedBy(String option) {
        switch (option) {
            case "name":
                List<WebElement> itemNames = driver.findElements(By.className("inventory_item_name"));
                List<String> names = new LinkedList<>(); //linked list yaziyoruz cunku surasi onemli ise byaariz
                for (WebElement each : itemNames) {
                    names.add(each.getText());
                }
                assertTrue(isListSorted(names)); //method icinde method create yaptim  assertTrue(isListSorted  ==>
                break;
            case "price":
                List<WebElement> itemPrice = driver.findElements(By.className("inventory_item_price"));
                List<Double> prices = new LinkedList<>();
                for (WebElement each : itemPrice) {            //$5.67 , fiyatlar boyle yaziyir. stringe cevirecegiz 5.17 sonra stringi double cevierecgix
                    prices.add(Double.parseDouble(each.getText().replace("$", "")));
                }
                assertTrue(isSorted(prices));
                break;
        }

    }

    private static boolean isListSorted(List<String> list) {  // alttaki method ile overloading oldu ayni method farkli parametre
        List<String> copy = new LinkedList<>(list); //LIST PARANTEZ ICINE YAZINCA 2 .BIR LISTI KOPYALAR
        Collections.sort(copy);  //LISTEM SORTED ISE HIC BIR DEGISIKLIK OLMAZ. ZATEN SIRALI ISE BIR DAHA DEGISMEZ
        return list.equals(copy);  //list.equals(copy) ILE IKI LISTENIN SIRALI OLUP OLMADIGINI KONTROL EDIYORUZ
    }

    private static boolean isSorted(List<Double> list) {
        List<Double> copy = new LinkedList<>(list);
        Collections.sort(copy);
        return list.equals(copy);
    }

    public void navigateToShoppingCart() {
        driver.findElement(shoppingCart).click();
        log.info("User navigated to shopping cart");
    }
}
