package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(),'Address Details')]")
    private WebElement addressDetails;

    @FindBy(xpath = "//h2[contains(text(),'Review Your Order')]")
    private WebElement reviewOrder;

    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCheckoutPageDisplayed() {

        return isDisplayed(addressDetails)
                && isDisplayed(reviewOrder);
    }

    public void clickPlaceOrder() {

        click(placeOrderButton);
    }
}