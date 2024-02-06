package ultilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilVisibility(WebElement element, int waitingTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element, int waitingTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitingTime));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
