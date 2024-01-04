# Notes

---
## `Execution`

<details>
    <summary><b>Running Test</b></summary>

## [Running Tests]()
### How to run a specific scenario
```bash
mvn test -Dcucumber.filter.tags="@login"
mvn test -Dcucumber.filter.tags="@sauce and not @ignore"
```
```bash
mvn test -D cucumber.filter.name=".*Validate sort options.*"
mvn test -D cucumber.filter.name=".*<scenario name>.*"
```

### How to run scripts in a specific browser with Maven
```bash
mvn test -Dbrowser=chrome -Dcucumber.filter.tags="@tagname"
```
### Running only the scenarios that failed in the previous run
```bash
mvn test -Dcucumber.features="@target/rerun.txt"
```
</details>

## `Test Output`

<details>
    <summary><b>Reports</b></summary>

## [Supported Reports]()

Framework provides 3 different reports:
* [Spark(Extent) Reports](test-output/Spark/ExtentSpark.html)
* [Pdf](test-output/Pdf/ExtentPdf.pdf)
* [Cucumber JVM Report](target/cucumber-html-reports/overview-features.html)  (use `mvn verify` to generate JVM report)

To generate Extent reports (`html`, `excel`, `pdf`), set the values to **true** in `extent.properties` file

```properties
extent.reporter.spark.start=true
extent.reporter.excel.start=true
extent.reporter.html.start=true
extent.reporter.pdf.start=true
```
</details>

<details>
    <summary><b>Logs</b></summary>

## [Logging]()

[Logs](logs/automation.log) are created under logs package by using
* Logs are configured with the `log4j2.xml` file under *resources*
* Log instances are created with **LoggerFactory** class using SLF4j binding.

#### Option 1 (used in the framework)

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Navigation {
    private static Logger log = LoggerFactory.getLogger(Navigation.class);
    // ...
}
```

#### Option 2

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Navigation {
    private static Logger log = LogManager.getLogger(Navigation.class);
    // ...
}
```

`SLF4J`(Simple Logging Facade for Java) is an API designed to give generic access to many logging frameworks; log4j being one of them.

All you have to choose, which logging framework you need to use in runtime.
For that, you will have to include two jar files:

- SLF4j binding jar file
- Desired logging framework jar files   (for example: log4j)

SLF4J does not replace log4j, they work together. It removes the dependency on log4j from your application and make it
easy to replace it in future with more capable library. All you have to do is replace the binding and logging jar files (along with configuration file).

```java 
private static Logger logger = LoggerFactory.getLogger(HowToUseLogger.class);       // slf4j
private static Logger logger = LogManager.getLogger(LogLevelExample.class);         // log4j
```
----
</details>

----

# *Datatable*

---
```gherkin
When user login to the website
| username | standard_user |
| password | secret_sauce  |
```

>```jshelllanguage
>Map<String, String> credentials = dataTable.asMap();
>```

###### Example:
```jshelllanguage
public static void login(DataTable dataTable) {
    Map<String, String> credentials = dataTable.asMap();

    driver.findElement(usernameField).sendKeys(credentials.get("username"));
    driver.findElement(passwordField).sendKeys(credentials.get("password"));
    driver.findElement(loginButton).click();
}
```

```gherkin
Then verify the table has following headers
| Name    |
| DOB     |
| Address | 
```

>```jshelllanguage
>List<String> items
>```

```gherkin
Then verify the table has following headers
| Headers |
| Name    |
| DOB     |
| Address | 
```

>```jshelllanguage
> List<Map<String, String>> list = items.asMaps(String.class, String.class);
>```