package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.*;

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

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement (String locator){
        Find(locator).click();
    }

    public void  write (String locator, String KeyToSend){
        Find(locator).clear();
        Find(locator).sendKeys(KeyToSend);
    }

    public void validateElementText(String locator, String expectedText) {
        WebElement element = Find(locator);
        String actualText = element.getText();
        if (!actualText.contains(expectedText)) {
            throw new AssertionError("Texto Buscado '" + expectedText + "' no encontrado en el texto del elemento '" + actualText + "'");
        }
    }
}
