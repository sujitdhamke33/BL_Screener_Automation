package org.Screener.Pages;

import org.Screener.Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[normalize-space()='Watchlist View']")
    WebElement clickWatchlist;

    @FindBy(xpath="//div[@id='desktop-search']//input[@placeholder='Search for a company']")
    WebElement searchCompany;

    @FindBy(xpath="//a[contains(text(),'Screens')]")
    WebElement clickScreen;

    @FindBy(xpath="//button[contains(text(),'Tools')]")
    WebElement tools;

    @FindBy(xpath="//i[@class='icon-list']")
    WebElement addCompany;

    @FindBy(xpath="//input[@id='watchlist-search']")
    WebElement companyName;
    @FindBy(xpath="//a[normalize-space()='Done']")
    WebElement done;

    @FindBy(xpath="//ul[@class='box-shadow list-style-none margin-bottom-24 font-size-14 font-weight-500 padding-left-small padding-right-small padding-top-tiny padding-bottom-tiny']//div[@class='shrink-text'][normalize-space()='Upcoming Results']")
    WebElement upcomingResults;

    @FindBy(xpath="//a[normalize-space()='DEE Development Engineers Ltd']")
    WebElement firstResult;

    @FindBy(xpath="//*[@id=\"top\"]/div[1]/form/button/span")
    WebElement export;

    public void watchlist(){
        clickWatchlist.click();
    }

    public void searchCompany(String cName){
        searchCompany.sendKeys(cName);
    }

    public void screen(){
        clickScreen.click();
    }

    public void addCompany(){
        addCompany.click();
    }
    public void done(){
        done.click();
    }
    public void upcomingRes(){
        upcomingResults.click();
    }
    public void firstResult(){
        firstResult.click();
    }

    public void export(){
        export.click();
    }
    public void addCompanyCore(String name){
        companyName.sendKeys(name);
    }
    public void upcomingResults1() throws InterruptedException {
        upcomingRes();
        Thread.sleep(2000);
        firstResult();
        export();
    }

}
