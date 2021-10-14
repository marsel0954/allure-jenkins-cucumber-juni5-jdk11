package primer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InitDriverPrimer {
    public static WebDriver driver;
    public static void initDriver(){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Program Files\\Java\\myJavaProject\\JavaLessons\\src\\main\\resources\\chromedriver.exe"
        );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://crm-trainee-react-dev.andersenlab.dev/login");

    }
    public InitDriverPrimer(WebDriver driver){
        InitDriverPrimer.driver = driver;
    }


    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
            return driver;
        }else{
            return driver;
        }
    }
}
