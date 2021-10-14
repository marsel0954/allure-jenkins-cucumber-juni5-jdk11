package tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import primer.InitDriverPrimer;
import primer.LoginPage;

public class PrimerTest1 {
    LoginPage loginPage = new LoginPage(InitDriverPrimer.getDriver());

    @Test//ПРОВЕРКА ОБРАБОТКИ ОЩИБКИ НЕПРАВИЛЬНОГО ЛОГИНА
    public void inputLP() {
        loginPage.inputLP("222","23123123123");
        Assertions.assertEquals(loginPage.errorAnswer(),"Введите корпоративную почту Andersen");
        loginPage.driverQuit();
    }
/*    @Test //АВТОРИЗАЦИЯ ПОЛЬЗОВАТЕЛЯ
    public void inputLP1() {
        loginPage.inputLP("huntflow-test-16@andersenlab.com","159753CFThn");
        Assertions.assertEquals(true,loginPage.firstPage());
        loginPage.driverQuit();
    }*/


}
