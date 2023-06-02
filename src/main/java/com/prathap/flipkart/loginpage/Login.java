package com.prathap.flipkart.loginpage;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.PropertiesFileReader;
import utilities.SeleniumUtilities;

import java.io.IOException;

public class Login extends SeleniumUtilities {

    @FindBy(xpath = "(//span[text()='Sign in'])[2]")
    private WebElement btn_signIn;

    @FindBy(xpath = "//*[text()='Hello, sign in']")
    private WebElement menu_signIn;

    public Login()  {
        this.webDriver = getWebDriver();
        PageFactory.initElements(webDriver, this);
    }

    public void launchSite() throws IOException {
        launch();
    }

    public void userLogin(){
        try{
            launchSite();
            if (!btn_signIn.isDisplayed()) {
                wait.until(ExpectedConditions.visibilityOf(btn_signIn));
                hoverOnWebElement(menu_signIn);
            }
            click(btn_signIn);
        } catch (Exception e){
            Assert.fail("Exception in Login!!\n"+e.getMessage());
        }
    }

}
