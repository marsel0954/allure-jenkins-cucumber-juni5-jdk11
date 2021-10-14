package primer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends InitDriverPrimer {

    public static final By SIDEBAR_ARROW = By.className("sidebar_arrow-button__10bs-");
    public static final By ICON_MYPROFILE = By.xpath("//*[@id=\"root\"]/div/nav/div/div[2]/div[2]/div");
    public static final By BUTTON_QUIT = By.className("popupMenu_option__3ZD4c");
    public static final By SETTINGS = By.xpath("//*[@id=\"root\"]/div/nav/div/div[1]/button");


    public BasePage(WebDriver driver){
        super(driver);
    }


    public void sidebararrowclick(){
        WebElement wait = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("sidebar_arrow-button__10bs-")));
        driver.findElement(SIDEBAR_ARROW).click();
    }

    public void myprofileclick(){
        WebElement wait = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/nav/div/div[2]/div[2]/div")));
        driver.findElement(ICON_MYPROFILE).click();
    }
    public void settingButton(){
        driver.findElement(SETTINGS).click();
    }


    public void quitBasePage(){
        WebElement wait = new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("popupMenu_option__3ZD4c")));
        driver.findElement(BUTTON_QUIT).click();
    }
}



