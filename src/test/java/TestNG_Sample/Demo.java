package TestNG_Sample;

import Framework.Core.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo {
    public static WebDriver driver;
    @BeforeMethod
    public void initializeDriver(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(priority = 1, description = "Verify sort functionality by product name")
    public void verifySortItemsByProductName() throws InterruptedException {


    }

    @Test(priority = 2, description = "Verify sort functionality by price")
    public void verifySortItemsByPrice() {


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
