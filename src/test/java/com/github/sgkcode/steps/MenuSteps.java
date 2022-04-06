package com.github.sgkcode.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.sgkcode.pages.DocsPage;
import com.github.sgkcode.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuSteps {

  private final HomePage homePage = new HomePage();
  private final DocsPage docsPage = new DocsPage();

  @When("the user opens Cucumber website")
  public void openCumberWebsite() {
    homePage.openPage();
  }

  @When("the user clicks on the {string} section")
  public void clickOnSection(String section) {
    homePage.clickOnMenuSection(section);
  }

  @When("the user clicks on the {string} item")
  public void clickOnItem(String item) {
    homePage.clickOnMenuChildItem(item);
  }

  @Then("page with title {string} is displayed")
  public void verifyPageTitlePresence(String pageTitle) {
    assertThat(docsPage.getPageHeaderText())
        .overridingErrorMessage("Page with title '%s' is not displayed", pageTitle)
        .isEqualTo(pageTitle);
  }
}
