package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleHomePage {
    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * @param driver The interface that every driver class must implement.
     */
    public GoogleHomePage(WebDriver driver) {

        // Set up explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.driver = driver;
    }

    public void openGoogle() {
        driver.manage().window().maximize();
        driver.get("https://www.google.co.uk");
    }

    public void acceptCookies() {
       //driver.findElement(By.id("L2AGLb")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("L2AGLb"))).click();
    }

    public void googleButtonSearch() {
       // driver.findElement(By.name("btnK")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK"))).sendKeys(Keys.RETURN);
    }

    public void enterSearchTerm() {
       // driver.findElement(By.name("q")).sendKeys("BBC News");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("q"))).sendKeys("BBC News");
    }

    public List<WebElement> getSearchResults() {
       return driver.findElements(By.xpath("//a/h3"));
       //return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='rcnt']//a/h3")));
    }

}

// explicit waits