package Pages;

import org.openqa.selenium.By;

public class ConfirmationPage extends BasePage {

    public String getConfirmationMessage() {
        return driver.findElement(By.xpath("//h2")).getText();
    }

}
