import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P02_HomePage {
        SHAFT.GUI.WebDriver driver;
        //constructors
        P02_HomePage(SHAFT.GUI.WebDriver driver) {
            this.driver = driver;
        }
        //locators
        By menLink= By.xpath("//a[@href='#Men']");
        By ShirtLink= By.xpath("//a[@href=\"/category_products/3\"] [contains( .,'Tshirts')]");
        //methods
        public P03_productPage selectMenShirt() {
            driver.element().click(menLink)
                    .click(ShirtLink);
            return new P03_productPage(driver);
        }


}
