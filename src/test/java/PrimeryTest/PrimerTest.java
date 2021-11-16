package PrimeryTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import primer.InitDriverPrimer;
import primer.LoginPage;

public class PrimerTest {
    LoginPage loginPage = new LoginPage(InitDriverPrimer.getDriver());

    @Test//ПРОВЕРКА ОБРАБОТКИ ОЩИБКИ НЕПРАВИЛЬНОГО ЛОГИНА
    public void inputLP() {
        loginPage.inputLP("222","23123123123");
        Assertions.assertEquals(loginPage.errorAnswer(),"Введите корпоративную почту Andersen");
        loginPage.driverQuit();


    }



}
