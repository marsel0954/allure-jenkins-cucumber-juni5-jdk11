package PrimeryTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import primer.InitDriverPrimer;
import primer.LoginPage;
public class PrimeryTest {
    LoginPage loginPage = new LoginPage(InitDriverPrimer.getDriver());

    @Test//АВТОРИЗАЦИЯ ПОЛЬЗОВАТЕЛЯ
    public void inputLP() {
        loginPage.inputLP("huntflow-test-16@andersenlab.com","159753CFThn");
        Assertions.assertEquals(true,loginPage.firstPage());
        loginPage.driverQuit();
    }
}
