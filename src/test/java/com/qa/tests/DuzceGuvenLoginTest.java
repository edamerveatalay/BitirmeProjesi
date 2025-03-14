package com.qa.tests;

import Base.BaseTest;
import Base.BaseLibrary;
import Base.LoginData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DuzceGuvenLoginTest extends BaseTest {

    @Test
    public void testUnsuccessfulLogin() {
        driver.get("https://www.duzceguven.com.tr/");


        WebElement loginLink = BaseLibrary.waitForElementClickable(
            By.cssSelector("a.popup-text.login-style[href='#oturum_ac_dialog']"), 10);
        loginLink.click();

        WebElement membershipInput = BaseLibrary.waitForElementPresent(By.id("cntrlMemberNo"), 10);


        membershipInput.sendKeys(LoginData.MEMBERSHIP_NUMBER);

        BaseLibrary.sleep(3000);

        WebElement passwordInput = BaseLibrary.waitForElementPresent(By.id("cntrlMemberPass"), 10);
        passwordInput.sendKeys(LoginData.PASSWORD);

      
        BaseLibrary.sleep(3000);

        WebElement loginButton = BaseLibrary.waitForElementClickable(
            By.cssSelector("input.btn.btn-lg[value='Giriş Yap']"), 10);
        loginButton.click();

        BaseLibrary.sleep(60000);

        assertTrue(membershipInput.getAttribute("value").equals(LoginData.MEMBERSHIP_NUMBER), 
            "Membership number should be " + LoginData.MEMBERSHIP_NUMBER);
        assertTrue(passwordInput.getAttribute("value").equals(LoginData.PASSWORD), 
            "Password should be " + LoginData.PASSWORD);
    }

   /* @Test
    public void testSuccessfulLogin() {
        driver.get("https://www.duzceguven.com.tr/");

        WebElement loginLink = BaseLibrary.waitForElementClickable(
            By.cssSelector("a.popup-text.login-style[href='#oturum_ac_dialog']"), 10);
        loginLink.click();

        WebElement membershipInput = BaseLibrary.waitForElementPresent(By.id("cntrlMemberNo"), 10);

        membershipInput.sendKeys(LoginData.MEMBERSHIP_NUMBER);

        BaseLibrary.sleep(3000);

        WebElement passwordInput = BaseLibrary.waitForElementPresent(By.id("cntrlMemberPass"), 10);
        passwordInput.sendKeys(LoginData.PASSWORD);

        BaseLibrary.sleep(3000);

        WebElement loginButton = BaseLibrary.waitForElementClickable(
            By.cssSelector("input.btn.btn-lg[value='Giriş Yap']"), 10);
        BaseLibrary.clickWithJavaScript(loginButton);

        BaseLibrary.sleep(60000);

        assertTrue(membershipInput.getAttribute("value").equals(LoginData.MEMBERSHIP_NUMBER), 
            "Membership number should be " + LoginData.MEMBERSHIP_NUMBER);
        assertTrue(passwordInput.getAttribute("value").equals(LoginData.PASSWORD), 
            "Password should be " + LoginData.PASSWORD);
    }*/
} 