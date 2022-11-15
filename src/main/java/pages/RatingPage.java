package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RatingPage {
    private  WebDriver driver;
    WebDriverWait wait;

    public RatingPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
    private By DropDownList = By.xpath("//span[normalize-space()='Select...']");
    private By ReviewTextBox = By.xpath("//textarea[@placeholder='Write your review...']");
    private By SubmitButton = By.xpath("//div[normalize-space()='Submit']");
    private By Selection = By.xpath("//div[@class='dropdown second opened']//ul[@role='listbox']/li[2]");

    public void Select_From_DropDownList() throws InterruptedException {

        driver.findElement(DropDownList).click();
        Wait_Until_Visibility(Selection);
        driver.findElement(Selection).click();
    }

    public void Wait_Until_Visibility(By element){
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void Write_Review(String Review){
        driver.findElement(ReviewTextBox).sendKeys(Review);
    }

    public void Submit_Review(){
        driver.findElement(SubmitButton).click();
        System.out.println("Review Submitted");
    }


}
