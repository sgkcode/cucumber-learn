package com.github.sgkcode.pages;

import static java.lang.String.format;

import com.github.sgkcode.driver.DriverManager;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

  private static final String CUCUMBER_URL = "https://cucumber.io/";
  private static final String LINK_PATTERN = "//a[contains(text(), '%s')]";
  private static final String MENU_PATTERN = LINK_PATTERN + "/parent::li";
  private static final String MENU_CHILD_PATTERN = "//*[contains(@class, 'dropdown-mega')]" + LINK_PATTERN;

  public void openPage() {
    DriverManager.getDriver().get(CUCUMBER_URL);
  }

  public void clickOnMenuSection(String text) {
    findElement(By.xpath(format(MENU_PATTERN, text))).click();
  }

  public void clickOnMenuChildItem(String text) {
    findElement(By.xpath(format(MENU_CHILD_PATTERN, text))).click();
  }
}
