import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class addProductTest {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON DataTest;

    @BeforeTest
    public void setUP() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://www.automationexercise.com/login");
    }

    @Test
    public void addProduct() {
        DataTest = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/TestData.json");
        P01_loginPage loginPage = new P01_loginPage(driver);
        loginPage.login(DataTest.getTestData("email"), DataTest.getTestData("password"))
                .selectMenShirt().findProductLessThan1000().navigateToCart();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
