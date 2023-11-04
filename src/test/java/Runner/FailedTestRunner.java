package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "StepDefinitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {

}
// this runner does not create any report.
// to add report: "html:target/defult-cucumber-reports",
// if you use the same report name as your runner file, it will
// delete that report and create new one only for failed tests
// Use a different name to create a second report.