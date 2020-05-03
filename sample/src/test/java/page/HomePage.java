package page;

//import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class HomePage {
    private WebDriver driver;

    public static Object setupClass() {
        WebDriverManager.chromedriver().setup();
        return null;
    }

    public HomePage setUp() {
// Uruchom nowy egzemplarz przeglądarki Firefox
        driver = new ChromeDriver();
// Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        //testowana strona
        String url = "http://www.google.pl";
// Przejdź do serwisu
        driver.get(url);
        return null;
    }
}

