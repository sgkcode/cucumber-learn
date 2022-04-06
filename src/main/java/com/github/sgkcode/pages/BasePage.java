package com.github.sgkcode.pages;

import com.github.sgkcode.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

  protected BasePage() {
    PageFactory.initElements(DriverManager.getDriver(), this);
  }

  protected WebElement findElement(By by) {
    return DriverManager.getDriver().findElement(by);
  }

  public static void sleepSeconds(double seconds) {
    try {
      Thread.sleep((long) (seconds * 1000L));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
