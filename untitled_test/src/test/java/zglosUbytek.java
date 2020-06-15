import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class zglosUbytek {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setUp() {
// Uruchom nowy egzemplarz przeglądarki Firefox
        driver = new ChromeDriver();
// Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        String url ="http://gsip.konstancinjeziorna.pl/map/zgloszenie.php";
// Przejdź do serwisu Google
        driver.get(url);
    }
    @Test
    public void testZgloszenia() throws InterruptedException {
// Znajdź element wprowadzania tekstu za pomocą jego nazwy
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/input[1]"));
// Wyczyść tekst zapisany w elemencie
        element.click();
        WebElement szcegol = driver.findElement(By.id("service-input-opis"));
        szcegol.sendKeys("Ulica Działkowa jest w tragicznym stanie");

        //wskazanie miejsca
        WebElement miejsce =driver.findElement(By.xpath("//*[@id=\"service-gm5360\"]/span[1]/input"));
        miejsce.click();

        //driver.findElement(By.id("OpenLayers_Layer_Vector_540_svgRoot"));

       Thread.sleep(15000);
        Actions action =new Actions(driver);
        Thread.sleep(51000);
        action.doubleClick(driver.findElement(By.xpath("//*[@id=\"OpenLayers_Layer_Vector_545_svgRoot\"]")));
        action.moveByOffset(900, 900).build().perform();
        //Thread.sleep(15000);
        //action.build();
        //action.perform();
        //Thread.sleep(400);
        //action.click().build().perform();
        //action.doubleClick(driver.findElement(By.xpath("//*[@id=\"OpenLayers_Layer_Vector_540_svgRoot\"]")));
        //osoba zgłaszająca
        WebElement person =driver.findElement(By.id("service-input-zglaszajacy"));
        person.sendKeys("Kowalski");

        //email
        WebElement personEmail =driver.findElement(By.id("service-input-email"));
        personEmail.sendKeys("JanKowalski@email.com");

        //checkbox
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        WebElement checkbox =driver.findElement(By.xpath("//*[@id=\"dijit_form_CheckBox_1\"]"));
        checkbox.click();

        //sendReq
        WebElement sendRequest =driver.findElement(By.id("service-gm536-right-0"));
        sendRequest.click();
        WebElement wyslij =driver.findElement(By.xpath("//*[@id=\"submit-service\"]"));
        wyslij.click();
    }
   // @Test

    @After
    public void tearDown() throws Exception {
// Zamknij przeglądarkę
        //driver.quit();
    }
}

