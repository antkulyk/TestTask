package test.java.classes;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import main.java.pages.GooglePage;
import main.java.pages.UniversalPage;

import static java.lang.Thread.sleep;

/**
 * Test open page from google and open new link
 */
public class OpenInnerPageTest {
    GooglePage googlePage;
    UniversalPage wikiPage;

    @Given("^open first page$")
    public void openFirstPage() {
        System.setProperty("webdriver.chrome.driver", "external-lib\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        googlePage = new GooglePage(driver);
        googlePage.start();
    }

    @Then("^open wiki page$")
    public void openWikiPage() {
        googlePage.search("wiki");
        wikiPage = new UniversalPage(googlePage.clickOnLink("Вики — Википедия"));
    }

    @Then("^make search$")
    public void makeSearch() {
        wikiPage.search("selenium");
    }

    @Then("^click of link$")
    public void clickOnLink() throws InterruptedException {
        wikiPage.findAndClickLink("Firefox");
        sleep(3000);
    }

    @Then("^close inner open page$")
    public void closed() {
        wikiPage.getDriver().quit();
    }
}
