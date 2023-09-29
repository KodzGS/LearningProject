package stepdefs;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.logging.Level;

public class Setup {

  public static WebDriver setupAndGetDriver() {
    //WebDriverManager.chromedriver().setup();
    return new ChromeDriver(getCapabilities());
  }

  private static ChromeOptions getCapabilities() {
    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.BROWSER, Level.ALL);
    logPrefs.enable(LogType.DRIVER, Level.ALL);

    ChromeOptions options = new ChromeOptions();

    options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
    //options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
    options.addArguments("--enable-automation");
    options.addArguments("--enable-crash-reporter");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-gpu");
    options.addArguments("--no-sandbox");
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    options.setHeadless(false);
    options.setAcceptInsecureCerts(true);
    return options;
  }
}
