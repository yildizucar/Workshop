package Java_for_Test_Automation;

import Framework.Core.CoreObjects;

public class D04_StringFormat_2 extends CoreObjects {
    static String button_template = "//button[@label='%s']";

    public static void main(String[] args) {

        clickButton("Next");
        clickButton("Cancel");

    }

    private static void clickButton(String name) {
        String button = String.format(button_template, name);
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath(button))).click();
        System.out.printf("%s button is clicked\n", name);
    }


}
