package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        ChromeDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
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
        setCookie();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            // System.out.println("Screenshot taken: "+screenshot.getAbsolutePath());
            try {
                Files.move(screenshot,new File("resources/screenshots/test.png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }


//    public static void main(String args[]){
//        BaseTests tests = new BaseTests();
//        tests.setUp();
//    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau","123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}
