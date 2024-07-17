package org.Screener.listner;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ExtentObserver;
import org.Screener.Base.BasePage;
import org.Screener.utils.Utility;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListners extends BasePage implements ITestListener {
    Utility utility = new Utility();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+ " :onTestStart");
        extent.attachReporter((ExtentObserver) spark);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" :onTestSuccess");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.pass("Test successfully executed");
        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " :onTestFailure");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("Sujit").assignDevice("Windows 11,Chrome");
        test.fail("Test method failed");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File fs = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\sujit\\Automation_Final12\\Screenshots\\"+result.getMethod().getMethodName()+".png");
        try {
            FileHandler.copy(fs,des);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Utility.failedTest(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        test.addScreenCaptureFromPath("C:\\Users\\sujit\\Automation_Final12\\Screenshots\\" + result.getMethod().getMethodName() + ".png");
        extent.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName()+" :onTestSkipped");
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.skip("Test method Skipped..");
        extent.flush();
    }
}
