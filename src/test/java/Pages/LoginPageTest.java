package Pages;

import PageObjects.LoginPage;
import PageObjects.WelcomePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginPageTest extends BaseTest {
    @Test
    public void loginSuccessfullyWithValidData(){
        LoginPage loginPage = new LoginPage(driver,log);
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openWelcomePage();
        welcomePage.selectLoginForm();
        loginPage.fillInLoginForm("tomsmith","SuperSecretPassword!");
        String successMsg = loginPage.getMessageAlert();
        Assert.assertEquals(successMsg, "You logged into a secure area!×");
    }

}
