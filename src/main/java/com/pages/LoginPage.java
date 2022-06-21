package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    //1. By locators:
    private By emailID = By.id("email");
    private By passwordID = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPwdLink = By.linkText("Forgot your password?");

    //2. Constructors of the page class
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. page actions: features(behavior) of the page the form of methods:
    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist(){
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailID).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(passwordID).sendKeys(pwd);
    }

    public void clickOnLogin(){
        driver.findElement(signInButton).click();
    }

    //this part of code for AccountsPage
    public AccountsPage doLogin(String un, String pwd){
        System.out.println("Login with " + un + " and" + pwd);
        driver.findElement(emailID).sendKeys(un);
        driver.findElement(passwordID).sendKeys(pwd);
        driver.findElement(signInButton).click();
        return new AccountsPage(driver);
    }

}
