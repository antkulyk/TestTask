package main.java.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Class for google page
 */
public class GooglePage {


    By searchLine = By.id("lst-ib");

    private final WebDriver driver;
    private String baseUrl = "https://www.google.ru/";

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public GooglePage start() {
        driver.get(baseUrl);
        return this;
    }

    public GooglePage search(String line) {
        driver.findElement(searchLine).clear();
        driver.findElement(searchLine).sendKeys(line);
        driver.findElement(searchLine).sendKeys(Keys.RETURN);
        return this;
    }

    public WebDriver clickOnLink(String link) {
        String oldTab = driver.getWindowHandle();
        driver.findElement(By.linkText(link)).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
        return driver;
    }

    public void clickOnLinkVoid(String link) {
        String oldTab = driver.getWindowHandle();
        driver.findElement(By.linkText(link)).click();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        driver.switchTo().window(newTab.get(0));
    }

    public WebDriver getDriver() {
        return driver;
    }
}
