package TestNG_Sample;

import Framework.Core.CoreObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GearPage extends CoreObjects {

    public void clickOnCategory(String category) {
        //dl[@class='options']//a[.='Bags']
        //dl[@class='options']//a[.='Watches']
        //dl[@class='options']//a[.='Fitness Equipment']

        By section = By.xpath("//dl[@class='options']//a[.='" + category + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(section)).click();
    }
}
