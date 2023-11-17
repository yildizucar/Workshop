package Framework.Utilities;

import Framework.Core.CoreObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommonMethods extends CoreObjects {

    public void clickElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public List<String> getTextFromElements(List<WebElement> list) {
        // return list.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> text = new ArrayList<>();
        for(WebElement each: list){
            text.add(each.getText());
        }
        return text;
    }

    /**
     * Performs a pause
     *
     * @param seconds
     */
    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
