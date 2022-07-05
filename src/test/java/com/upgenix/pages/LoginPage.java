package com.upgenix.pages;

import com.upgenix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "login")
    public WebElement usernameInputBox;


    @FindBy(id = "password")
    public WebElement passwordInputBox;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;


    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement WrongLoginPasswordMsg;

    @FindBy(className = "field-password")
    public WebElement field;

    @FindBy(linkText = "Reset Password")
    public WebElement resetPasswordLink;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement bulletPasswordVerify;


}
