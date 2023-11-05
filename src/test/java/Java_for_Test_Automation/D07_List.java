package Java_for_Test_Automation;

import java.util.Arrays;
import java.util.List;

public class D07_List {
    public static void main(String[] args) {
        List<String> expectedColumns = Arrays.asList("First Name", "Last Name", "Age", "Address");

        List<String> actualColumns = Arrays.asList("First Name", "Last Name", "Age", "Address");
        List<String> actualColumns2 = Arrays.asList("First Name", "Middle Name", "Last Name", "Age", "Address");

        System.out.println(expectedColumns.equals(actualColumns));          // true      ==> use this if you have exact match
        System.out.println(expectedColumns.contains(actualColumns));        // false
        System.out.println(expectedColumns.containsAll(actualColumns));     // true

        System.out.println(expectedColumns.equals(actualColumns2));         // false
        System.out.println(expectedColumns.contains(actualColumns2));       // false
        System.out.println(expectedColumns.containsAll(actualColumns2));    // false

        System.out.println(actualColumns2.containsAll(expectedColumns));    // true     ==> use this if actual list is larger


        // generally used when checking column headers, table values, menu items, dropdown options etc


        List<String> mixed = Arrays.asList("Age", "Address", "First Name", "Last Name");
        System.out.println(expectedColumns.containsAll(mixed));     // true
        System.out.println(mixed.containsAll(expectedColumns));     // true

    }
}
