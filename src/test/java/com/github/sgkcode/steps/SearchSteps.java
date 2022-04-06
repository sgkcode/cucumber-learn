package com.github.sgkcode.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.sgkcode.pages.ArticlePage;
import com.github.sgkcode.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

  private final SearchPage searchPage = new SearchPage();
  private final ArticlePage articlePage = new ArticlePage();
  private String linkTitle;

  @When("the user clicks on the search icon")
  public void clickOnSearchIcon() {
    searchPage.clickOnSearchIcon();
  }

  @And("the user enters {string} in the opened search bar")
  public void enterSearchQueryInOpenedSearchBar(String searchQuery) {
    searchPage.enterSearchQuery(searchQuery);
  }

  @And("the user filter search results by {string}")
  public void filterSearchResultsBySection(String section) {
    searchPage.filterSearchResultsBySection(section);
  }

  @And("the user opens first link in the format Section|Article name")
  public void openFirstLinkInSearchResults() {
    linkTitle = searchPage.getTitleOfFirstPosition();
    searchPage.clickOnFirstPosition();
  }

  @Then("page with selected article is displayed")
  public void verifyPageHeaderMatchesSelectedLink() {
    assertThat(articlePage.getPageHeaderText())
        .as("Page with title " + linkTitle + " is not displayed")
        .isEqualTo(linkTitle);
  }
}
