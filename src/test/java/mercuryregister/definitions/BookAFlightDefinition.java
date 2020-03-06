package mercuryregister.definitions;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mercuryregister.chromeDriver.LaunchApplication;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import mercuryregister.steps.BookAFlightSteps;
import net.thucydides.core.annotations.Steps;

public class BookAFlightDefinition extends LaunchApplication{

    @Steps
    private BookAFlightSteps steps;
    private LaunchApplication launchApplication;

   @Before
   public void userOpensTheWebsite() {
       launchApplication.openWebsitePage();
   }

    @Given("^user is registered with the following values:$")
    public void userIsRegisteredWithTheFollowingValues(DataTable registrationDataTable) throws InterruptedException {
        steps.userRegisters(registrationDataTable);
    }

    @And("^user logged in as \"([^\"]*)\" with \"([^\"]*)\"$")
    public void userLoggedInAsWith(String user, String password) throws Throwable {
        steps.assertThatUserNameIsCorrect(user);
        steps.userLoginsWithUserNameAndPassword(user,password);
    }


    @When("^user books a flight with the following details:$")
    public void userBooksAFlightWithTheFollowingDetails(DataTable bookingDetailsTable) throws InterruptedException {
        steps.userBooksAFlight(bookingDetailsTable);
    }

    @Then("^user makes sure that the booking details are true with the following details:$")
    public void userMakesSureThatTheBookingDetailsAreTrueWithTheFollowingDetails(DataTable bookingDetailsTable) {
        steps.assertThatBookingDetailsAreCorrect(bookingDetailsTable);
    }


    @Given("^website page is opened$")
    public void websitePageIsOpened() {
       steps.assertThatTheWebsitePageIsOpened();
    }

    @When("^user tries to login with \"([^\"]*)\" or \"([^\"]*)\"$")
    public void userTriesToLoginWithWith(String user, String password) throws Throwable {
        steps.userTriesToLoginWithInvalidUserNameOrPassword(user,password);

    }

    @Then("^user can't go to Booking page$")
    public void userCanTGoToBookingPage() {
       steps.assertThatUserCantGoToBookingPage();
    }

    @After
    public void tearDown() {
        LaunchApplication.closeDriver();
    }
}
