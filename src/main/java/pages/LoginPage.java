package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    WebDriverWait wait;
    private By EmailTextBox = By.id("email");
    private By PasswordTextBox = By.id("pass");
    private By LoginButton = By.name("login");
    private By ErrorBox = By.id("error_box");

    String URL = "https://www.facebook.com/";

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void Open_Facebook(){
        driver.get(URL);
    }
    public void Enter_Username (String Username) {
        driver.findElement(EmailTextBox).sendKeys(Username);
    }
    public void Enter_Password (String Password) {
        driver.findElement(PasswordTextBox).sendKeys(Password);
    }
    public void Click_on_login () {
        driver.findElement(LoginButton).click();
        WaitUntilPageLoads();
    }
    public String Get_Error_Message(){
        return driver.findElement(ErrorBox).getText();
    }

    public void WaitUntilPageLoads(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

}

