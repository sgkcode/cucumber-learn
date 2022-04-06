package com.github.sgkcode.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.Optional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

  private static final int IMPLICIT_WAIT_TIMEOUT = 5;
  private static final int PAGE_LOAD_TIMEOUT = 20;
  private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

  private DriverManager() {
  }

  public static void setupDriver() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
    webDriverThreadLocal.set(driver);
  }

  public static WebDriver getDriver() {
    return webDriverThreadLocal.get();
  }

  public static void closeDriver() {
    Optional.ofNullable(getDriver()).ifPresent(driver -> {
      driver.quit();
      webDriverThreadLocal.remove();
    });
  }
}
