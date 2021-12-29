package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass{

    // Run this Test through testng.xml

    @Test
    public void loginTest() throws InterruptedException {

        logger.info("URL is open");
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickSubmit();
        logger.info("Submit Click");
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"Guru99 Bank Manager HomePage","Pass");

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("Login Test Passed");
        }else {
            Assert.assertTrue(false);
            logger.info("Login Test failed");
        }
    }
}
