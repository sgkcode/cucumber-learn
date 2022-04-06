package com.github.sgkcode.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.sgkcode.pages.DocsPage;
import io.cucumber.java.en.Then;
import java.util.List;

public class DocsSteps {

  private final DocsPage docsPage = new DocsPage();

  @Then("there are {int} items in the left-side menu")
  public void verifyLeftSideMenuSize(int expectedSize) {
    assertThat(docsPage.getSidebarItemsSize())
        .as("the left-side menu size is not as expected")
        .isEqualTo(expectedSize);
  }

  @Then("left-side menu contain the following links")
  public void verifyLeftSideMenuContainFollowingLinks(List<String> expectedTitles) {
    assertThat(docsPage.getSidebarItemsTitles())
        .as("Some of left-side menu titles are not as expected")
        .isEqualTo(expectedTitles);
  }
}
