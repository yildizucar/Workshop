package Java_for_Test_Automation;

public class D02_ifElse {
    public static void main(String[] args) {

        clickButton("Close");
        clickButton("Next");
        clickButton("Continue");

    }

    private static void clickButton(String buttonName) {

        if (buttonName.equalsIgnoreCase("Close")) {
            // click close button element
        } else if (buttonName.contentEquals("Next")) {
            // click next button element
        } else {
            System.out.printf("%s Button name not defined", buttonName);
            System.out.println();
            System.out.printf("\"%s\" Button name not defined", buttonName);
        }

    }


}
