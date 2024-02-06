package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriverFactoy {
    private String browser;
    protected WebDriver driver;
    public BrowserDriverFactoy(String browser){
        this.browser = browser;
    }
    protected WebDriver createDriver(){
        switch (browser){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
                break;
            case "firefox":
                driver = WebDriverManager.firefoxdriver().create();
                break;
        }
        return driver;
    }
}
