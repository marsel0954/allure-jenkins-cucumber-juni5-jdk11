package tests;


import org.junit.jupiter.api.Test;
import primer.InitDriverPrimer;
import primer.LoginPage;

public class PrimerTest3 {
    LoginPage loginPage = new LoginPage(InitDriverPrimer.getDriver());

    @Test //ОТОБРАЖЕНИЕ ФУНКЦИОНАЛЬНОСТИ КНОПКИ "ГЛАЗИК" НА СТРАНИЦЕ АВТОРИЗАЦИИ
    public void inputLP() {
        loginPage.inputLP("222","23123123123");
        loginPage.eyeButton();
        loginPage.driverQuit();
    }
}
