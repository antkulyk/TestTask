package test.java.classes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import main.java.pages.GooglePage;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Test open page from google
 */
public class OpenPageTest {
    GooglePage googlePage;

    @Given("^opened google$")
    public void openedGoogle() {
        System.setProperty("webdriver.chrome.driver", "external-lib\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        googlePage = new GooglePage(driver);
        googlePage.start();
    }

    @Then("^opened miratech$")
    public void openedMiratech() throws InterruptedException {
        googlePage.search("miratech");
        googlePage.clickOnLinkVoid("Миратех");
        sleep(18000);
    }

    @Then("^close open page$")
    public void closed() {
        googlePage.getDriver().quit();
    }
}
