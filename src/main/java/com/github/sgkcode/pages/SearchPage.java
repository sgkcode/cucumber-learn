package com.github.sgkcode.pages;

import static java.lang.String.format;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

  @FindBy(xpath = "//a[contains(@class,'header-search-ico')]")
  private WebElement searchIcon;
  @FindBy(xpath = "//input[@name='search']")
  private WebElement searchInput;
  @FindBy(xpath = "//div[@class='result-list']/a")
  private List<WebElement> searchResultsList;

  private static final String LINK_TITLE = "//div[@class='link-title']";
  private static final String FILTER_NAME_PATTERN = "//div[@class='filter-item-name' and text()='%s']";

  public void clickOnSearchIcon() {
    searchIcon.click();
  }

  public void enterSearchQuery(String searchQuery) {
    searchInput.sendKeys(searchQuery);
    searchInput.sendKeys(Keys.ENTER);
    sleepSeconds(0.5);
  }

  public void filterSearchResultsBySection(String section) {
    findElement(By.xpath(format(FILTER_NAME_PATTERN, section))).click();
  }

  public String getTitleOfFirstPosition() {
    return searchResultsList.get(0).findElement(By.xpath(LINK_TITLE)).getText();
  }

  public void clickOnFirstPosition() {
    searchResultsList.get(0).click();
  }
}
