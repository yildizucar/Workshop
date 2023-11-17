package Java_for_Test_Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Interview {

    @Test
    public void demo() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
     // WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("http://www.saucedemo.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement usernameField = driver.findElement(By.id("user-name"));      // option[1]
        usernameField.sendKeys("standard_user");    // (1)
        // or
        // wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys("standard_user");   // (2)

        By passwordField = By.id("password");                                   // option[2]
        driver.findElement(passwordField).sendKeys("secret_sauce", Keys.ENTER);         // 1

        // or
        // driver.findElement(passwordField).sendKeys("secret_sauce")                               // 2
        // driver.findElement(By.id("login-button")).click();


        String pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title"))).getText();
        Assertions.assertEquals("Products", pageHeader);
        driver.quit();

    }
}
