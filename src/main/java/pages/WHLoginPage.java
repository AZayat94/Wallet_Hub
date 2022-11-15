package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WHLoginPage {
    private  WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    private By EmailTextBox = By.id("email");
    private By PasswordTextBox = By.id("password");
    private By LoginButton = By.xpath("//span[contains(text(),'Login')]");

    String URL = "https://wallethub.com/join/login";
    String LoginPageTitle = "WalletHub Login";
    String ProfileUrl = "https://wallethub.com/profile/13732055i";


    public WHLoginPage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
    }

    public void Login_To_WalletHub(String Username , String Password){

        driver.navigate().to(URL);
        Wait_Title_to_be(LoginPageTitle);
        driver.findElement(EmailTextBox).sendKeys(Username);
        driver.findElement(PasswordTextBox).sendKeys(Password);
        driver.findElement(LoginButton).click();
    }

    public Profile Move_to_Profile(){
        driver.get(ProfileUrl);
        return new Profile(driver);
    }
    public void Wait_Url_to_be(String URL){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(URL));
    }


    public void Wait_Title_to_be(String Title){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleIs(Title));
    }
}
