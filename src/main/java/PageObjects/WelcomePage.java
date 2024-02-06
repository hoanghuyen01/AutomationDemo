package PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePageObjects {
    protected String welcomePageUrl = "http://the-internet.herokuapp.com/";
    @FindBy(xpath = "//a[text()= 'Checkboxes']")
    WebElement checkBoxUrl;
    @FindBy(xpath = "//a[text()= 'Form Authentication']")
    WebElement loginFormUrl;

    @FindBy(xpath = "//a[text()= 'Dropdown']")
    WebElement dropdownUrl;
    @FindBy(xpath = "//a[text()= 'JavaScript Alerts']")
    WebElement JsAlertUrl;
    @FindBy(xpath = "//a[text()= 'Multiple Windows']")
    WebElement multipleWindowsUrl;
    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }
    public void openWelcomePage(){
        openUrl(welcomePageUrl);
    }

    public void selectCheckBoxForm(){
        wait.waitUntilVisibility(checkBoxUrl,5);
        checkBoxUrl.click();
    }
    public void selectLoginForm(){
        wait.waitUntilVisibility(loginFormUrl,5);
        loginFormUrl.click();
    }

    public void selectDropdownForm(){
        wait.waitUntilVisibility(dropdownUrl,5);
        dropdownUrl.click();
    }
    public void selectJsAlertForm(){
        wait.waitUntilVisibility(JsAlertUrl,5);
        JsAlertUrl.click();
    }
    public void multipleWindowsForm(){
        wait.waitUntilVisibility(multipleWindowsUrl,5);
        multipleWindowsUrl.click();
    }
}
