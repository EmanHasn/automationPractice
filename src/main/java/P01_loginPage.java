import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class P01_loginPage {
    SHAFT.GUI.WebDriver driver;
    //constructors
    P01_loginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    //locators
    By emailInput = By.xpath("//input[@data-qa='login-email']");
    By passwordInput = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");
    //methods
    public P02_HomePage login(String email, String password) {
        driver.element().type(emailInput, email)
                .type(passwordInput, password)
                .click(loginButton);
        return new P02_HomePage(driver);
    }

//    public void verifyLogin() {
//        driver.findElement("welcome_message").isDisplayed();
//    }


}
