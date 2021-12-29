package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
    WebDriver ldriver;

    public AddNewCustomer(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(linkText = "New Customer")
    WebElement lnkAddNewCustomer;

    @FindBy(how = How.NAME, using = "name")
    @CacheLookup
    WebElement txtCustomerName;

    @FindBy(name = "rad1")
    @CacheLookup
    WebElement rdGender;

    @CacheLookup
    @FindBy(id = "dob")
    WebElement txtdob;

    @CacheLookup
    @FindBy(name = "addr")
    WebElement txtaddress;

    @CacheLookup
    @FindBy(name = "city")
    WebElement txtcity;

    @CacheLookup
    @FindBy(name = "state")
    WebElement txtstate;

    @CacheLookup
    @FindBy(name = "pinno")
    WebElement txtpinno;

    @CacheLookup
    @FindBy(name = "telephoneno")
    WebElement txttelephoneno;

    @CacheLookup
    @FindBy(name = "emailid")
    WebElement txtemailid;

    @CacheLookup
    @FindBy(name = "password")
    WebElement txtpassword;

    @CacheLookup
    @FindBy(name = "sub")
    WebElement btnSubmit;

    public void clickAddNewCustomer() {
        lnkAddNewCustomer.click();
    }

    public void custName(String cname) {
        txtCustomerName.clear();
        txtCustomerName.sendKeys(cname);
    }

    public void custgender(String cgender) {
        rdGender.click();
    }

    public void custdob(String mm, String dd, String yy) {
        txtdob.sendKeys(mm);
        txtdob.sendKeys(dd);
        txtdob.sendKeys(yy);
    }

    public void custaddress(String caddress) {
        txtaddress.clear();
        txtaddress.sendKeys(caddress);
    }

    public void custcity(String ccity) {
        txtcity.clear();
        txtcity.sendKeys(ccity);
    }

    public void custstate(String cstate) {
        txtstate.clear();
        txtstate.sendKeys(cstate);
    }

    public void custpinno(String cpinno) {
        txtpinno.clear();
        txtpinno.sendKeys(String.valueOf(cpinno));
    }

    public void custtelephoneno(String ctelephoneno) {
        txttelephoneno.clear();
        txttelephoneno.sendKeys(ctelephoneno);
    }

    public void custemailid(String cemailid) {
        txtemailid.clear();
        txtemailid.sendKeys(cemailid);
    }

    public void custpassword(String cpassword) {
        txtpassword.sendKeys(cpassword);
    }

    public void custsubmit() {
        btnSubmit.click();
    }

}
