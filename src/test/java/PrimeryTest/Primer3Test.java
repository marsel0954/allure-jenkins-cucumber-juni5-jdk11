package PrimeryTest;


import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import primer.InitDriverPrimer;
import primer.LoginPage;

public class Primer3Test {
    LoginPage loginPage = new LoginPage(InitDriverPrimer.getDriver());

    @Test //ОТОБРАЖЕНИЕ ФУНКЦИОНАЛЬНОСТИ КНОПКИ "ГЛАЗИК" НА СТРАНИЦЕ АВТОРИЗАЦИИ
    @Timeout(10)
    public void inputLP() {
        loginPage.inputLP("222","23123123123");
        loginPage.eyeButton();
        loginPage.driverQuit();
    }
}
