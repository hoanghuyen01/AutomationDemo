package PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends BasePageObjects{
    private By dropdown = By.id("dropdown");
    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement jsAlertBtn ;
    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement jsConfirmBtn;
    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement jsPromptBtn;
    @FindBy(id = "result")
    WebElement resultMessage;
    @FindBy(xpath = "//a[text()=\"Click Here\"]")
    WebElement multipleWindows;
    public DropdownPage(WebDriver driver, Logger log) {
        super(driver, log);
        PageFactory.initElements(driver, this);
    }
    public void selectAnOptionFromDropdownList(String text){
        log.info("Start select dropdown options");
        WebElement options = driver.findElement(dropdown);
        Select dropdown = new Select(options);
        dropdown.selectByVisibleText(text);
    }
    public String getTextOfSelectOption(){
        WebElement options = driver.findElement(dropdown);
        Select dropdown = new Select(options);
        dropdown.getFirstSelectedOption().getText();
        return dropdown.getFirstSelectedOption().getText();
    }
    //alert form
    public void clickJsAlertForm(){
        wait.waitUntilClickable(jsAlertBtn,5);
        jsAlertBtn.click();
    }
    public void clickJsConfirmForm(){
        wait.waitUntilClickable(jsConfirmBtn,5);
        jsConfirmBtn.click();
    }
    public void clickJsPromptForm(){
        wait.waitUntilClickable(jsPromptBtn,5);
        jsPromptBtn.click();
    }
    public void acceptAlertForm(){
        Alert alert = switchToAlertForm(5);
        alert.accept();
    }
    public void dismissAlertForm(){
        Alert alert = switchToAlertForm(5);
        alert.dismiss();
    }
    public void sendMessageToPromptAlert(String text){
        Alert alert = switchToAlertForm(5);
        alert.sendKeys(text);
    }
    public String getAlertText(){
        Alert alert = switchToAlertForm(5);
        return alert.getText();
    }
    public String getResultAlertMessage(){
        wait.waitUntilVisibility(resultMessage,5);
        return resultMessage.getText();
    }
    public void openNewWindows(){
        clickElectWebElement(multipleWindows);
    }

}
