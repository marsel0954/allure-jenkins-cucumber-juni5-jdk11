package tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import primer.InitDriverPrimer;
import primer.LoginPage;

public class PrimerTest5 {
    LoginPage loginPage = new LoginPage(InitDriverPrimer.getDriver());

    @Test // ПОИСК ЭДЕМЕНТА НА СТРАНИЦЕ АВТОРИЗАЦИИ
    public void inputLP() {
        Assertions.assertEquals(true,loginPage.findButton());
        loginPage.driverQuit();

    }

}
