package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Profile {
    private  WebDriver driver;
    WebDriverWait wait;
    private By ProfileHeader = By.xpath("//h1");
    private By ReviewButton = By.xpath("//*[@class='nav-txt'][contains(text(),'Reviews')]");
    private By RatingStar = By.xpath("(//*[name()='svg'][@aria-label='4 star rating'])[3]");
    private By FourthStar = By.xpath("(//*[name()='svg'][@aria-label='4 star rating'])[3]//*[name()='g'][1]/*[name()='path'][1]");
    private By RatingTitle = By.xpath("(//h3[@class='rsba-h3 bold-font']");
    public Profile(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public String Get_Profile_Header(){
        return driver.findElement(ProfileHeader).getText();
    }

    public void Click_on_Review(){
        driver.findElement(ReviewButton).click();
      //  WaitUntilVisibility(RatingTitle);
    }

    public void Hover_on_Fourth_Star(){
        Hover_On(RatingStar);
    }

    public String Get_Star_Colour(){
       return driver.findElement(FourthStar).getAttribute("fill");
    }

    public RatingPage Give_Rate(){
        driver.findElement(RatingStar).click();
        return new RatingPage(driver);
    }

    public void WaitUntilVisibility(By element){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
    }

    public void Hover_On(By element){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(element)).perform();
    }
}
