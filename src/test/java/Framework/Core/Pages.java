package Framework.Core;

import Pages.*;

public class Pages extends BasePage {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ShoppingCartPage shoppingCartPage;
    private ConfirmationPage confirmationPage;

    public LoginPage loginPage() {
        if (loginPage == null)
            loginPage = new LoginPage();
        return loginPage;
    }

    public ProductsPage productsPage() {
        if (productsPage == null)
            productsPage = new ProductsPage();
        return productsPage;
    }

    public ShoppingCartPage shoppingCartPage() {
        if (shoppingCartPage == null)
            shoppingCartPage = new ShoppingCartPage();
        return shoppingCartPage;
    }

    public ConfirmationPage confirmationPage() {
        if (confirmationPage == null)
            confirmationPage = new ConfirmationPage();
        return confirmationPage;
    }

}
