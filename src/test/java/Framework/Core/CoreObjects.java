package Framework.Core;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreObjects {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;
    public static Actions actions;
    public static Alert alert;
    public static Faker faker = new Faker();
    public static Pages pages = new Pages();

}
