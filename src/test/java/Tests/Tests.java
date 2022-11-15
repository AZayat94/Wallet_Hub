package Tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends BaseTests {
    String Username = "Username1";
    String Password = "Password1";
    String WH_Username = "agileahmed1@gmail.com";
    String WH_Password = "P@ssw0rd";
    String ProfileHeader = "Test Insurance Company";
    String BabyGreenColourCode = "#4ae0e1";
    String Review = "Test Automation Review Test Automation Review Test Automation Review Test Automation Review Test Automation Review Test Automation Review!!";
    String WrongCredentialsMessage = "Wrong Credentials";

    @Test()
        public void testCase1() {
        loginPage.Open_Facebook();
        loginPage.Enter_Username(Username);
        loginPage.Enter_Password(Password);
        loginPage.Click_on_login();
        String ErrorMessage = loginPage.Get_Error_Message();
        Assert.assertTrue(ErrorMessage.contains(WrongCredentialsMessage),"Negative TC where user should not logon using Invalid Credentials");
        System.out.println("Hello World!");
    }
    @Test()
    public void testCase2() throws InterruptedException {
        whLoginPage.Login_To_WalletHub(WH_Username,WH_Password);
        whLoginPage.Wait_Url_to_be("https://wallethub.com/join/notice");
        var profile = whLoginPage.Move_to_Profile();
        String ProfileTitle = profile.Get_Profile_Header();
        Assert.assertEquals(ProfileTitle,ProfileHeader);
        profile.Click_on_Review();
        profile.Hover_on_Fourth_Star();
        String Star_Filling_Colour = profile.Get_Star_Colour();
        Assert.assertTrue(Star_Filling_Colour.equals(BabyGreenColourCode));
        var Rating = profile.Give_Rate();
        Rating.Select_From_DropDownList();
        Rating.Write_Review(Review);
        Rating.Submit_Review();
    }
}