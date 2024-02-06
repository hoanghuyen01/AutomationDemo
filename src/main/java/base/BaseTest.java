package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    protected Logger log;
    public static final String USERNAME = "huynhong1";
    public static final String ACCESS_KEY = "KizHoP1vjhVgEd8SQjqt";
    public static final String BROWSERSTACK_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub.browserstack.com/wd/hub";

    @Parameters({ "environmentType", "browser", "browserVersion","os","osVersion" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("LOCAL")String environmentType,@Optional("chrome")String browser,
                      @Optional("latest")String browserVersion,@Optional("Windows")String os,
                      @Optional("10")String osVersion,ITestContext ctx) throws MalformedURLException {
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);
        switch (environmentType){
            case "LOCAL":
                createLocalDriver(browser);
                break;
            case "BROWSERSTACK":
                createBrowserStackDriver(browser,browserVersion,os,osVersion);
                break;
            default:
                createLocalDriver("chrome");
                break;
        }


    }
    private WebDriver createLocalDriver(String browser){
        BrowserDriverFactoy factory = new BrowserDriverFactoy(browser);
        driver = factory.createDriver();
        driver.manage().window().maximize();
        return driver;
    }
    private WebDriver createBrowserStackDriver(String browser,String browserVersion, String os, String osVersion)
            throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browser);
        caps.setCapability("browser_version", browserVersion);
        caps.setCapability("os", os);
        caps.setCapability("os_version", osVersion);
        driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL), caps);
        return driver;
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


}
