package Java_for_Test_Automation;

public class D05_StringManipulations {
    public static void main(String[] args) {

        String str = "CyberZone";
        StringBuilder sb = new StringBuilder("CyberZone");

        System.out.println(str.contains("Zone"));                   // true
        System.out.println(str.contains("zone"));                   // false

        System.out.println(str.equals("CyberZone"));                // true     ==> checks value and data type
        System.out.println(str.contentEquals("CyberZone"));     // true     ==> check only value
        System.out.println(str.contentEquals("cyberZONE"));     // false

        System.out.println(str.equals(sb));                         // false
        System.out.println(str.contentEquals(sb));                  // true

        System.out.println(str.equalsIgnoreCase("CYBERZONE"));  // true

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        System.out.println(str.split("Z")[0]);          // Cyber
        System.out.println(str.split("Z")[1]);          // one

        System.out.println(str.split("Zone")[0]);       // Cyber
        //System.out.println(str.split("Zone")[1]);           // Index 1 out of bounds for length 1

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        String s = "All Items, About, Logout, ";
        s = s.substring(0, s.length()-2);
        System.out.println(s);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        String priceStr = "$45.35";
        String clean = priceStr.replace("$", "");
        double price = Double.parseDouble(clean);

        System.out.println(price + 10);
        System.out.println(priceStr + 10);
    }

}
