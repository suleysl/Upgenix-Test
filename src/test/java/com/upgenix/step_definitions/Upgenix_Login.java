package com.upgenix.step_definitions;

import com.upgenix.pages.LoginPage;
import com.upgenix.utilities.BrowserUtils;
import com.upgenix.utilities.ConfigurationReader;
import com.upgenix.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Upgenix_Login {

    LoginPage loginPage= new LoginPage();

    @Given("user is on the Upgenix login page")
    public void userIsOnTheUpgenixLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("User enters valid {string} and valid {string}")
    public void enters_valid_username_and_valid_password(String Username , String Password) {
        loginPage.usernameInputBox.sendKeys(Username);
        loginPage.passwordInputBox.sendKeys(Password);
    }


    @When("user clicks on the {string} button on the login page")
    public void user_clicks_on_the_button_on_the_login_page(String loginBtn) {
        loginPage.loginBtn.click();
        BrowserUtils.sleep(5);

    }
    @Then("user should see the title is {string}")
    public void user_should_see_the_title_is(String expectedTitle) {
        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);

    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.usernameInputBox.sendKeys(username);
        loginPage.passwordInputBox.sendKeys(password);
        loginPage.loginBtn.click();
    }
    @Then("user should see {string} notice message")
    public void user_should_see_notice_message(String message) {
        Assert.assertEquals(message, loginPage.WrongLoginPasswordMsg.getText());

    }


    @When("User enters {string} or {string}")
    public void userEntersOr(String username, String password) {
        loginPage.usernameInputBox.sendKeys(username + Keys.ENTER);
        loginPage.passwordInputBox.sendKeys(password + Keys.ENTER);
        loginPage.loginBtn.click();
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        String message = loginPage.usernameInputBox.getAttribute("required");
        Assert.assertEquals("true", message);
    }


    @When("user clicks {string} link")
    public void userClicksLink(String link) {
        loginPage.resetPasswordLink.click();
    }


    @When("user enters password, user should see the password in bullet signs by default")
    public void userEntersPasswordUserShouldSeeThePasswordInBulletSignsByDefault() {
        loginPage.passwordInputBox.sendKeys("salesmanager");
        Assert.assertTrue(loginPage.bulletPasswordVerify.isDisplayed());

    }


    @When("user enters valid {string} and valid {string} and press Enter key")
    public void userEntersValidAndValidAndPressEnterKey(String username, String password) {
        loginPage.usernameInputBox.sendKeys(username + Keys.ENTER);
        loginPage.passwordInputBox.sendKeys(password + Keys.ENTER);
    }
}
