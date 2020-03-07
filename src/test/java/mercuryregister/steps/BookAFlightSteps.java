package mercuryregister.steps;

import cucumber.api.DataTable;
import mercuryregister.chromeDriver.LaunchApplication;
import mercuryregister.pages.BookingPage;
import mercuryregister.pages.HomePage;
import mercuryregister.pages.LoginPage;
import mercuryregister.pages.RegistrationPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.PageFactory;
import java.util.Map;

public class BookAFlightSteps extends LaunchApplication {

    private RegistrationPage registrationPage;
    private BookingPage bookingPage;
    private HomePage homePage;


    @Step
    public void userRegisters(DataTable registrationDataTable) throws InterruptedException {
        {
            RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
            Map<String, String> registrationData = registrationDataTable.asMaps(String.class, String.class).get(0);
            registrationPage.userClicksOnRegisterButton();
            registrationPage.insertFirstName(registrationData.get("FirstName"));
            registrationPage.insertLastName(registrationData.get("LastName"));
            registrationPage.insertPhone(registrationData.get("Phone"));
            registrationPage.insertEmail(registrationData.get("Email"));
            registrationPage.insertAddress(registrationData.get("Address"));
            registrationPage.insertCity(registrationData.get("City"));
            registrationPage.insertUserName(registrationData.get("UserName"));
            registrationPage.insertPassword(registrationData.get("Password"));
            registrationPage.insertConfirmPassword(registrationData.get("ConfirmPassword"));
            registrationPage.userClicksOnSubmitButton();
        }
    }

    @Step
    public void assertThatUserNameIsCorrect (String user){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.assertThatUserNameIsCorrect(user);
    }

    @Step
    public void userLoginsWithUserNameAndPassword(String user, String password) {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.userClicksOnSignInLink();
        loginPage.userLoginsWithUserNameAndPassword(user,password);
    }

    @Step
    public void userBooksAFlight(DataTable bookingDetailsTable) throws InterruptedException {
        BookingPage bookingPage = PageFactory.initElements(driver, BookingPage.class);
        Map<String, String> bookingDetails = bookingDetailsTable.asMaps(String.class, String.class).get(0);
        bookingPage.selectsAValueFromDepartingFromDropDown(bookingDetails.get("DepartingFrom"));
        bookingPage.selectsAValueFromMonthDropDown(bookingDetails.get("Month"));
        bookingPage.selectsAValueFromDayDropDown(bookingDetails.get("Day"));
        bookingPage.userClicksOnContinueButtonForFirstPage();
        bookingPage.selectsAValueFromAirlineDepartOptions(bookingDetails.get("Airline"));
        bookingPage.selectsAValueFromAirlineReturnOptions(bookingDetails.get("Airline"));
        bookingPage.userClicksOnContinueButtonForSecondPage();
        bookingPage.userClicksOnSecurePurchaseButton();
    }

    @Step
    public void assertThatBookingDetailsAreCorrect(DataTable bookingDetailsTable) {
        BookingPage bookingPage = PageFactory.initElements(driver, BookingPage.class);
        Map<String, String> bookingDetails = bookingDetailsTable.asMaps(String.class, String.class).get(0);
        bookingPage.assertThatBookingDetailsAreCorrect(bookingDetails.get("DepartingFrom"),bookingDetails.get("Month"),bookingDetails.get("Day"),bookingDetails.get("Airline"));
    }

    public void userTriesToLoginWithInvalidUserNameOrPassword(String user, String password) {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.userClicksOnSignInButton();
        loginPage.userLoginsWithUserNameAndPassword(user,password);
    }

    public void assertThatUserCantGoToBookingPage() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.assertThatUserNameOrPasswordIsntCorrect();
    }

    public void assertThatTheWebsitePageIsOpened() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.assertThatTheWebsitePageIsOpened();
    }

    public void userChecksOutTheLowestPriceDestination() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clicksOnHomePageLink();
        homePage.selectAndPrintTheLowestDestinationPrice();
    }
}