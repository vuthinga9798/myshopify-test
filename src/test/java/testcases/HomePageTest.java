package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homePage;
    private String testKeySearch = "top";
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://bc-sf-filter-demo-1.myshopify.com/collections/tops");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void VerifyThatProductReturnSearchResult() {
        homePage.openRegisterPage();
        homePage.inputSearchText(testKeySearch);
        homePage.verifyReturnSearchResult(testKeySearch);
    }
}
