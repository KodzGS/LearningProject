package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    @Given("I access the Gymshark app")
    public void iAccessTheGymsharkApp() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://uk.gymshark.com");
        Thread.sleep(4000);
    }

    @When("I accept cookies")
    public void iAcceptCookies() throws InterruptedException {
        Thread.sleep(3000);
        WebElement element1 = driver.findElement(By.id("onetrust-accept-btn-handler"));
        element1.click();
    }

    @Then("I should see the features on the site")
    public void iShouldSeeTheFeaturesOnTheSite() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("__next"));
    }


    @Given("I have access the site and login page")
    public void iHaveAccessTheSiteAndLoginPage() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://uk.gymshark.com");
        Thread.sleep(4000);
        WebElement element1 = driver.findElement(By.id("onetrust-accept-btn-handler"));
        element1.click();

    }

    @When("I key in my username and password")
    public void iKeyInMyUsernameAndPassword() throws InterruptedException {

        driver.get("https://auth.gymshark.com/login?state=hKFo2SBVN3AzQnFPWkRpemlPY0UtQUtZYnNnZ3hsVWtocWQtUqFupWxvZ2luo3RpZNkga3puLV9lLWtWQ1JYbW1hR1hoUGRuS0R4SnZVZElIamSjY2lk2SAyd2JDeUhWbTFEZElYMkV3ZEU3bTBxVkliWGpPQ1RYag&client=2wbCyHVm1DdIX2EwdE7m0qVIbXjOCTXj&protocol=oauth2&scope=openid%20profile%20email&response_type=code&redirect_uri=https%3A%2F%2Fuk.gymshark.com%2Fapi%2Fauth%2Fcallback&audience=https%3A%2F%2Fgateway.api.gymshark.com&locale=en-GB&realm=gb&multipass_redirect_uri=https%3A%2F%2Fuk.gymshark.com%2Faccount&nonce=TztFy1GqFaovYzKXx6SNYhOBajSjCMvmHZ-zGzM6TIk&code_challenge=0Aj3VOoQqCN3BiY2PwPzqly4z1lYfpi5umRNLyQYUfc&code_challenge_method=S256");
        Thread.sleep(4000);
        WebElement element3 = driver.findElement(By.id("login-email"));
        element3.sendKeys("kodi-uk@mailinator.com");

        WebElement element4 = driver.findElement(By.id("current-password"));
        element4.sendKeys("P@55w0rd3636");


        Thread.sleep(4000);
    }

    @Then("I should my see account")
    public void iShouldMySeeAccount() throws InterruptedException {

        Thread.sleep(4000);

        String expectedTitle = "YOUR GYMSHARK ACCOUNT";

        String title = driver.getTitle();

        if (title.equalsIgnoreCase(expectedTitle)) {
            System.out.println("Title Matched");
        } else {
            System.out.println("Not a match");
        }


    }
}
