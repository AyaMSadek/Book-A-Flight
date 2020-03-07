package mercuryregister.definitions;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mercuryregister.chromeDriver.LaunchApplication;
import mercuryregister.steps.BookAFlightSteps;
import net.thucydides.core.annotations.Steps;

public class BookAFlightValidationsDefinition {
    @Steps
    private BookAFlightSteps steps;
    private LaunchApplication launchApplication;

    @Before
    public void userOpensTheWebsite() {
        launchApplication.openWebsitePage();
    }

    @Given("^user opened the website URL$")
    public void userOpenedTheWebsiteURL() {
        steps.userOpenedTheWebsiteURL();
    }

    @When("^user tries to open flights page$")
    public void userTriesToOpenFlightsPage() {
        steps.userTriesToOpenFlightsPage();

    }

    @Then("^home page is still opened and user can't go to flights page$")
    public void homePageIsStillOpenedAndUserCanTGoToFlightsPage() {
        steps.assertThatHomePageIsStillOpened();

    }

    @When("^user tries to login with \"([^\"]*)\" with \"([^\"]*)\"$")
    public void userTriesToLoginWithWith(String user, String password) throws Throwable {
        steps.userTriesToLoginWithInvalidUserNameOrPassword(user,password);
    }

    @Then("^sign on page is still opened and user can't go to home page$")
    public void signOnPageIsStillOpenedAndUserCanTGoToHomePage() {
        steps.assertThatSignOnPageIsStillOpened();
    }

    @And("^user is logged in as \"([^\"]*)\" with \"([^\"]*)\"$")
    public void userIsLoggedInAsWith(String user, String password) throws Throwable{
        steps.userLoginsWithUserNameAndPassword(user,password);
    }

    @When("^user navigates back from browser and forward again to home page$")
    public void userNavigatesBackFromBrowserAndForwardAgainToHomePage() {
        steps.userNavigatesBackFromBrowserAndForwardAgainToHomePage();
    }

    @Then("^user is still logged in and home page opens successfully$")
    public void userIsStillLoggedInAndHomePageOpensSuccessfully() {
        steps.assertThatUserIsStillLoggedInAndHomePageOpensSuccessfully();

    }
}
