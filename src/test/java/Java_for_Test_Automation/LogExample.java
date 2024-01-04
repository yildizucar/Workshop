package Java_for_Test_Automation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogExample {
    private static final Logger log = LoggerFactory.getLogger(LogExample.class);

    public static void main(String[] args) {

        log.info("This is a log message");

        String buttonName = "Next";
        String page = "Shopping";

        log.info("{} button is clicked", buttonName);

        log.info("{} button is clicked on {} page", buttonName, page );
    }
}
