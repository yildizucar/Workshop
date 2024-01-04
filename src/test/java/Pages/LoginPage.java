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


    public static void openLandingPage() {
        driver.get(ConfigurationReader.get("url"));
         //driver.get(SAUCEDEMO);
    }

    public void openURL(String url) {
        driver.get(url);
        log.info("Navigated to {}", url);
    }

    public void openLoginPage() {
        openURL(ConfigurationReader.get("url"));
    }

  //OVERLOADING = Ayni method ismi farkli paramatreler ==> public void login
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

        // or
        // driver.findElement(passwordField).sendKeys(password, Keys.ENTER);

        log.info("Login attempt by {}", username);
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

        // MAP de VALUE  okumak istiyorsam Get(key ) kullaniyoruz aslinda
        // driver.findElement(usernameField).sendKeys(credentials.get("username"));
        // driver.findElement(passwordField).sendKeys(credentials.get("password"));
        // driver.findElement(passwordField).sendKeys(credentials.get("password"), Keys.ENTER);   ==>  CLIK gorevini yapiyor oyuzden ekledik

    }


    public void verifyErrorMessage(String message) {
        String errorMessage = driver.findElement(By.xpath("//h3")).getText();
        assertTrue(errorMessage.contains(message));
        log.info("Expected message \"{}\"  validated!", message);
    }


}
