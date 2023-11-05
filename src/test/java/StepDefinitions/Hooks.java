package StepDefinitions;

import Framework.Core.CoreObjects;
import Framework.Core.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hooks extends CoreObjects {

    @Before(value = "not @hookless")
    public void initializeDriver() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        initObjects();
    }

    @After(value = "not @hookless")
    public void tearDown() {
        Driver.closeDriver();
    }

    public void initObjects() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

}
