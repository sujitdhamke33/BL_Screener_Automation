package org.Screener.Pages;

import org.Screener.Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BasePage {

    public LoginPage() throws IOException {
        PageFactory.initElements(driver, this);
    }
    public String email = properties.getProperty("emailId");
    public String pwd = properties.getProperty("pass");

    @FindBy(xpath=" //a[@class='button account']")
    WebElement clickLogin;

    @FindBy(name="username")
    WebElement username;

    @FindBy(id="id_password")
    WebElement password;

    @FindBy(xpath="//button[normalize-space()='Login']")
    WebElement loginBtn;

    @FindBy(xpath="//a[normalize-space()='Lost password?']")
    WebElement forgotPassword;

       @FindBy(xpath="//button[normalize-space()='Online']")
    WebElement logout1;

       @FindBy(xpath="//button[normalize-space()='Logout']")
    WebElement logout2;


    public void clickLogin(){
        clickLogin.click();
    }
    public void enterUsername(String email){
        username.sendKeys(email);
    }

    public void enterUsernameSingle(){
        username.sendKeys(properties.getProperty("username"));
    }

    public void enterPass(String pass){
        password.sendKeys(pass);
    }

    public void enterPassSingle(){
        password.sendKeys(properties.getProperty("password"));
    }

    public void enterLogin(){
        loginBtn.click();
    }

    public void directLogin(String usr,String pwd){
        clickLogin();
        enterUsername(usr);
        enterPass(pwd);
        enterLogin();
//        logout1.click();
//        logout2.click();
    }

}
