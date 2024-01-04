# Code Snippets

### Get text from List< WebElement>

```java
List<WebElement> items = driver.findElements(By.id("..."));
List<String> productNames = new ArrayList<>();
for(WebElement each : items){
   productNames.add(each.getText());
}
```

or 

```java
List<WebElement> items = driver.findElements(By.id("..."));
List<String> productNames = items.stream().map(WebElement::getText).collect(Collectors.toList());
```

##### Sample method:
```java
public List<String> getSortDropdownOptions() {
   WebElement dropdown = driver.findElement(By.id("..."));
   Select select = new Select(dropdown);
   List<WebElement> dropdownOptions = select.getOptions();
   return dropdownOptions.stream().map(WebElement::getText).collect(Collectors.toList());
}
```