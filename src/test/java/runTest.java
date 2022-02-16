import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resource"}
)
public class runTest {
    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        Steps.driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown(){
        Steps.driver.close();
    }

}
