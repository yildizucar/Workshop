package Java_for_Test_Automation;

public class D04_StringFormat {
    static String message = "Hello %s! How are you?";

    public static void main(String[] args) {
        getMessage("Ali");
    }

    private static void getMessage(String name) {

        String formattedMessage = String.format(message, name);
        System.out.println(formattedMessage);

    }
}
