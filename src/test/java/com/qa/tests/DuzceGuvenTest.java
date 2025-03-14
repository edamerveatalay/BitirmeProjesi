package com.qa.tests;

import Base.BaseTest;
import Base.BaseLibrary;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Epic("Düzce Güven Bilet Rezervasyon Sistemi")
@Feature("Sefer Arama")
public class DuzceGuvenTest extends BaseTest {

    @Test
    @Story("Sefer Arama Testi")
    @Description("Zonguldak'tan Balıkesir'e sefer arama testi")
    @Severity(SeverityLevel.CRITICAL)
    public void testDepartureSelection() {
        driver.get("https://www.duzceguven.com.tr/");
        
        BaseLibrary.sleep(2000);
        
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            
            WebElement cookieAcceptButton = null;
            
            try {
                cookieAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(), 'Kabul Et') or contains(text(), 'Kabul') or contains(text(), 'Accept')]")));
            } catch (Exception e) {
                try {
                    cookieAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".cookie-accept, .accept-cookies, .cookie-consent button, .cookies-btn")));
                } catch (Exception e2) {
                    cookieAcceptButton = driver.findElement(
                        By.cssSelector("[id*='cookie'] button, [class*='cookie'] button, [id*='consent'] button"));
                }
            }
            
            if (cookieAcceptButton != null) {
                cookieAcceptButton.click();
                System.out.println("Cookies accepted");
                
                BaseLibrary.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("No cookie consent found or error: " + e.getMessage());
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement departureDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("departure")));

        Select departureSelect = new Select(departureDropdown);

        departureSelect.selectByVisibleText("ZONGULDAK");

        BaseLibrary.sleep(5000);

        WebElement selectedOption = departureSelect.getFirstSelectedOption();
        assertTrue(selectedOption.getText().equals("ZONGULDAK"), "ZONGULDAK should be selected as departure point");

        WebElement arrivalDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("arrival")));
        Select arrivalSelect = new Select(arrivalDropdown);
        arrivalSelect.selectByVisibleText("BALIKESİR");

        BaseLibrary.sleep(3000);

        WebElement selectedArrivalOption = arrivalSelect.getFirstSelectedOption();
        assertTrue(selectedArrivalOption.getText().equals("BALIKESİR"), "BALIKESİR should be selected as arrival point");

        WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("seferTarih")));
        
        dateInput.click();
        
        BaseLibrary.sleep(1000);
        
        try {
            List<WebElement> dayElements = driver.findElements(By.cssSelector(".datepicker-days .day"));
            for (WebElement day : dayElements) {
                if (day.getText().equals("15")) {
                    day.click();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not select day from date picker: " + e.getMessage());
            dateInput.sendKeys(Keys.ESCAPE);
            
            if (dateInput.getAttribute("value").isEmpty()) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].value = '15/03/2026';", dateInput);
            }
        }
        
        BaseLibrary.sleep(2000);
        
        String selectedDate = dateInput.getAttribute("value");
        System.out.println("Selected date: " + selectedDate);
        
        assertFalse(selectedDate.isEmpty(), "A date should be selected");
        
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("button.btn.btn-primary.btn-lg[type='submit']")));
            
        searchButton.click();

        BaseLibrary.sleep(60000);
        
    }
} 