import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class logIn {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest()  {
        driver = new ChromeDriver();
        driver.navigate().to("http:/eurocash.pl");
        //System.out.println(driver.getTitle());
        junit.framework.Assert.assertEquals("eurocash.pl",driver.getTitle());
        driver.manage().window().fullscreen();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void test() {
        // Your test code here
    }

}