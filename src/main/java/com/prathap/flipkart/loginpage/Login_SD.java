package com.prathap.flipkart.loginpage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;


public class Login_SD extends Login {

    public Login_SD() throws IOException {
    }
    @Given("User launch site")
    public void userLaunchFlipkartSite() throws IOException {
        launchSite();
    }
    @And("User captures screen")
    public void userCapturesScreen() {
        captureScreenshot();
    }

    @Given("User login to website")
    public void userLoginToWebsite() {
        userLogin();
    }
}
