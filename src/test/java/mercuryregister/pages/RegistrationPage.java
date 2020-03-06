package mercuryregister.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2)")
    private WebElement registerButton;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > input")
    private WebElement firstNameField;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input")
    private WebElement lastNameField;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(4) > td:nth-child(2) > input")
    private WebElement phoneField;
    @FindBy(css = "#userName")
    private WebElement emailField;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input")
    private WebElement addressField;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(9) > td:nth-child(2) > input")
    private WebElement cityField;
    @FindBy(css = "#email")
    private WebElement userNameField;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(15) > td:nth-child(2) > input[type=password]")
    private WebElement passwordField;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(16) > td:nth-child(2) > input[type=password]")
    private WebElement confirmPasswordField;
    @FindBy(css = "body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(18) > td > input[type=image]")
    private WebElement submitButton;


    WebDriver driver;
    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }

    public void userClicksOnRegisterButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By registerButtonQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2)");
        wait.until(ExpectedConditions.presenceOfElementLocated(registerButtonQuery));
        registerButton.click();
    }

    public void insertFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By firstNameFieldQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > input");
        wait.until(ExpectedConditions.presenceOfElementLocated(firstNameFieldQuery));
        firstNameField.sendKeys(firstName);
    }

    public void insertLastName(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By lastNameFieldQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input");
        wait.until(ExpectedConditions.presenceOfElementLocated(lastNameFieldQuery));
        lastNameField.sendKeys(lastName);
    }

    public void insertPhone(String phone) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By phoneFieldQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(4) > td:nth-child(2) > input");
        wait.until(ExpectedConditions.presenceOfElementLocated(phoneFieldQuery));
        phoneField.sendKeys(phone);
    }

    public void insertEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By emailFieldQuery = By.cssSelector("#userName");
        wait.until(ExpectedConditions.presenceOfElementLocated(emailFieldQuery));
        emailField.sendKeys(email);
    }

    public void insertAddress(String address) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By addressFieldQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input");
        wait.until(ExpectedConditions.presenceOfElementLocated(addressFieldQuery));
        addressField.sendKeys(address);
    }

    public void insertCity(String city) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By cityFieldQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(9) > td:nth-child(2) > input");
        wait.until(ExpectedConditions.presenceOfElementLocated(cityFieldQuery));
        cityField.sendKeys(city);
    }

    public void insertUserName(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By userNameFieldQuery = By.cssSelector("#email");
        wait.until(ExpectedConditions.presenceOfElementLocated(userNameFieldQuery));
        userNameField.sendKeys(userName);
    }

    public void insertPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By passwordFieldQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(15) > td:nth-child(2) > input[type=password]");
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordFieldQuery));
        passwordField.sendKeys(password);
    }

    public void insertConfirmPassword(String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By confirmPasswordFieldQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(16) > td:nth-child(2) > input[type=password]");
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmPasswordFieldQuery));
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void userClicksOnSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By submitButtonQuery = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(18) > td > input[type=image]");
        wait.until(ExpectedConditions.presenceOfElementLocated(submitButtonQuery));
        submitButton.click();
    }
}
