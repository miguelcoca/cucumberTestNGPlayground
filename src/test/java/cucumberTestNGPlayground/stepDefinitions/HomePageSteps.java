package cucumberTestNGPlayground.stepDefinitions;

import cucumberTestNGPlayground.pageObjects.HomePage;
import cucumberTestNGPlayground.containers.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class HomePageSteps {

    TestContext testContext;

    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("I go to google")
    public void i_go_to_google() {
        homePage.navigateToHomePage();
    }
    @When("I query for {string}")
    public void i_query_for(String string) {
        homePage.fillInSearchQuery(string);
    }
    @When("click search")
    public void click_search() {
        homePage.clickOn_searchButton();
    }
    @Then("google page title should become {string}")
    public void google_page_title_should_become(String string) {
        Assert.assertTrue(homePage.isPageTitleEqTo(string));
    }

    @Then("i should see {string} as {int} of the suggested search")
    public void i_should_see_as_of_the_suggested_search(String expected, Integer int1) {
        List<String> suggestedValues = homePage.getSuggestedSearchList();

        Assert.assertTrue(suggestedValues.stream().filter(value -> value.contains(expected)).findFirst().get().length() >= int1);
    }
}
