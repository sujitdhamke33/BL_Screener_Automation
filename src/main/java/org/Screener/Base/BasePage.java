package org.Screener.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.Screener.Utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BasePage{


    public static Logger logger = Logger.getLogger(String.valueOf(BasePage.class));
    public static WebDriver driver;
    public static Properties properties;

    public ExtentReports extent = new ExtentReports();
    public ExtentReporter spark = new ExtentSparkReporter("C:\\Users\\sujit\\Automation_Final12\\Test_Output\\report.html");

    public BasePage(){
        PageFactory.initElements(driver, this);
        try {

            properties = new Properties();
            FileInputStream file = new FileInputStream("C:\\Users\\sujit\\Automation_Final12\\src\\main\\java\\org\\Screener\\Config\\config.properties");
            properties.load(file);
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sujit\\Automation_Final12\\Resources\\Log4j.properties");
            properties.load(fileInputStream);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void initialization() throws IOException {
        logger.info("Browser name : " +properties.getProperty("browser"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.screener.in/home/");

    }




    // "------------------------------------------------------------"


}