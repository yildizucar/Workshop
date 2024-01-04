package Framework.Utilities;

import Framework.Constants.ClickType;
import Framework.Core.CoreObjects;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommonMethods extends CoreObjects {

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Screenshot
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void takeScreenshot(String filename) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("Reports/Screenshots/" + filename + ".jpg"));
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Click
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public void clickElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Performs double click action on an element
     */
    public static void doubleClick(WebElement element) {
        actions.doubleClick(element).build().perform();
    }


    public static void ClickOn(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        highlight(element);
        element.click();
    }

    public static void ClickOn(By by){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
        highlight(driver.findElement(by));
        driver.findElement(by).click();
    }

    public static void click(WebElement element, ClickType clickType){
        switch(clickType){
            case DEFAULT:
                element.click();
                break;
            case ACTIONS:
                actions.moveToElement(element).click().perform();
                break;
            case JSEXECUTOR:
                js.executeScript("arguments[0].scrollIntoView();", element);
                js.executeScript("arguments[0].click();", element);
        }
    }

    public void SendKeys(WebElement element, String data )  {
        wait.until(ExpectedConditions.visibilityOf(element));
        highlight(element);
        element.clear();
        element.sendKeys(data);
    }

    public static void highlight(WebElement element){
        //Yellow background color with solid red color border.
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }


    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Text
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static String getTextOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public List<String> getTextFromElements(List<WebElement> list) {
        // return list.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> text = new ArrayList<>();
        for(WebElement each: list){
            text.add(each.getText());
        }
        return text;
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Wait
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
