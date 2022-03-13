package com.prathap.irctc.loginpage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Login_SD  extends Login {

    @Given("user launch IRCTC site using {string}")
    public void userLaunchIRCTCSiteUsing(String arg0) {
        launchIrctcSite(arg0);
    }

    @And("User clears all notifications")
    public void userClearsAllNotifications() {
        try {
            blockClearsAllNotifications();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
