package com.prathap.irctc.loginpage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.SeleniumUtilities;

import java.io.IOException;

public class Login extends SeleniumUtilities {

    private String btn_OK_AlertModal = "//*[contains(text(),'OK')]";
    private String icon_close_chatBot = "//div[@id='corover-close-btn']/img";
    private String icon_bannerMenu = "(//div[@role='banner'])[1]/descendant::div[4]/a/i";
    private String btn_Login = "//button[text()='LOGIN']";
    private String input_UserID = "//input[@formcontrolname='userid']";
    private String input_Password = "//input[@formcontrolname='password']";
    private String input_LoginCaptcha = "//div[@id='nlpInput']/input";
    private String btn_SignIn = "//button[text()='SIGN IN']";

    public void launchIrctcSite(String urlName){
        try {
            launchByUrl(urlName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void blockClearsAllNotifications() throws InterruptedException {;
        click(btn_OK_AlertModal);
        click(icon_close_chatBot);
    }
}
