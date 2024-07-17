package org.Screener.Pages;

import org.Screener.Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.Screener.Base.BasePage.driver;

public class ScreenPage extends BasePage {

    public ScreenPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[contains(text(),'Screens')]")
    WebElement clickScreen;

    @FindBy(xpath="//a[normalize-space()='Create new screen']")
    WebElement createNewScreen;
    @FindBy(xpath="//textarea[@id='query-builder']")
    WebElement query;

    @FindBy(xpath="//button[normalize-space()='Run this Query']")
    WebElement runThisQuery;

    @FindBy(xpath="a[class='button button-primary']")
    WebElement saveTheQuery;

    public void saveQuery(){
        saveTheQuery.click();
    }

    public void pennyStock(String qry){
        clickScreen.click();
        createNewScreen.click();
        query.sendKeys(qry);
        runThisQuery.click();
    }



}
