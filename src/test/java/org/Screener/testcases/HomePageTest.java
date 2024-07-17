package org.Screener.testcases;

import io.qameta.allure.*;
import org.Screener.Pages.HomePage;
import org.Screener.Pages.LoginPage;
import org.Screener.listner.TestListners;
import org.Screener.utils.ExcelFileReading;
import org.testng.annotations.*;

import java.io.IOException;
@Listeners(TestListners.class)
public class HomePageTest extends HomePage {

    HomePage homepage;
    LoginPage loginPage;
    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp1() throws IOException {
        initialization();
        logger.info("Homepage Method running......");
        homepage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(dataProvider = "LoginData1",dataProviderClass = ExcelFileReading.class)
    @Description("Verify that user can add a company to the watchlist")
    @Epic("EP002")
    @Feature("Watchlist Feature")
    @Story("User adds a company to the watchlist to analyze its fundamentals")
    @Step("User logs in, adds a company to the watchlist, and verifies the addition")
    @Severity(SeverityLevel.NORMAL)
    public void addCompanyToWatchlist(String usr,String pwd,String mob){
        loginPage.directLogin(usr,pwd);
        homepage.addCompany(); //error when same company added again
        homepage.searchCompany("Trent Ltd");
        homepage.done();
        homepage.watchlist();
    }

    @Test(dataProvider = "LoginData1",dataProviderClass = ExcelFileReading.class)
    @Description("Verify that user can export upcoming results")
    @Epic("EP003")
    @Feature("Export Feature")
    @Story("User exports upcoming results for analysis")
    @Step("User logs in, navigates to upcoming results, selects the first result, and exports it")
    @Severity(SeverityLevel.NORMAL)
    public void exportUpcomingResults(String usr,String pwd,String mob){
        loginPage.directLogin(usr,pwd);
        homepage.upcomingRes();
        homepage.firstResult();
        homepage.export();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}
