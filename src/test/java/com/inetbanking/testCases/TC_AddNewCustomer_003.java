package com.inetbanking.testCases;

import com.inetbanking.pageObjects.AddNewCustomer;
import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AddNewCustomer_003 extends BaseClass {

    @Test
    public void addNewCustomer() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        lp.setPassword(password);
        logger.info("Login Successful");
        lp.clickSubmit();
        //Thread.sleep(3000);

        AddNewCustomer addcust = new AddNewCustomer(driver);

        addcust.clickAddNewCustomer();

        addcust.custName("Belayet");
        addcust.custgender("male");
        addcust.custdob("08", "16", "1964");
        //Thread.sleep(3000);

        addcust.custaddress("United State");
        addcust.custcity("New York");
        addcust.custstate("NY");
        addcust.custpinno("20024533");
        addcust.custtelephoneno("3475479857");
        //Thread.sleep(3000);

        String email = randomestring() + "@gmail.com";
        addcust.custemailid(email);
        addcust.custpassword("abc123");
        logger.info("Other Information Provided");
        addcust.custsubmit();

        Thread.sleep(3000);

        boolean reg = driver.getPageSource().contains("Customer Registered Successful");
        if(reg==true){
            Assert.assertTrue(true);
            logger.info("Customer Successfully Entered, Test Pass");
        }else{
            Assert.assertTrue(false);
            logger.info("Unable to Entered");
        }

    }
}
