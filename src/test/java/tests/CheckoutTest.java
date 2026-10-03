package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        loginAsValidUser();

        HomePage homePage = new HomePage(driver);

        ProductsPage productsPage =
                homePage.clickProducts();

        productsPage.addFirstProductToCart();

        CartPage cartPage =
                productsPage.clickViewCart();

        Assert.assertTrue(
                cartPage.isProductInCart(),
                "Product tidak ada di cart"
        );

        CheckoutPage checkoutPage =
                cartPage.clickProceedToCheckout();

        Assert.assertTrue(
                checkoutPage.isCheckoutPageDisplayed(),
                "Halaman checkout tidak tampil"
        );
    }
}