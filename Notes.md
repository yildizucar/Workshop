# Code Snippets

### Get text from List< WebElement>

```java
List<WebElement> items=driver.findElements(By.id("..."));
        List<String> productNames=new ArrayList<>();
        for(WebElement each:items){
        productNames.add(each.getText());
        }
```

or

```java
List<WebElement> items=driver.findElements(By.id("..."));
        List<String> productNames=items.stream().map(WebElement::getText).collect(Collectors.toList());
```

##### Sample method:

```java
public List<String> getSortDropdownOptions(){
        WebElement dropdown=driver.findElement(By.id("..."));
        Select select=new Select(dropdown);
        List<WebElement> dropdownOptions=select.getOptions();
        return dropdownOptions.stream().map(WebElement::getText).collect(Collectors.toList());
        }
```

### Sorted ( benim notum-day 4 )

```java

public void verifyProductsSortedBy(String option){
        switch(option){
        case"name":
        List<WebElement> itemNames=driver.findElements(By.className("inventory_item_name"));
        List<String> names=new LinkedList<>(); //linked list yaziyoruz cunku surasi onemli ise byaariz
        for(WebElement each:itemNames){
        names.add(each.getText());
        }
        assertTrue(isListSorted(names)); //method icinde method create yaptim  assertTrue(isListSorted  ==>
        break;
        case"price":
        List<WebElement> itemPrice=driver.findElements(By.className("inventory_item_price"));
        List<Double> prices=new LinkedList<>();
        for(WebElement each:itemPrice){            //$5.67 , fiyatlar boyle yaziyir. stringe cevirecegiz 5.17 sonra stringi double cevierecgix
        prices.add(Double.parseDouble(each.getText().replace("$","")));
        }
        assertTrue(isSorted(prices));
        break;
        }

        }

private static boolean isListSorted(List<String> list){  // alttaki method ile overloading oldu ayni method farkli parametre
        List<String> copy=new LinkedList<>(list); //LIST PARANTEZ ICINE YAZINCA 2 .BIR LISTI KOPYALAR
        Collections.sort(copy);  //LISTEM SORTED ISE HIC BIR DEGISIKLIK OLMAZ. ZATEN SIRALI ISE BIR DAHA DEGISMEZ
        return list.equals(copy);  //list.equals(copy) ILE IKI LISTENIN SIRALI OLUP OLMADIGINI KONTROL EDIYORUZ
        }

private static boolean isSorted(List<Double> list){
        List<Double> copy=new LinkedList<>(list);
        Collections.sort(copy);
        return list.equals(copy);
        }

```

### Click -switch methodu -Idler atni 2 yol ( benim notum-day 4 )

```java

@And("clicks on {string} button 2")
public void clicksOnButton2(String button){
        switch(button.toLowerCase()){
        case"checkout":
        pages.shoppingCartPage().clickOnCheckoutButton();
        break;
        case"continue":
        pages.shoppingCartPage().clickOnContinueButton();
        break;
        case"finish":
        pages.shoppingCartPage().clickOnFinishButton();
        break;
        }
        }

// or

@And("clicks on {string} button")
public void clicksOnButton(String buttonName){
        pages.shoppingCartPage().clickOnButton(buttonName);
        }

```

methodlar

```java
 public void clickOnCheckoutButton(){
        // driver.findElement(checkout).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
        }

public void clickOnContinueButton(){
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        }

public void clickOnFinishButton(){
        wait.until(ExpectedConditions.elementToBeClickable(finish)).click();
        }

//OR

public void clickOnButton(String button){
        wait.until(ExpectedConditions.elementToBeClickable(By.id(button.toLowerCase()))).click();//burada paramatirze yaptik
        }
```
#### ID locator kontrol etme ==> #firstname==> # bu isarti basina koy inspecte 