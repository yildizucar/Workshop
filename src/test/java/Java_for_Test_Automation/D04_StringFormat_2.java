package Java_for_Test_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D04_StringFormat_2 {
    static WebDriverWait wait;
    static String button_template = "//button[@label='%s']";

    public static void main(String[] args) {

        clickOnButton("Next");
        clickOnButton("Cancel");

    }

    private static void clickOnButton(String name) {
        String button = String.format(button_template, name);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(button))).click();
        System.out.printf("%s button clicked\n", name);
    }


}
