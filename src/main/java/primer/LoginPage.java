package primer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends InitDriverPrimer {

    public static final By LOGIN_BUTTON = By.xpath("//*[@id=\"root\"]/div/div/form/button");
    public static final By PASSWORD = By.id("pass");
    public static final By LOGIN = By.id("login");
    public static final By ERRORLOGIN = By.xpath("//*[@id=\"root\"]/div/div/form/div[1]/div/span");
    public static final By IMAGETOPBAR = By.xpath("//*[@id=\"root\"]/div/nav/div/a/svg");
    public static final By EYEBUTTON = By.className("passwordInput_eye__261I6");

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void inputLP(String login, String password){
        driver.findElement(LOGIN).sendKeys(login);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

/*    public boolean loginButtonVisible(){
        WebElement dynamicElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/form/button")));
        return dynamicElement.isDisplayed();
    }*/

    public boolean findButton(){

        boolean findb1 = driver.findElement(LOGIN_BUTTON).isDisplayed();
        return findb1;

    }

    public void eyeButton(){
        driver.findElement(EYEBUTTON).click();
    }

    public String errorAnswer(){
        String er1 = driver.findElement(ERRORLOGIN).getAttribute("innerText");
        return er1;
    }

    public boolean firstPage(){
        boolean findpage1 = driver.findElement(LOGIN).isDisplayed();
        return findpage1;
    }



    public void driverQuit(){
        try {
            Thread.sleep(4000);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
