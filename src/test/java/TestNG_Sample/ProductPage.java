package TestNG_Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static TestNG_Sample.Demo.driver;

public class ProductPage {



    private static boolean isListSorted(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return list.equals(copy);
    }

    private static boolean isSorted(List<Double> list) {
        List<Double> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return list.equals(copy);
    }
}
