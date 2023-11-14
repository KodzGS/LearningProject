package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.GoogleHomePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefs {
    private WebDriver driver;
    private GoogleHomePage googleHomePage;

    @Before
    public void setup() {
        driver = Setup.setupAndGetDriver();
        googleHomePage = new GoogleHomePage(driver);
    }
    @After
    public void teardown() {
        driver.quit();
    }
    @Given("I am on the Google UK homepage")
    public void iAmOnTheGoogleUKHomepage() {
        googleHomePage.openGoogle();
        googleHomePage.acceptCookies();
    }
    @When("I enter a search term")
    public void iEnterASearchTerm() {
        googleHomePage.enterSearchTerm();
        googleHomePage.googleButtonSearch();
    }
    @Then("results relevant to the search term are returned")
    public void resultsRelevantToTheSearchTermAreReturned() {

        List<WebElement> resultHeaders = googleHomePage.getSearchResults();
        for (WebElement header : resultHeaders) {
            assertThat(header.getText()).as("Search results contains search term").contains("BBC");
        }
    }
}