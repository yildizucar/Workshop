package Java_for_Test_Automation;

import org.junit.jupiter.api.Assertions;

// METHODS (functions)
// void or return
// static or not
public class D01_Method_Creation {
    public static void main(String[] args) {

        Demo demo = new Demo();
        demo.clickOnCloseButton();          // Calling a Method using object
        Demo.clickOnContinueButton();       // Calling a Method using class name

        Assertions.assertEquals("Welcome", demo.getMessage());
        Assertions.assertEquals(4, demo.getRowCount());

    }
}

class Demo {

    public static void clickOnContinueButton() {
        System.out.println("I clicked on continue button");
    }

    public void clickOnCloseButton() {
        System.out.println("I clicked on close button");
    }

    public String getMessage() {
        return "Welcome";
    }

    public int getRowCount() {
        // return driver.findElements(By.xpath("")).size();
        return 4;
    }
}
