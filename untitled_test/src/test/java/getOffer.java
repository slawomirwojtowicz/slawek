import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class getOffer {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest()  {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.mbank.pl/nowy-serwis/ind-fir/poznaj-serwis/");
        //System.out.println(driver.getTitle());
        junit.framework.Assert.assertEquals("Klienci dawnego MultiBanku",driver.getTitle());
        driver.manage().window().fullscreen();
    }

    @After
    public void loginPage() {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[3]/section[1]/div/div/div/div/p/a")).click();

    }

    @Test
    public void test() {
        // Your test code here
    }

}

