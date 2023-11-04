package Pages;

import Framework.Utilities.ConfigurationReader;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private static final By usernameField = By.id("user-name");
    private static final By passwordField = By.id("password");
    private static final By loginButton = By.id("login-button");

    public void openLandingPage() {
        driver.get(ConfigurationReader.get("url"));
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        log.info("{} logged in", username);
    }

    public void login(DataTable dataTable) {
        Map<String, String> credentials = dataTable.asMap();
        login(credentials.get("username"), credentials.get("password"));
    }

    public void verifyErrorMessage(String message) {
        String errorMessage = driver.findElement(By.xpath("//h3")).getText();
        assertTrue(errorMessage.contains(message));
    }
}
