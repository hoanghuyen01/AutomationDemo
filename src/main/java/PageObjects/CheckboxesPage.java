package PageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxesPage extends BasePageObjects{
    private By checkbox = By.xpath("//input[@type='checkbox']");
    public CheckboxesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void selectAllCheckboxes(){
        List<WebElement> checkboxes = driver.findElements(checkbox);
        for(WebElement checkbox: checkboxes){
            clickElectWebElement(checkbox);
        }
    }
    public Boolean verifyAllCheckBoxesSelected(){
        List<WebElement> checkboxes = driver.findElements(checkbox);
        for(WebElement checkbox: checkboxes){
            if (!checkbox.isSelected()){
                return false;
            }
        }
        return true;
    }


}
