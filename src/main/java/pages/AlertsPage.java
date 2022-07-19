package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    private By triggerAlert = By.xpath(".//button[text()='Click for JS Alert']");

    private By results = By.id("result");

    public AlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void triggerAlert(){
        driver.findElement(triggerAlert).click();

    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    //To get the results test
    public String getResults(){
        return driver.findElement(results).getText();
    }
}
