package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.util.ArrayList;

public class HomePage {
    WebDriverWait wait ;
    WebDriver driver;

    public HomePage(WebDriver _driver) {
        driver = _driver;
        wait = new WebDriverWait(_driver,120);
    }
    public By searchInput = By.id("boost-pfs-search-box-1");
    public By listProducts = By.xpath("//div[@data-group='products']//li[contains(@class, 'boost-pfs-search-suggestion-item')]");

    public void openRegisterPage(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchInput)));
        driver.findElement(searchInput).click();
    }
    public void inputSearchText(String key){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchInput)));
        driver.findElement(searchInput).sendKeys(key);
    }
    public void verifyReturnSearchResult(String key){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(listProducts)));
        ArrayList<WebElement> myElements = (ArrayList<WebElement>) driver.findElements(listProducts);
        for(WebElement e : myElements) {
            Assert.assertTrue(e.getText().toLowerCase().contains(key));
        }
    }
}
