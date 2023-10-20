package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.GoogleHomePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefs {
    public WebDriver driver;

    @Before
    public void setup() {
        driver = Setup.setupAndGetDriver();
    }
    @After
    public void teardown() {
        driver.quit();
    }
    @Given("I am on the Google UK homepage")
    public void iAmOnTheGoogleUKHomepage() throws InterruptedException {
        GoogleHomePage.OpenGoogle(driver);
        GoogleHomePage.CookiesSearch(driver);
        GoogleHomePage.CookiesSearch(driver).click();
        Thread.sleep(4000);
    }
    @When("I enter a search term")
    public void iEnterASearchTerm() throws InterruptedException {
        GoogleHomePage.EnterSearchTerm(driver);
        GoogleHomePage.EnterSearchTerm(driver).sendKeys("BBC News");
        Thread.sleep(4000);
        GoogleHomePage.GoogleButtonSearch(driver).click();
    }
    @Then("results relevant to the search term are returned")
    public void resultsRelevantToTheSearchTermAreReturned() {

        List<WebElement> resultHeaders = driver.findElements(By.xpath("//a/h3"));
        for (WebElement header : resultHeaders) {
            assertThat(header.getText()).as("Search results contains search term").contains("BBC");
        }
    }
}