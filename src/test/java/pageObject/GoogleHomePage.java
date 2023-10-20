package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GoogleHomePage {
    public static WebDriver driver;
    /**
     * @param driver The interface that every driver class must implement.
     */
    private GoogleHomePage(WebDriver driver) {
        GoogleHomePage.driver = driver;
    }

    /**
     * @throws InterruptedException using thread sleep to interrupt the automation
     */
    public static void OpenGoogle(WebDriver driver) throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.google.co.uk");
        Thread.sleep(4000);
    }
    /**
     * @return this static value will return the ID of the cookie button within google
     */
    public static WebElement CookiesSearch(WebDriver driver) {
        return driver.findElement(By.id("L2AGLb"));
    }

    /**
     * @return this static value will return the element name of the google button
     */
    public static WebElement GoogleButtonSearch(WebDriver driver) {
        return driver.findElement(By.name("btnK"));
    }

    /**
     * @return this static value will return the element name of the search box button
     */
    public static WebElement EnterSearchTerm(WebDriver driver) {
        return driver.findElement(By.name("q"));
    }

}
