package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;

public class ProductTest extends BaseTest {

    @Test
    public void searchProductTest() {

        HomePage homePage = new HomePage(driver);

        ProductsPage productsPage = homePage.clickProducts();

        productsPage.searchProduct("Blue Top");

        Assert.assertTrue(
                productsPage.isProductDisplayed(),
                "Product tidak ditemukan"
        );
    }
}