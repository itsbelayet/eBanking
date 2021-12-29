package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass {

    public boolean isAlertPresent(){
        try{
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }

    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(user);
        lp.setPassword(pwd );
        lp.clickSubmit();
        if(isAlertPresent()==true){
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);

        }else {
            Assert.assertTrue(true);
            lp.clickLogout();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }

    }

    @DataProvider(name = "LoginData")
    String [][] getData() throws IOException {
        String fpath = "Data/LoginData.xlsx";
        int rownum = XLUtils.getRowCount(fpath, "Sheet1");
        int colcount = XLUtils.getCellCount(fpath, "Sheet1", 1);

        String logindata[][] = new String[rownum][colcount];
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                logindata[i - 1][j] = XLUtils.getCellData(fpath, "Sheet1", i, j);
            }
        }
        return logindata;
    }
}
