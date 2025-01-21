import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class P02_HomePage {
    SHAFT.GUI.WebDriver driver;

    //constructors
    P02_HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By menLink = By.xpath("//a[@href='#Men']");
    By ShirtLink = By.xpath("//a[@href=\"/category_products/3\"] [contains( .,'Tshirts')]");

    //methods
    @Step("Select Shirt Category")
    @Description("Select Shirt Category")
    public P03_productPage selectMenShirt() {
        driver.element().click(menLink)
                .click(ShirtLink);
        return new P03_productPage(driver);
    }


}
