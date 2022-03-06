package Login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;


public class Login_SD extends Login{

    public Login_SD() throws IOException {
    }

    @Given("User enters {string} for username")
    public void userEntersForUsername(String arg0) {
        enterUserName(arg0);
    }

    @And("User enters {string} for password")
    public void userEntersForPassword(String arg0) {
        enterPassword(arg0);
    }

    @When("User clicks on Login button")
    public void userClicksOnLoginButton() {
        clickLoginButton();
    }

    @Then("User should be able to login")
    public void userShouldBeAbleToLogin() {
        validateUserAbleToLogin();
    }

    @Given("User launch Flipkart site")
    public void userLaunchFlipkartSite() throws IOException {
        launchFlipkartSite();
    }

    @And("User captures screen")
    public void userCapturesScreen() {
        captureScreenshot();
    }

    @Then("User logout from application")
    public void userLogoutFromApplication() {
        userLogout();
    }

    @Given("User login to website")
    public void userLoginToWebsite() {
        userLogin();
    }
}
