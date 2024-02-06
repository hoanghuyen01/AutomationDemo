package pageobjects;

import ultilities.WaitHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageObjects {

    protected WebDriver driver;
    protected Logger log;
    protected WaitHelper wait;
    public BasePageObjects(WebDriver driver, Logger log){
        this.driver = driver;
        this.log = log;
        wait = new WaitHelper(driver);
    }
    public void openUrl(String url){
        log.info("Starting go to" + url);
        driver.get(url);
        log.info(getTitlePage() + " successfully");
    }
    public String getTitlePage(){
        return driver.getTitle();
    }

    public String getTextOfWebElement(WebElement element){
        wait.waitUntilVisibility(element,5);
        element.getText();
        return element.getText();
    }

    public void clickElectWebElement(WebElement element){
        wait.waitUntilClickable(element,5);
        if (!element.isSelected()){
            element.click();
        }
    }
    public Alert switchToAlertForm(int waitingTime){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        return alert;
    }
}
