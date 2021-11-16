package PrimeryTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import primer.BasePage;
import primer.InitDriverPrimer;
import primer.LoginPage;

public class PrimerTest4 {
    LoginPage loginPage = new LoginPage(InitDriverPrimer.getDriver());
    BasePage basePage =  new BasePage(InitDriverPrimer.getDriver());

    @Test //ВХОД И ВЫХОД С САЙТА
    public void inputLP(){
        loginPage.inputLP("huntflow-test-16@andersenlab.com","159753CFThn");
        basePage.sidebararrowclick();
       // basePage.settingButton();
        basePage.myprofileclick();
        basePage.quitBasePage();
        Assertions.assertEquals(true,loginPage.firstPage());
        loginPage.driverQuit();


    }
}
