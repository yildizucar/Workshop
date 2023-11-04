package Framework.Utilities;

import Framework.Core.CoreObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonMethods extends CoreObjects {

    public void clickElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
}
