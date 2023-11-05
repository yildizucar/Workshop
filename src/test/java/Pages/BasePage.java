package Pages;

import Framework.Utilities.CommonMethods;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class BasePage extends CommonMethods {
    public static final String SAUCEDEMO = "https://www.saucedemo.com/";


    public static final By menuButton = By.cssSelector(".bm-burger-button");
    public static final By closeMenuButton = By.cssSelector("#react-burger-cross-btn");
    public static final By resetAppStateButton = By.id("reset_sidebar_link");
    public static final By logoutButton = By.id("logout_sidebar_link");


    public void resetAppState() {
        clickElement(menuButton);
        clickElement(resetAppStateButton);
        clickElement(closeMenuButton);
    }

    public void logout() {
        clickElement(menuButton);
        clickElement(logoutButton);
    }

    public void verifyTitle(String title) {
        assertEquals(title, driver.getTitle());
    }
}
