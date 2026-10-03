package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.clickSignupLogin();

        loginPage.login(
                "jakartabaru33@gmail.com",
                "jakartabaru33"
        );

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login gagal"
        );
    }
}