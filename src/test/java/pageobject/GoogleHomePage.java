package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage {

    private final WebDriver driver;
    private static final By TEXT_BOX_SEARCH = By.name("q");

    public GoogleHomePage (WebDriver driver){
        this.driver = driver;
    }

    public static WebElement textBox_search(WebDriver driver) {
        WebElement element = driver.findElement(By.name("q"));
        return element;
    }


    //with Owyn
   /* public void enterSearchTerm (String searchTerm){
     driver.findElement(TEXT_BOX_SEARCH).sendKeys(searchTerm);
    }

     public WebElement TEXT_BOX_SEARCH (WebDriver driver) {

     WebElement element = driver.findElement(By.name("q"));
      return element;

    }*/

    public static WebElement GoogleButton_search (WebDriver driver) {

        WebElement element = driver.findElement(By.name("btnK"));
        return element;

    }

    public static WebElement LuckyButton_search (WebDriver driver) {

        WebElement element = driver.findElement(By.name("btnI"));
        return element;

    }

    public static WebElement CookiesButton_search (WebDriver driver) {

        WebElement  element = driver.findElement(By.id("L2AGLb"));
        return element;

    }
}
