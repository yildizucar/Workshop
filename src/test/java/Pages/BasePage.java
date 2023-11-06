package Pages;

import Framework.Utilities.CommonMethods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;

public class BasePage extends CommonMethods {
    public static final String SAUCEDEMO = "https://www.saucedemo.com/";


    public static final By menuButton = By.cssSelector(".bm-burger-button");
    public static final By closeMenuButton = By.cssSelector("#react-burger-cross-btn");
    public static final By resetAppStateButton = By.id("reset_sidebar_link");
    public static final By logoutButton = By.id("logout_sidebar_link");
    public static final By pageHeader = By.className("title");


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
        Assertions.assertEquals(title, driver.getTitle());
    }

    public String getPageHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader)).getText();
    }
}
