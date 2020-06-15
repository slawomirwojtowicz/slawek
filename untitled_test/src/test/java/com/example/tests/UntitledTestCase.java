package com.example.tests;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
    private WebDriver driver;
    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("http://gsip.konstancinjeziorna.pl/map/zgloszenie.php");
        driver.findElement(By.xpath("//input[@value='Akceptuję']")).click();
        new Select(driver.findElement(By.xpath("//div[@id='service-gm5360']/span[2]/select"))).selectByVisibleText("Uszkodzona jezdnia");
        //Select make =new Select(driver.findElement(By.linkText("Wskaz miejsce")));
        // sprawdz czy wyswietlaja się cztery opcje wyswietlania
        //assertEquals(8,);
        driver.findElement(By.xpath("//div[@id='service-gm5360']/span[2]/select")).click();
        driver.findElement(By.id("service-input-opis")).click();
        driver.findElement(By.id("service-input-opis")).clear();
        driver.findElement(By.id("service-input-opis")).sendKeys("zla Działkowa");
        driver.findElement(By.id("service-input-zglaszajacy")).clear();
        driver.findElement(By.id("service-input-zglaszajacy")).sendKeys("adresemail");
        driver.findElement(By.id("service-input-email")).clear();
        driver.findElement(By.id("service-input-email")).sendKeys("adresemail@gmail.com");
        driver.findElement(By.id("dijit_form_CheckBox_0")).click();
        driver.findElement(By.xpath("//input[@value='Wskaz miejsce']")).click();
        driver.findElement(By.xpath("//*[@id=\"OpenLayers_Layer_Vector_501_svgRoot\"]")).isDisplayed();

        driver.findElement(By.id("submit-service")).click();
    }


    @After
    public void tearDown() throws Exception {
    //driver.quit();
        }
    }



