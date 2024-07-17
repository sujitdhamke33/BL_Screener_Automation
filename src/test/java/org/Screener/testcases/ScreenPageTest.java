package org.Screener.testcases;

import io.qameta.allure.*;
import org.Screener.Pages.LoginPage;
import org.Screener.Pages.ScreenPage;
import org.Screener.listner.TestListners;
import org.Screener.utils.ExcelFileReading;
import org.testng.annotations.*;

import java.io.IOException;

import static org.Screener.Base.BasePage.initialization;
@Listeners(TestListners.class)
public class ScreenPageTest extends ScreenPage {

    LoginPage loginPage;
    ScreenPage screenPage;

    public ScreenPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp2() throws IOException {
        initialization();
        logger.info("Screeenpage Method Running");
        loginPage = new LoginPage();
        screenPage = new ScreenPage();
    }



    @Test(dataProvider = "LoginData1",dataProviderClass = ExcelFileReading.class)
    @Description("Verify that user can find penny stocks")
    @Epic("EP004")
    @Feature("Penny Stock Feature")
    @Story("User finds penny stocks with a current price less than 20")
    @Step("User logs in and searches for penny stocks with a current price less than 20")
    @Severity(SeverityLevel.NORMAL)
    public void pennyStockList(String usr,String pwd,String num){
        loginPage.directLogin(usr,pwd);
        screenPage.pennyStock("Current price < 20");
    }

    @Test(dataProvider = "LoginData1",dataProviderClass = ExcelFileReading.class)
    public void largeCapStocks(String usr,String pwd,String num){
        loginPage.directLogin(usr,pwd);
        screenPage.pennyStock("Current price > 1000 AND\n" +
                "Market capitalization > 50000 ");
    }

    @Test(dataProvider = "LoginData1",dataProviderClass = ExcelFileReading.class)
    @Description("Verify that user can find large-cap stocks")
    @Epic("EP005")
    @Feature("Large-Cap Stock Feature")
    @Story("User finds large-cap stocks with a current price greater than 1000 and market capitalization greater than 50000")
    @Step("User logs in and searches for large-cap stocks with specified criteria")
    @Severity(SeverityLevel.NORMAL)
    public void saveQueryStock(String usr,String pwd,String num){
        loginPage.directLogin(usr,pwd);
        screenPage.pennyStock("Current price > 100 AND\n" +
                "Market capitalization > 3300 ");
        screenPage.saveQuery();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        //driver.quit();
    }

}
