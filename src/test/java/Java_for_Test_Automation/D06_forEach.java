package Java_for_Test_Automation;

import Framework.Core.CoreObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D06_forEach extends CoreObjects {
    public static void main(String[] args) {

        List<String> cities = Arrays.asList("New York", "Dallas", "Miami", "Istanbul");
        String str = "";

        for (String each : cities) {
            System.out.println(each);
            str += each + " ";
        }

        System.out.println(str.trim());

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        for (WebElement each : buttons) {
            if (each.getText().contentEquals("Next")) {
                each.click();
            }
        }

        List<WebElement> options = driver.findElements(By.id("dropdown"));
        List<String> dropdownOptions = new ArrayList<>();
        for (WebElement each : buttons) {
            dropdownOptions.add(each.getText());
        }
    }
}
