package Java_for_Test_Automation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D08_Map {
    static List<Map<String, String>> testData = new ArrayList<>();

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("username", "user123");
        map.put("password", "pass123");
        map.put("state", "FL");

        System.out.println(map);                        // {password=pass123, state=FL, username=user123}
        System.out.println(map.get("password"));        // pass123


        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        Map<String, String> map1 = new HashMap<>();
        map1.put("username", "user777");
        map1.put("password", "pass777");
        map1.put("state", "NY");

        Map<String, String> map2 = new HashMap<>();
        map2.put("username", "user999");
        map2.put("password", "pass999");
        map2.put("state", "CA");

        testData.add(map);
        testData.add(map1);
        testData.add(map2);
        System.out.println(testData);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        System.out.println(getStateOfUser("user777"));

    }

    public static String getStateOfUser(String user) {
        for (Map<String, String> each : testData) {
            if (each.get("username").contentEquals(user)) {
                return each.get("state");
            }
        }
        return "";
    }
}
