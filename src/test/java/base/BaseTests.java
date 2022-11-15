package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.WHLoginPage;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;
    protected WHLoginPage whLoginPage;

    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // implicit wait
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        whLoginPage = new WHLoginPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}