package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags =  "@cucumber and not @ignore",
        features = {"src/test/resources/Features"},
        glue = {"StepDefinitions"},
        plugin = {
                "html:target/Cucumber-JVM-Reports/cucumber-reports/html-report",
                "junit:target/Cucumber-JVM-Reports/cucumber-reports/cucumber.xml",
                "json:target/json-report/cucumber.json",
                "rerun:target/rerun.txt",
        },
        monochrome = true,
        dryRun = false,
        publish = false
)
public class RunCucumberTest {
}
