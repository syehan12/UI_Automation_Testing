package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

public class BaseTest {

    protected WebDriver driver;

    protected String email = "jakartabaru33@gmail.com";
    protected String password = "jakartabaru33";

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
    }

    protected void loginAsValidUser() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.clickSignupLogin();

        loginPage.login(email, password);

        Assert.assertTrue(
                loginPage.isLoginSuccessful(),
                "Login gagal"
        );
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}