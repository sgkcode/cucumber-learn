package com.github.sgkcode.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends BasePage {

  @FindBy(xpath = "//div[contains(@class,'hero-header')]")
  private WebElement pageHeader;

  public String getPageHeaderText() {
    return pageHeader.getText();
  }
}
