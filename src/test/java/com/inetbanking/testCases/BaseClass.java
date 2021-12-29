package com.inetbanking.testCases;

import com.inetbanking.utilities.ReadConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();

    public static WebDriver driver;

    // For Logger seting: 1. add dependencies to pom,
    //                    2. copy past log4j.properties file to project home directory.

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br) {
        logger = Logger.getLogger("eBanking");
        PropertyConfigurator.configure("Log4j.properties");

//        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");   // or
//        System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");   // or
//        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");

        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
            driver = new ChromeDriver();
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public String randomestring()
    {
        String ranstring= RandomStringUtils.randomAlphabetic(8);
        return ranstring;
    }

    public static String randomeNum() {
        String rannum = RandomStringUtils.randomNumeric(4);
        return rannum;
    }

}
