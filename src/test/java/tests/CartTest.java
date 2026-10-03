package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {


        loginAsValidUser();


        HomePage homePage = new HomePage(driver);

        ProductsPage productsPage =
                homePage.clickProducts();


        productsPage.addFirstProductToCart();


        CartPage cartPage =
                productsPage.clickViewCart();


        Assert.assertTrue(
                cartPage.isProductInCart(),
                "Product tidak ditemukan di cart"
        );
    }
}