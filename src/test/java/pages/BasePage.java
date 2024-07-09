package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.*;
import java.util.*;

public class BasePage {
    protected static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    static{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasePage (WebDriver driver){
        BasePage.driver = driver;
    }
    public static void navigateTo(String url) {
        driver.get(url);
    }
    public static void closeBrowser(){
        driver.quit();
    }
    private WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    public void clickElement (String locator){
        find(locator).click();
    }
    public void  write (String locator, String KeyToSend){
        find(locator).clear();
        find(locator).sendKeys(KeyToSend);
    }
    public void handleUnexpectedModal(String modalLocator, String closeButtonLocator) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(1));
            WebElement modal = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modalLocator)));
            if (modal.isDisplayed()) {
                clickElement(closeButtonLocator);
                System.out.println("Modal detected and closed.");
            }
        } catch (TimeoutException e) {
        }
    }
    public void clickOnFilterAndOption(String valueFilter,String xpathFilter) {
        String xpathFilterFinal = String.format(xpathFilter, valueFilter);
        clickElement(xpathFilterFinal);
    }
    public void clickOnFilterAndOptions(String valueMenu,String valueSecondMenu,String valueOptionMenu,String xpathMenu) {
        String xpathFilterFinal = String.format(xpathMenu,valueMenu,valueSecondMenu,valueOptionMenu);
        clickElement(xpathFilterFinal);
    }
    public void clickDropdownValue(String locator,String value) {
        WebElement dropdown = find(locator + "/following-sibling::div[@class='nice-select cm-12 open']");
        List<WebElement> options = dropdown.findElements(By.tagName("li"));
    
        for (WebElement option : options) {
            if (option.getText().contains(value)) {
                option.click();
                break;
            }
        }
    }
    public void switchToNewTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(driver.getWindowHandle())) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    
}
