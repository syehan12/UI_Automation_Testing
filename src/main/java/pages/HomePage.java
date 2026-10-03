package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(@href,'/login')]")
    WebElement signupLoginButton;

    @FindBy(xpath = "//a[contains(@href,'/products')]")
    WebElement productsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickSignupLogin() {
        click(signupLoginButton);
        return new LoginPage(driver);
    }

    public ProductsPage clickProducts() {
        click(productsButton);
        return new ProductsPage(driver);
    }
}