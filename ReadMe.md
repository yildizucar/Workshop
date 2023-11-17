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
mvn test `-Dbrowser=chrome` -Dcucumber.filter.tags="@tagname"
```
### Running only the scenarios that failed in the previous run
```bash
mvn test -Dcucumber.features="@target/rerun.txt"
```
</details>

<br>

![](img/divider.png)


# *Datatable*

---
```gherkin
When user login to the website
| username | standard_user |
| password | secret_sauce  |
```

#### Option 1

```jshelllanguage
public static void login(DataTable dataTable) {
    Map<String, String> credentials = dataTable.asMap();

    driver.findElement(usernameField).sendKeys(credentials.get("username"));
    driver.findElement(passwordField).sendKeys(credentials.get("password"));
    driver.findElement(loginButton).click();
}
```