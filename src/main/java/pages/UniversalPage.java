package main.java.pages;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class for some page
 */
public class UniversalPage {

    By searchInput = By.id("searchInput");
    By searchButton = By.id("searchButton");
    private final WebDriver driver;

    public UniversalPage(WebDriver driver) {
        this.driver = driver;
    }

    @Then("^New searche finished$")
    public UniversalPage search(String line) {
        driver.findElement(searchInput).click();
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(line);
        driver.findElement(searchButton).click();
        return this;
    }

    @Then("^New link opened$")
    public UniversalPage findAndClickLink(String line) {
        driver.findElement(By.xpath("(//a[contains(text(),'" + line + "')])[4]")).click();
        return this;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
