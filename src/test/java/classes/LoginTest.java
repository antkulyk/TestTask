package test.java.classes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import main.java.pages.GooglePage;
import main.java.pages.UkrNetPage;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Test login to ukr.net page
 */
public class LoginTest {
    GooglePage googlePage;
    UkrNetPage ukrNetPage;

    @Given("^google opened$")
    public void googleOpened() {
        System.setProperty("webdriver.chrome.driver", "external-lib\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        googlePage = new GooglePage(driver);
        googlePage.start();
    }

    @Then("^ukr.net opened$")
    public void ukrNetOpened() {
        googlePage.search("ukr.net");
        ukrNetPage = new UkrNetPage(googlePage.clickOnLink("Почта @ ukr.net"));
    }

    @Then("^enter login$")
    public void enterLogin() {
        ukrNetPage.setLogin("ii1381924");
    }

    @Then("^enter password$")
    public void enterPassword() {
        ukrNetPage.setPassword("ii1381924ii1381924");
    }

    @Then("^push button$")
    public void pushButton() throws InterruptedException {
        ukrNetPage.setButton();
        sleep(5000);
    }

    @Then("^quit$")
    public void quit() {
        ukrNetPage.getDriver().quit();
    }
}


