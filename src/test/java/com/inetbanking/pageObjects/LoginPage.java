package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(name="uid")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(name="password")
    WebElement txtPassword;

    @FindBy(name="btnLogin")
    WebElement btnLogin;

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
    WebElement linkLogout;

    public void setUserName(String uname){
        txtUserName.clear();
        txtUserName.sendKeys(uname);
    }

    public void setPassword(String pass){
        txtPassword.clear();
        txtPassword.sendKeys(pass);
    }
    public void clickSubmit(){
        btnLogin.click();
    }
    public void clickLogout(){
        linkLogout.click();
    }


}

