package TestNG_Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static TestNG_Sample.Demo.driver;

public class NavigationPage {

    public void open() {
        driver.get("https://magento.softwaretestingboard.com/");
    }

    public void navigateToMenu(String mainMenu, String subMenu) {
        By menuItem = By.xpath("//span[.='" + mainMenu + "']/parent::a");
        WebElement menu = driver.findElement(menuItem);

        Actions action = new Actions(driver);
        action.moveToElement(menu).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='" + subMenu + "']/.."))).click();
    }

    public void clickOnGearMenu() {
        driver.findElement(By.xpath("//span[.='Gear']/parent::a")).click();
    }
}
