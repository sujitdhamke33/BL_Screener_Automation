package org.Screener.testcases;


import org.Screener.Pages.LoginPage;
import org.Screener.Pages.ProfilePage;
import org.Screener.listner.TestListners;
import org.Screener.utils.ExcelFileReading;
import org.testng.annotations.*;

import java.io.IOException;

import static org.Screener.Base.BasePage.initialization;
@Listeners(TestListners.class)
public class ProfilePageTest extends ProfilePage {

    LoginPage loginpage;
    ProfilePage profilePage;

    public ProfilePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialization();
        logger.info("Profile Method Running");
        loginpage = new LoginPage();
        profilePage = new ProfilePage();
    }



    @Test(dataProvider = "LoginData1",dataProviderClass = ExcelFileReading.class)
    public void upgradePremium(String usr,String pwd,String num) throws InterruptedException {
        loginpage.directLogin(usr,pwd);
        profilePage.profileMeth(num);
    }

    @Test(dataProvider = "LoginData1",dataProviderClass = ExcelFileReading.class)
    public void changeNameScreener(String usr,String pwd,String num) throws InterruptedException {
        loginpage.directLogin(usr,pwd);
        profilePage.nameChange();
    }

    @Test(dataProvider = "LoginData1",dataProviderClass = ExcelFileReading.class)
    public void aboutTextArea(String usr,String pwd,String num) throws InterruptedException {
        loginpage.directLogin(usr,pwd);
        profilePage.about();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}

