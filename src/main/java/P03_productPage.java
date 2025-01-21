import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_productPage {
    SHAFT.GUI.WebDriver driver;

    //constructors
    P03_productPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By AllproductsDiv = By.xpath("//div[@class='productinfo text-center']");
    By continueBtn = By.xpath("//button[@data-dismiss=\"modal\"]");
    By CartBtn = By.xpath("//ul[@class=\"nav navbar-nav\"]//a[@href=\"/view_cart\"][contains(.,' Cart')]");

    //methods
    @Step("Find products less than 1000")
    @Description("Find products less than 1000")
    public P03_productPage findProductLessThan1000() {
        List<WebElement> Allproducts = driver.getDriver().findElements(AllproductsDiv);
        try {
            for (int i = 0; i < Allproducts.size(); i++) {
                int productPrice = Integer.parseInt(driver.getDriver().findElement(By.xpath("(//div[@class=\"productinfo text-center\"]/h2)[" + (i + 1) + "]")).
                        getText().replaceAll("[^0-9]", ""));

                System.out.println("Price of Product  " + (i + 1));
                if (productPrice < 1000) {
                    driver.element().click(By.xpath("(//div[@class=\"productinfo text-center\"])[" + (i + 1) + "]/a")).
                            click(continueBtn);
                    System.out.println("Added product with price  " + productPrice + "To the cart");
                }

            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    @Step("Navigate to Cart")
    @Description("Navigate to Cart")
    public void navigateToCart() {
        driver.element().click(CartBtn)
                .and().browser().captureScreenshot();
    }


}
