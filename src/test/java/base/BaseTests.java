package base;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class BaseTests {

    private WebDriver driver;

    public void setUp(){
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

//        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(375,812));

//        List<WebElement> webElement = (List<WebElement>) driver.findElement(By.tagName("a"));
//        System.out.println(webElement.size());
//
        WebElement inputLink = driver.findElement(By.linkText("Inputs"));
        inputLink.click();

        System.out.println(driver.getTitle());

        //driver.quit();
    }

    public static void main(String args[]){
        BaseTests tests = new BaseTests();
        tests.setUp();
    }
}
