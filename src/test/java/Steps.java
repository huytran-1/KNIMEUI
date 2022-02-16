import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.json.*;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Steps {
    static WebDriver driver;
    static JSONObject jsonObject;
    static JSONObject dataObject;
    protected String jsonContent;
    protected File jsonFile;

    public Steps() {
        jsonFile = new File("./src/test/resource/locator.json");
        try {
            jsonContent = FileUtils.readFileToString(jsonFile, "utf-8");
        } catch (IOException e) {
            ;;
        }
        this.jsonObject = new JSONObject(jsonContent);

        jsonFile = new File("./src/test/resource/data.json");
        try {
            jsonContent = FileUtils.readFileToString(jsonFile, "utf-8");
        } catch (IOException e) {
            ;;
        }
        this.dataObject = new JSONObject(jsonContent);
    }

    public void lauchWebpage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            ;;
        }
    }

    public void clickElement(String element){
        String locator = jsonObject.getString(element);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void enterText(String element, String textLocator){
        String locator = jsonObject.getString(element);
        String text = dataObject.getString(textLocator);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.cssSelector(locator)).sendKeys(text);
    }

    public String getText(String element){
        String locator = jsonObject.getString(element);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String text = driver.findElement(By.cssSelector(locator)).getText();
        return text;
    }

    public void clearText(String element){
        String locator = jsonObject.getString(element);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public void wait(int sec){
        try {
            Thread.sleep(sec * 1000 );
        } catch (InterruptedException e) {
            ;;
        }
    }
}
