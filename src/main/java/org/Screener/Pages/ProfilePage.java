package org.Screener.Pages;

import org.Screener.Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {
    public ProfilePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//*[@id=\"account-dropdown\"]/button")
    WebElement clickProfile;
    @FindBy(xpath="//body[1]/nav[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/a[4]")
    WebElement clickUpgrade;

    @FindBy(xpath = "//a[normalize-space()='Profile']")
    WebElement clickOnProfileMethod;

    @FindBy(xpath = "//input[@id='id_display_name']")
    WebElement enterNameHere;

    @FindBy(xpath = "//textarea[@id='id_about']")
    WebElement aboutText;

    @FindBy(xpath = "//button[normalize-space()='Save Changes']")
    WebElement saveChanges;
    @FindBy(xpath="//button[@class='button-large u-full-width button-secondary']")
    WebElement clickUpgradeNow;

    @FindBy(xpath="//button[@class='button-large u-full-width button-secondary']")
    WebElement enterNumber;
    @FindBy(xpath="//button[@class='button-large u-full-width button-secondary']")
    WebElement enterProceed;

    public void enterNumber(String num){
        enterNumber.sendKeys(num);
    }

    public void profileMeth(String num){
        clickProfile.click();
        clickUpgrade.click();
        clickUpgradeNow.click();
        driver.switchTo().frame(0);

    }

    public void nameChange(){
        clickProfile.click();
        clickOnProfileMethod.click();
        enterNameHere.clear();
        enterNameHere.sendKeys("Sujit Dhamke");
        saveChanges.click();
    }

    public void about() throws InterruptedException {
        clickProfile.click();
        clickOnProfileMethod.click();
        enterNameHere.clear();
        enterNameHere.sendKeys("Sujit Dhamke");
        Thread.sleep(4000);
        aboutText.sendKeys("I am SDET Engineer");
        saveChanges.click();
    }
}
