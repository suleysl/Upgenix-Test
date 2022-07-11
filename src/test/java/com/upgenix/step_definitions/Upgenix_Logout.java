package com.upgenix.step_definitions;

import com.upgenix.pages.LoginPage;
import com.upgenix.pages.LogoutPage;
import com.upgenix.utilities.ConfigurationReader;
import com.upgenix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Upgenix_Logout {

    LoginPage loginPage = new LoginPage();
    LogoutPage logoutPage = new LogoutPage();

    @Given("user is on the Upgenix home page")
    public void user_is_on_the_upgenix_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.usernameInputBox.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();
    }

    @When("user clicks to {string} icon")
    public void user_clicks_to_icon(String usernameIcon) {
        logoutPage.usernameIcon.click();
    }

    @When("user clicks to {string} dropdown")
    public void user_clicks_to_logOut_dropdown(String logOutBtn) {
        logoutPage.logOutBtn.click();
    }

    @When("user clicks to step back button")
    public void user_clicks_to_step_back_button() {
        Driver.getDriver().navigate().back();
    }

    @Then("user should see {string} displayed")
    public void user_should_see__message_displayed(String sessionExpiredMessage) {
        Assert.assertEquals(sessionExpiredMessage, logoutPage.sessionExpiredMessage.getText());
    }

}
