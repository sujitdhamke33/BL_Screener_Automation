package org.Screener.testcases;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.Screener.Pages.LoginPage;
import org.Screener.Utils.WebDriverManager;
import org.Screener.listner.TestListners;
import org.Screener.utils.ExcelFileReading;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
@Listeners(TestListners.class)
public class LoginPageTest extends LoginPage {
    public LoginPageTest() throws IOException {

    }

    LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws IOException {
       initialization();
       logger.info("Login method running....");
        loginPage = new LoginPage();
    }



    @Test(priority = 1,dataProvider = "LoginData1",dataProviderClass = ExcelFileReading.class)
    @Description("Verify that user can able to log in ")
    @Epic("EP001")
    @Feature("Login Feature")
    @Story("User logs in with valid credentials")
    @Step("User logs in with username: {0}, password: {1}")
    @Severity(SeverityLevel.BLOCKER)
    public void Sheet1(String usr,String pwd,String mob) {
        loginPage.directLogin(usr,pwd);

}

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}
