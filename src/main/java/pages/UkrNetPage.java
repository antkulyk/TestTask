package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class for ukr.net page
 */
public class UkrNetPage {

    By loginLine = By.id("id-1");
    By passwordLine = By.id("id-2");

    private final WebDriver driver;

    public UkrNetPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setLogin(String line) {
        driver.findElement(loginLine).clear();
        driver.findElement(loginLine).sendKeys(line);
    }

    public void setPassword(String line) {
        driver.findElement(passwordLine).clear();
        driver.findElement(passwordLine).sendKeys(line);
    }

    public void setButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
