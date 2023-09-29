package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.GoogleHomePage;

import java.time.Duration;
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

    @Given("^I am on the Google UK homepage$")
    public void iAmOnTheGoogleUkHomepage() {
        driver.manage().window().maximize();
        driver.get("https://www.google.co.uk");
    }

    @Given("^I am on the Google UK$")
    public void iAmOnTheGoogleUk() {
        driver.manage().window().maximize();
        driver.get("https://www.google.co.uk");
    }
    @When("^I enter a search term$")
    public void iEnterASearchTerm() {

        // @Darrell - Old code
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='L2AGLb2']"))).click();
        //driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("BBC news");
        //driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);

        //@Darrell - tried to imagine that i was manually clicking through the steps myself and realised this is where we falling over
        //Not a fan of XPath :( changed to 'ID'

        // @Darrell - Tried to avoid using xpath to locate elements
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb"))).click();
       // driver.findElement(By.name("q")).sendKeys("BBC News");
       // driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

        //@Darrell - Can use the following here also
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("q"))).sendKeys("BBC News");
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).sendKeys(Keys.ENTER);

        // @Darrell - PageObject tests (MAIN BUTTON)
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
       // wait.until()GoogleHomePage.CookiesButton_search(driver).click();
        //GoogleHomePage.(driver).sendKeys("BBC News");
      //  GoogleHomePage.GoogleButton_search(driver).sendKeys(Keys.ENTER);


        //@Darrell - @FIXME tag has been removed
     //GoogleHomePage googleHomePage = new GoogleHomePage(driver);
    // googleHomePage.enterSearchTerm("bbc");
    }

    @When("I enter {string} in lucky search term")
    public void iEnterInLuckySearchTerm(String SearchItem) {

        //@Darrell - Lucky search exercise

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb"))).click();

        // @Darrell - Locate the lucky search button
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("q"))).sendKeys(SearchItem);
        //wait.until(ExpectedConditions.elementToBeClickable(By.name("btnI"))).sendKeys(Keys.ENTER);

        // @Darrell - Page Object tests (LUCKY)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        GoogleHomePage.CookiesButton_search(driver).click();
        GoogleHomePage.textBox_search(driver).sendKeys(SearchItem);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnI"))).sendKeys(Keys.ENTER);
        GoogleHomePage.LuckyButton_search(driver).click();

    }

    @Then("results relevant to the search term are returned")
    public void resultsRelevantToTheSearchTermAreReturned() {
        List<WebElement> resultHeaders = driver.findElements(By.xpath("//a/h3"));
        for (WebElement header : resultHeaders) {
            assertThat(header.getText()).as("Search results contains search term").contains("BBC");
        }
    }

    @Then("results to the lucky click are returned")
    public void resultsToTheLuckyClickAreReturned() {
        List<WebElement> resultHeaders = driver.findElements(By.xpath("//a/h3"));
        for (WebElement header : resultHeaders) {
            assertThat(header.getText()).as("Search results contains search term").contains("BBC");
        }
    }


}
