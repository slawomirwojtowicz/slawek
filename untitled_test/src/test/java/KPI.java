// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class Kpi {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void kpi() {
        driver.get("https://sso.eurocash.pl/sso/core/custom/login?id=ca0b884f27d59a14d3c4a0812216bc01&client=eurocashportal");
        driver.manage().window().setSize(new Dimension(1552, 840));
        driver.findElement(By.cssSelector(".btn")).click();
        driver.findElement(By.linkText("Oferta")).click();
        driver.findElement(By.id("offerSearch")).click();
        driver.findElement(By.id("offerSearch")).sendKeys("kawa mielona");
        driver.findElement(By.id("offerSearch")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".cookies__close")).click();
        driver.findElement(By.linkText("Przejdź do koszyka")).click();
        driver.findElement(By.cssSelector(".pointer:nth-child(1) > span")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".pointer:nth-child(1) > span"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector("#login-box .tab__title > div:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".tab__span")).click();
    }
}