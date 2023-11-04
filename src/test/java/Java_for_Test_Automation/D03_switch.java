package Java_for_Test_Automation;

public class D03_switch {
    public static void main(String[] args) {

        clickButton("Close");
        clickButton("Next");
        clickButton("Continue");

        clickButton("next");
        clickButton("NEXT");

    }

    private static void clickButton(String buttonName) {
        switch (buttonName.toLowerCase()) {
            case "close":
                // click close button element
                break;
            case "next":
                // click next button element
                break;
        }
    }
}
