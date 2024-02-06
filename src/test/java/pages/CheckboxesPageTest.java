package pages;

import pageobjects.CheckboxesPage;
import pageobjects.WelcomePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesPageTest extends BaseTest {
    @Test
    public void selectAllCheckboxesTest(){
        WelcomePage welcomePage = new WelcomePage(driver,log);
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver, log);
        welcomePage.openWelcomePage();
        welcomePage.selectCheckBoxForm();
        checkboxesPage.selectAllCheckboxes();
        Assert.assertTrue(checkboxesPage.verifyAllCheckBoxesSelected(),"Not all checkboxes were selected.");
    }
}
