package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BasePageObjects{
    protected String loginPageUrl = "http://the-internet.herokuapp.com/login";
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement passwordElement;
    @FindBy(css = "button.radius")
    WebElement loginBtn;
    @FindBy(id = "flash")
    WebElement alertMessage;
    WelcomePage welcomePage;
    public LoginPage(WebDriver driver, Logger log){
        super(driver,log);
        PageFactory.initElements(driver, this);
    }
    public void fillInLoginForm(String name, String pass){
        wait.waitUntilVisibility(username,5);
        username.sendKeys(name);
        wait.waitUntilVisibility(passwordElement,5);
        passwordElement.sendKeys(pass);
        wait.waitUntilClickable(loginBtn,5);
        loginBtn.click();
    }
    public String getMessageAlert(){
        String msg = getTextOfWebElement(alertMessage).replaceAll("\n","");
        return msg;
    }
}
