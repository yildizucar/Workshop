package TestNG_Sample;

import Framework.Core.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo {
    public static WebDriver driver;
    NavigationPage navigationPage = new NavigationPage();
    ProductPage productPage = new ProductPage();
    GearPage gearPage = new GearPage();


    @BeforeMethod
    public void initializeDriver(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(priority = 1, description = "Verify sort functionality by product name")
    public void verifySortItemsByProductName() throws InterruptedException {

        navigationPage.open();
        navigationPage.navigateToMenu("Gear", "Watches");
        productPage.verifyPageHeader("Watches");
        productPage.sortItemsBy("Product Name");
        productPage.verifyItemsSortedByName();
    }

    @Test(priority = 2, description = "Verify sort functionality by price")
    public void verifySortItemsByPrice() {

        navigationPage.open();
        navigationPage.clickOnGearMenu();
        gearPage.clickOnCategory("Bags");
        productPage.verifyPageHeader("Bags");
        productPage.sortItemsBy("Price");
        productPage.verifyItemsSortedByPrice();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
