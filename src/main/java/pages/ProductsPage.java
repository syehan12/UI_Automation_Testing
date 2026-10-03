package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    @FindBy(id = "search_product")
    private WebElement searchField;

    @FindBy(id = "submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'productinfo')]")
    private WebElement productResult;

    @FindBy(xpath = "(//div[contains(@class,'productinfo')]//a[contains(text(),'Add to cart')])[1]")
    private WebElement firstProductAddToCart;

    @FindBy(xpath = "//u[contains(text(),'View Cart')]")
    private WebElement viewCartButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitUntilPageLoaded() {

        wait.until(
                ExpectedConditions.visibilityOf(searchField)
        );
    }

    public void searchProduct(String product) {

        waitUntilPageLoaded();

        inputText(searchField, product);

        click(searchButton);
    }

    public boolean isProductDisplayed() {

        return isDisplayed(productResult);
    }

    public void addFirstProductToCart() {

        wait.until(
                ExpectedConditions.visibilityOf(firstProductAddToCart)
        );

        click(firstProductAddToCart);
    }

    public CartPage clickViewCart() {

        click(viewCartButton);

        return new CartPage(driver);
    }
}