package Pages;

import Framework.Utilities.ConfigurationReader;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {

    private static final By usernameField = By.id("user-name");
    private static final By passwordField = By.id("password");
    private static final By loginButton = By.id("login-button");


    public static void openLandingPage() {
        driver.get(ConfigurationReader.get("url"));
        // driver.get(SAUCEDEMO);
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public void openLoginPage() {
        openURL(ConfigurationReader.get("url"));
    }


    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

        // or
        // driver.findElement(passwordField).sendKeys(password, Keys.ENTER);
    }

    public void login(String username) {
        login(username, ConfigurationReader.get("password"));
    }

    public void login() {
        login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }


    public void login(DataTable dataTable) {
        Map<String, String> credentials = dataTable.asMap();
        login(credentials.get("username"), credentials.get("password"));

        // driver.findElement(usernameField).sendKeys(credentials.get("username"));
        // driver.findElement(passwordField).sendKeys(credentials.get("password"));
        // driver.findElement(passwordField).sendKeys(credentials.get("password"), Keys.ENTER);

    }


    public void verifyErrorMessage(String message) {
        String errorMessage = driver.findElement(By.xpath("//h3")).getText();
        assertTrue(errorMessage.contains(message));
    }


}
