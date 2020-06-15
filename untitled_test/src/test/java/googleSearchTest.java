import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class googleSearchTest {
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
// Przejdź do serwisu Google
        driver.get("http://www.google.com");
    }
    @Test
    public void testGoogleSearch() {
// Znajdź element wprowadzania tekstu za pomocą jego nazwy
        WebElement element = driver.findElement(By.name("q"));
// Wyczyść tekst zapisany w elemencie
        element.clear();
// Wpisz informacje do szukania
        element.sendKeys("Selenium testing tools cookbook");
// Prześlij formularz
        element.submit();
// Wyszukiwanie w Google jest renderowane dynamicznie za pomocą JavaScript.
// Poczekaj na załadowanie strony. Timeout po 10 sekundach
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase()
                        .startsWith("selenium testing tools cookbook");
            }
        });
        assertEquals("Selenium testing tools cookbook - Szukaj w Google",
                driver.getTitle());
    }
    @After
    public void tearDown() throws Exception {
// Zamknij przeglądarkę
        driver.quit();
    }
}

