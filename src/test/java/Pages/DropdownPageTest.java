package Pages;

import PageObjects.DropdownPage;
import PageObjects.WelcomePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownPageTest extends BaseTest {
    private WelcomePage welcomePage;
    private DropdownPage dropdownPage;

    @BeforeMethod
    public void setUpClass(){
        welcomePage = new WelcomePage(driver,log);
        dropdownPage = new DropdownPage(driver,log);
    }

    public void selectOption2(){
        welcomePage.openWelcomePage();
        welcomePage.selectDropdownForm();
        dropdownPage.selectAnOptionFromDropdownList("Option 2");
        Assert.assertEquals(dropdownPage.getTextOfSelectOption(),"Option 2");
    }

    public void JsAlertFormTest(){
        welcomePage.openWelcomePage();
        welcomePage.selectJsAlertForm();
        dropdownPage.clickJsAlertForm();
        Assert.assertEquals(dropdownPage.getAlertText(),"I am a JS Alert");
        dropdownPage.acceptAlertForm();
        Assert.assertEquals(dropdownPage.getResultAlertMessage(),"You successfully clicked an alert");
    }
    public void JsConfirmAlertTest(){
        welcomePage.openWelcomePage();
        welcomePage.selectJsAlertForm();
        dropdownPage.clickJsConfirmForm();
        Assert.assertEquals(dropdownPage.getAlertText(),"I am a JS Confirm");
        dropdownPage.acceptAlertForm();
        Assert.assertEquals(dropdownPage.getResultAlertMessage(),"You clicked: Ok");
        dropdownPage.clickJsConfirmForm();
        dropdownPage.dismissAlertForm();
        Assert.assertEquals(dropdownPage.getResultAlertMessage(),"You clicked: Cancel");

    }
    @Test
    public void JsPromptAlertTest(){
        welcomePage.openWelcomePage();
        welcomePage.selectJsAlertForm();
        dropdownPage.clickJsPromptForm();
        Assert.assertEquals(dropdownPage.getAlertText(),"I am a JS prompt");
        String msg = "Huyen Hoang";
        dropdownPage.sendMessageToPromptAlert(msg);
        dropdownPage.acceptAlertForm();
        Assert.assertEquals(dropdownPage.getResultAlertMessage(),"You entered: "+msg);
        dropdownPage.clickJsPromptForm();
        dropdownPage.dismissAlertForm();
        Assert.assertEquals(dropdownPage.getResultAlertMessage(),"You entered: null");

    }
    public void multipleWindowsTest(){
        welcomePage.openWelcomePage();
        welcomePage.multipleWindowsForm();
        dropdownPage.openNewWindows();
    }
}
