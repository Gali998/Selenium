package base;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        /*
        * Takes 2 arguments
        * amount of time to wait,a time unit
        * Any time web driver need to interact with element then
        * it should pause website upto 30 seconds until finds an
        * elements.If you find element before 30 sec you'll
        * interact with it.
        *
        * */
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");

//        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(375,812));

//        List<WebElement> webElement = (List<WebElement>) driver.findElement(By.tagName("a"));
//        System.out.println(webElement.size());
//
//        WebElement inputLink = driver.findElement(By.linkText("Inputs"));
//        inputLink.click();
//
//        System.out.println(driver.getTitle());

        homePage = new HomePage(driver);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

//    public static void main(String args[]){
//        BaseTests tests = new BaseTests();
//        tests.setUp();
//    }
}
