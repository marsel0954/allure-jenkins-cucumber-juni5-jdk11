package PrimeryTest;


import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import primer.InitDriverPrimer;
import primer.LoginPage;

public class PrimerTest5 {
    LoginPage loginPage = new LoginPage(InitDriverPrimer.getDriver());

    @Test // ПОИСК ЭДЕМЕНТА НА СТРАНИЦЕ АВТОРИЗАЦИИ
    @Timeout(10)
    @Ignore


    public void inputLP() {
        Assertions.assertEquals(true,loginPage.findButton());
        loginPage.driverQuit();

    }

}
