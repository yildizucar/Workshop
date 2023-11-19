package TestNG_Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static TestNG_Sample.Demo.driver;

public class NavigationPage {

    public static void open() {
        driver.get("https://magento.softwaretestingboard.com/");
    }


}
