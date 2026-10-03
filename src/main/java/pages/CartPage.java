package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(xpath = "//td[contains(@class,'cart_description')]")
    private WebElement cartProduct;

    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    private WebElement proceedToCheckoutButton;

    @FindBy(id = "cart_info")
    private WebElement cartTable;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isProductInCart() {

        return isDisplayed(cartProduct);
    }

    public CheckoutPage clickProceedToCheckout() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        proceedToCheckoutButton
                )
        );

        click(proceedToCheckoutButton);

        return new CheckoutPage(driver);
    }
}