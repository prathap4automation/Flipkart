package Login;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utilities.PropertiesFileReader;
import utilities.SeleniumUtilities;

import java.io.IOException;

public class Login extends SeleniumUtilities {

    private String input_userName = "(//input[@type='text'])[2]";
    private String input_password = "//input[@type='password']";
    private String btn_login = "(//button[@type='submit'])[2]";
    private String lbl_userName = "//a/img[@title='Flipkart']/following::div[4]/descendant::div[4]";

    public Login()  { }

    public void launchFlipkartSite() throws IOException {
        launch();
        isDisplayed(input_userName);
    }

    public void enterUserName(String userName){
        System.out.println("in enter username.");
        sendKeys(input_userName,userName);
    }

    public void enterPassword(String password){
        System.out.println("in enter password.");
        sendKeys(input_password,password);
    }

    public void clickLoginButton(){
        System.out.println("Click Login.");
        click(btn_login);
    }

    public void validateUserAbleToLogin(){
        System.out.println("Validate Login.");
        isDisplayed(lbl_userName);
    }

    public void userLogin(){
        try{
            launchFlipkartSite();
            String userName = PropertiesFileReader.getPropertyValue("config","userName");
            String password = PropertiesFileReader.getPropertyValue("config","password");
            enterUserName(userName);
            enterPassword(password);
            clickLoginButton();
            validateUserAbleToLogin();

        } catch (Exception e){
            Assert.fail("Exception in Login!!\n"+e.getMessage());
        }
    }

    public void userLogout(){
        try{
            System.out.println("In Logout method.");
            WebElement userName = getWebElement(lbl_userName);
            System.out.println("UserName: "+userName.getText());
            clickLogoutLink();
            isDisplayed(input_userName);
        } catch (Exception e){
            Assert.fail("Exception in logout!!\n"+e.getMessage());
        }
    }

}
