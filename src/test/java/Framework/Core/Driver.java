package Framework.Core;

import Framework.Utilities.ConfigurationReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver extends CoreObjects {
    private static String browser = "";

    private static final Logger log = LoggerFactory.getLogger(Driver.class);

    private Driver() {
        //Leave empty to prevent Driver class initialization
    }

    public synchronized static WebDriver getDriver() {      // only one thread can access the method at a time
        if (driver == null) {
            browser = System.getProperty("browser") != null ? System.getProperty("browser") : ConfigurationReader.get("browser");
        }
        return getDriver(browser);
    }

    public static WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "chromeHeadless":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "firefoxHeadless":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                break;
            case "ie":
                if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                    throw new WebDriverException("Your OS doesn't support Internet Explorer");
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                    throw new WebDriverException("Your OS doesn't support Edge");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                    throw new WebDriverException("Your OS doesn't support Safari");
                WebDriverManager.getInstance(SafariDriver.class).setup();
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Illegal browser type!");
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null)
            driver.quit();
        driver = null;
        log.info("driver closed");
    }
}