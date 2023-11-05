package Java_for_Test_Automation;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class D07_List_2 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("AA", "CC", "BB", "DD");

        Collections.sort(list);
        System.out.println(list);       // [AA, BB, CC, DD]

        Collections.reverse(list);
        System.out.println(list);       // [DD, CC, BB, AA]

        List<Integer> nums = Arrays.asList(1, 5, 10, 7);
        Collections.sort(nums);
        System.out.println(nums);      // [1, 5, 7, 10]

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println(isSorted(strings));
        Assertions.assertEquals("true", isSorted(strings));

    }

    private static boolean isSorted(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return list.equals(copy);
    }
}
