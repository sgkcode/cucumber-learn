package com.github.sgkcode.pages;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DocsPage extends BasePage {

  @FindBy(xpath = "//div[@class='page-header']/h1")
  private WebElement pageHeader;
  @FindBy(className = "panel-group")
  private List<WebElement> sidebarItems;

  public String getPageHeaderText() {
    return pageHeader.getText();
  }

  public int getSidebarItemsSize() {
    return sidebarItems.size();
  }

  public List<String> getSidebarItemsTitles() {
    return sidebarItems.stream().map(WebElement::getText).collect(Collectors.toList());
  }
}
